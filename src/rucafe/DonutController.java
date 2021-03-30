package rucafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Controller class for the Donut Menu GUI. Users can add donuts to the cart, remove donuts from the cart, and add all items from the cart to the order.
 *
 * @author Toshanraju Vysyaraju
 * @author Christopher Nguyen
 */
public class DonutController {
    @FXML
    public TextField quantityText;

    @FXML
    public ComboBox donutSelection;

    @FXML
    public ListView flavorDonuts;

    @FXML
    public ListView donutOrderList;

    @FXML
    public TextField subtotalText;

    @FXML
    public Button addToOrder;

    DonutCart cart;

    /**
     * Initializes the Donut Menu GUI
     */
    public void initialize() {
        cart = new DonutCart();

        ArrayList<String> donutTypesList = new ArrayList<>();
        for (DONUT_TYPE type : DONUT_TYPE.values()) {
            donutTypesList.add(type.getName());
        }

        ObservableList<String> donutTypes = FXCollections.observableArrayList(donutTypesList);
        donutSelection.setItems(donutTypes);

        quantityText.setText("1");
        setSubtotalText();
    }

    /**
     * Increments the quantity of donuts being ordered
     * @param actionEvent passed when the increment quantity button is pressed
     */
    public void incrementQuantity(ActionEvent actionEvent) {
        int incrementValue = Integer.parseInt(this.quantityText.getText());
        incrementValue++;
        this.quantityText.setText(String.valueOf(incrementValue));
    }

    /**
     * Decrements the quantity of donuts being ordered
     * @param actionEvent passed when the decrement quantity button is pressed
     */
    public void decrementQuantity(ActionEvent actionEvent) {
        int decrementValue = Integer.parseInt(this.quantityText.getText());

        if (decrementValue == 1) {
            sendWarning("Cannot choose a quantity less than 1 to add to order.");
            return;
        }

        decrementValue--;
        this.quantityText.setText(String.valueOf(decrementValue));
    }

    /**
     * Displays warning with that passed in message
     * @param message to display on the warning
     */
    public void sendWarning (String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning!!");
        alert.setHeaderText("Invalid Command");
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Sets the display to show the flavors for each type of Donut
     * @param actionEvent passed when a type of donut is selected
     */
    public void setFlavors(ActionEvent actionEvent) {
        if (donutSelection.getValue() == null) {
            flavorDonuts.setItems(null);
        } else if (donutSelection.getValue().toString().equals("Yeast Donut")) {
            ObservableList<String> yeastTypes = FXCollections.observableArrayList(DONUT_TYPE.YEAST.getFlavors());
            flavorDonuts.setItems(yeastTypes);
        } else if (donutSelection.getValue().toString().equals("Cake Donut")) {
            ObservableList<String> cakeTypes = FXCollections.observableArrayList(DONUT_TYPE.CAKE.getFlavors());
            flavorDonuts.setItems(cakeTypes);
        } else if (donutSelection.getValue().toString().equals("Donut Holes")) {
            ObservableList<String> holeTypes = FXCollections.observableArrayList(DONUT_TYPE.HOLE.getFlavors());
            flavorDonuts.setItems(holeTypes);
        }
    }

    /**
     * Calculates and displays the subtotal of all donuts in the cart
     */
    private void setSubtotalText() {
        double subtotal = this.cart.getTotalPrice();

        DecimalFormat df = new DecimalFormat("#.##");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        df.setMinimumFractionDigits(2);

        String subtotalString = df.format(subtotal);

        subtotalText.setText("$" + subtotalString);
    }

    /**
     * Resets all selections in the Donut Menu GUI
     */
    public void resetDonutMenu() {
        this.flavorDonuts.setItems(null);
        this.donutSelection.setValue("");
        this.quantityText.setText("1");
    }

    /**
     * Adds the current donut object to the cart
     * @param actionEvent passed when the add to cart button is pressed
     */
    public void insertToCart(ActionEvent actionEvent) {
        // error checks
        if (flavorDonuts.getSelectionModel().getSelectedItem() == null && (donutSelection.getValue() == null || donutSelection.getValue().equals(""))) {
            sendWarning("Please select a donut and a flavor for the donut.");
            return;
        } else if (flavorDonuts.getSelectionModel().getSelectedItem() == null) {
            sendWarning("Please Select A Flavor.");
            return;
        }

        // get the type of donut
        DONUT_TYPE typeOfDonut = null;
        for (DONUT_TYPE type : DONUT_TYPE.values()) {
            if (type.getName().equals(donutSelection.getValue().toString())) {
                typeOfDonut = type;
            }
        }

        // get the flavor of the donut
        String flavorOfDonut = flavorDonuts.getSelectionModel().getSelectedItem().toString();

        // get the quantity of the donut
        int quantityOfDonut = Integer.parseInt(quantityText.getText());

        // create the donut object
        Donut donutToAdd = new Donut(quantityOfDonut, typeOfDonut, flavorOfDonut);

        // add the donut to the cart
        cart.addToCart(donutToAdd);

        // get the cart as a string to display
        ObservableList<String> cartString = FXCollections.observableArrayList(this.cart.cartToStringList());
        donutOrderList.setItems(cartString);

        // calculate and display subtotal
        setSubtotalText();

        resetDonutMenu();
        return;
    }

    /**
     * Removes the selected donut from the cart
     * @param actionEvent passed when the removed from cart button is pressed
     */
    public void removeFromCart(ActionEvent actionEvent) {
        // error checks
        if (this.cart.getSize() == 0) {
            sendWarning("The cart is empty, nothing to remove.");
            return;
        } else if (donutOrderList.getSelectionModel().getSelectedItem() == null) {
            sendWarning("Please select a donut to remove from the cart.");
            return;
        }

        // create donut object using the selected donut in the cart
        Donut toRemove = this.cart.getDonut((int)donutOrderList.getSelectionModel().getSelectedIndices().get(0));

        // remove the donut
        this.cart.removeFromCart(toRemove);

        // get the cart as a string to display
        ObservableList<String> cartString = FXCollections.observableArrayList(this.cart.cartToStringList());
        donutOrderList.setItems(cartString);

        // calculate and display subtotal
        setSubtotalText();

        resetDonutMenu();
        return;
    }

    /**
     * Adds all donuts in the cart to the current order
     * @param actionEvent passed when the add to order button is pressed
     */
    public void addToOrder(ActionEvent actionEvent) {
        // error checks
        if (this.cart.getSize() == 0) {
            sendWarning("There is nothing to add to order. Please add donuts to the cart first.");
            return;
        }

        // confirmation alert that performs add to order based on button click
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm Add To Order?", ButtonType.YES, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            for (Donut toAdd : this.cart.getCart()) {
                boolean addedSuccessfully = MainMenuController.order.add(toAdd);

                if (!addedSuccessfully) {
                    sendWarning("Issue with adding to order, please try again");
                    return;
                }
            }

            Stage stage = (Stage) addToOrder.getScene().getWindow();
            stage.close();

            return;
        } else if (alert.getResult() == ButtonType.CANCEL) {
            alert.close();
            return;
        }

        return;

    }
}
