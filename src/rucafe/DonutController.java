package rucafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.DecimalFormat;
import java.util.ArrayList;

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

    DonutCart cart;

    public void initialize() {
        // TODO: set a default donut type to avoid exception
        cart = new DonutCart();

        ArrayList<String> donutTypesList = new ArrayList<>();
        for (DONUT_TYPE type : DONUT_TYPE.values()) {
            donutTypesList.add(type.getName());
        }
        ObservableList<String> donutTypes = FXCollections.observableArrayList(donutTypesList);
        donutSelection.setItems(donutTypes);

        quantityText.setText("1");
    }

    public void incrementQuantity(ActionEvent actionEvent) {
        int incrementValue = Integer.parseInt(quantityText.getText());
        incrementValue++;
        quantityText.setText(String.valueOf(incrementValue));
    }

    public void decrementQuantity(ActionEvent actionEvent) {
        int decrementValue = Integer.parseInt(quantityText.getText());

        if (decrementValue == 1) {
            sendWarning("Cannot choose a quantity less than 1 to add to order.");
            return;
        }
        decrementValue--;
        quantityText.setText(String.valueOf(decrementValue));
    }

    public void sendWarning (String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning!!");
        alert.setHeaderText("Invalid Command");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void setFlavors(ActionEvent actionEvent) {
        if  (donutSelection.getValue().toString().equals("Yeast Donut")) {
            ObservableList<String> yeastTypes = FXCollections.observableArrayList(DONUT_TYPE.YEAST.getFlavors());
            flavorDonuts.setItems(yeastTypes);
        } else if (donutSelection.getValue().toString().equals("Cake Donut")) {
            ObservableList<String> cakeTypes = FXCollections.observableArrayList(DONUT_TYPE.CAKE.getFlavors());
            flavorDonuts.setItems(cakeTypes);
        } else if (donutSelection.getValue().toString().equals("Donut Holes")) {
            ObservableList<String> holeTypes = FXCollections.observableArrayList(DONUT_TYPE.HOLE.getFlavors());
            flavorDonuts.setItems(holeTypes);
        } else {
            flavorDonuts.setItems(null);
        }
    }

    private void setSubtotalText() {
        double subtotal = cart.getTotalPrice();

        DecimalFormat df = new DecimalFormat("#.##");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        df.setMinimumFractionDigits(2);

        String subtotalString = df.format(subtotal);

        subtotalText.setText("$" + subtotalString);
    }

    public void resetDonutMenu() {
        flavorDonuts.setItems(null);
        donutSelection.setValue("");
        quantityText.setText("1");
    }

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
        ObservableList<String> cartString = FXCollections.observableArrayList(this.cart.cartToString());
        donutOrderList.setItems(cartString);

        setSubtotalText();

        resetDonutMenu();
        return;
    }

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
        ObservableList<String> cartString = FXCollections.observableArrayList(this.cart.cartToString());
        donutOrderList.setItems(cartString);

        setSubtotalText();

        resetDonutMenu();
        return;
    }
}
