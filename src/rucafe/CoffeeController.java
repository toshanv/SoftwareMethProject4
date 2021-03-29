package rucafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Controller class for the Coffee Menu GUI. Users can customize their coffee order, view the subtotal, and add to the order.
 *
 * @author Toshanraju Vysyaraju
 * @author Christopher Nguyen
 */
public class CoffeeController {
    @FXML
    public ComboBox sizeList;

    @FXML
    public TextField quantityText;

    @FXML
    public CheckBox creamAddIn;

    @FXML
    public CheckBox syrupAddIn;

    @FXML
    public CheckBox milkAddIn;

    @FXML
    public CheckBox caramelAddIn;

    @FXML
    public CheckBox whippedcreamAddIn;

    @FXML
    public TextField subtotalText;

    @FXML
    public Button addToOrder;

    Coffee coffee;

    /**
     * Initializes the Coffee Menu GUI
     */
    public void initialize() {
        // loop through size enum and populate the drop down with the string names
        ArrayList<String> coffeeSizeList = new ArrayList<>();
        for (COFFEE_SIZE type : COFFEE_SIZE.values()) {
            coffeeSizeList.add(type.getName());
        }

        ObservableList<String> coffeeSizes = FXCollections.observableArrayList(coffeeSizeList);
        sizeList.setItems(coffeeSizes);

        // set initial quantity to 1
        quantityText.setText("1");

        // create coffee object
        this.coffee = new Coffee();
        this.coffee.setCount(1);

        // calculate the subtotal and display
        setSubtotalText();
    }

    /**
     * Increments the quantity of coffee being ordered
     * @param actionEvent passed when the increment quantity button is pressed
     */
    public void incrementQuantity(ActionEvent actionEvent) {
        int incrementValue = Integer.parseInt(quantityText.getText());
        incrementValue++;

        quantityText.setText(String.valueOf(incrementValue));

        // set the coffee count
        this.coffee.setCount(incrementValue);

        // recalculate the subtotal and display
        setSubtotalText();
    }

    /**
     * Decrements the quantity of coffee being ordered
     * @param actionEvent passed when the decrement quantity button is pressed
     */
    public void decrementQuantity(ActionEvent actionEvent) {
        int decrementValue = Integer.parseInt(quantityText.getText());

        if (decrementValue == 1) {
            sendWarning("Cannot choose a quantity less than 1 to add to order.");
            return;
        }

        decrementValue--;
        quantityText.setText(String.valueOf(decrementValue));

        // set the coffee count
        this.coffee.setCount(decrementValue);

        // recalculate the subtotal and display
        setSubtotalText();
    }

    /**
     * Calculates and displays the current subtotal of the coffee being ordered
     */
    private void setSubtotalText() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        df.setMinimumFractionDigits(2);

        double subtotal = this.coffee.itemPrice();
        String subtotalString = df.format(subtotal);
        subtotalText.setText("$" + subtotalString);
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
     * Adds the current coffee object to the order and closes the menu
     * @param actionEvent passed when the add to order button is pressed
     */
    public void addToOrder(ActionEvent actionEvent) {
        // check if a size has been selected
        if (this.coffee.getSize() == null) {
            sendWarning("Please Choose A Size");
            return;
        }

        // add coffee to order and validate that it was added properly
        boolean addedSuccessfully = MainMenuController.order.add(this.coffee);
        if (!addedSuccessfully) {
            sendWarning("Issue with adding to order, please try again");
            return;
        }

        // TODO: confirmation window

        // close the coffee menu
        Stage stage = (Stage) addToOrder.getScene().getWindow();
        stage.close();
    }

    // TODO: check if we can get rid of this method
    /**
     * Resets the Coffee Menu
     */
    public void resetCoffeeMenu() {
        // reset the add-in choices
        creamAddIn.setSelected(false);
        syrupAddIn.setSelected(false);
        milkAddIn.setSelected(false);
        caramelAddIn.setSelected(false);
        whippedcreamAddIn.setSelected(false);

        // reset the quantity
        quantityText.setText("1");

        // reset the coffee object
        this.coffee = new Coffee();

        // recalculate the subtotal and display
        setSubtotalText();
    }

    /**
     * Handles when the cream add-in is added or removed from the current coffee object
     * @param actionEvent passed when cream is checked of unchecked
     */
    public void handleCream(ActionEvent actionEvent) {
        if (!creamAddIn.isSelected()) {
            // cream is unselected
            boolean removed = this.coffee.remove(ADDINS.CREAM);

            if (!removed) {
                // unable to remove
                creamAddIn.setSelected(true);
                sendWarning("Cream was unable to be removed, please try again");
            }
        } else {
            // cream is selected
            boolean added = this.coffee.add(ADDINS.CREAM);

            if (!added) {
                // unable to add
                creamAddIn.setSelected(false);
                sendWarning("Cream was unable to be added, please try again");
            }
        }

        // recalculate the subtotal and display
        setSubtotalText();
    }

    /**
     * Handles when the syrup add-in is added or removed from the current coffee object
     * @param actionEvent passed when syrup is checked of unchecked
     */
    public void handleSyrup(ActionEvent actionEvent) {
        if (!syrupAddIn.isSelected()) {
            // syrup is unselected
            boolean removed = this.coffee.remove(ADDINS.SYRUP);

            if (!removed) {
                // unable to remove
                syrupAddIn.setSelected(true);
                sendWarning("Syrup was unable to be removed, please try again");
            }
        } else {
            // syrup is selected
            boolean added = this.coffee.add(ADDINS.SYRUP);

            if (!added) {
                // unable to add
                syrupAddIn.setSelected(false);
                sendWarning("Syrup was unable to be added, please try again");
            }
        }

        // recalculate the subtotal and display
        setSubtotalText();
    }

    /**
     * Handles when the milk add-in is added or removed from the current coffee object
     * @param actionEvent passed when milk is checked of unchecked
     */
    public void handleMilk(ActionEvent actionEvent) {
        if (!milkAddIn.isSelected()) {
            // milk is unselected
            boolean removed = this.coffee.remove(ADDINS.MILK);

            if (!removed) {
                // unable to remove
                milkAddIn.setSelected(true);
                sendWarning("Milk was unable to be removed, please try again");
            }
        } else {
            // milk is selected
            boolean added = this.coffee.add(ADDINS.MILK);

            if (!added) {
                // unable to add
                milkAddIn.setSelected(false);
                sendWarning("Milk was unable to be added, please try again");
            }
        }

        // recalculate the subtotal and display
        setSubtotalText();
    }

    /**
     * Handles when the caramel add-in is added or removed from the current coffee object
     * @param actionEvent passed when caramel is checked of unchecked
     */
    public void handleCaramel(ActionEvent actionEvent) {
        if (!caramelAddIn.isSelected()) {
            // caramel is unselected
            boolean removed = this.coffee.remove(ADDINS.CARAMEL);

            if (!removed) {
                // unable to remove
                caramelAddIn.setSelected(true);
                sendWarning("Caramel was unable to be removed, please try again");
            }
        } else {
            // milk is selected
            boolean added = this.coffee.add(ADDINS.CARAMEL);

            if (!added) {
                // unable to add
                caramelAddIn.setSelected(false);
                sendWarning("Caramel was unable to be added, please try again");
            }
        }

        // recalculate the subtotal and display
        setSubtotalText();
    }

    /**
     * Handles when the whipped cream add-in is added or removed from the current coffee object
     * @param actionEvent passed when whipped cream is checked of unchecked
     */
    public void handleWhippedCream(ActionEvent actionEvent) {
        if (!whippedcreamAddIn.isSelected()) {
            // whipped cream is unselected
            boolean removed = this.coffee.remove(ADDINS.WHIPPED_CREAM);

            if (!removed) {
                // unable to remove
                whippedcreamAddIn.setSelected(true);
                sendWarning("Whipped Cream was unable to be removed, please try again");
            }
        } else {
            // milk is selected
            boolean added = this.coffee.add(ADDINS.WHIPPED_CREAM);

            if (!added) {
                // unable to add
                whippedcreamAddIn.setSelected(false);
                sendWarning("Whipped Cream was unable to be added, please try again");
            }
        }

        // recalculate the subtotal and display
        setSubtotalText();
    }

    /**
     * Updates the size of the current coffee object
     * @param actionEvent passed when a size is selected from the drop down
     */
    public void handleSize(ActionEvent actionEvent) {
        // check that something is selected
        if (sizeList.getValue() == null) {
            this.coffee.setSize(null);

            // recalculate the subtotal and display
            setSubtotalText();
            return;
        }

        // determine the size
        COFFEE_SIZE sizeOfCoffee = null;
        for (COFFEE_SIZE size : COFFEE_SIZE.values()) {
            if (size.getName().equals(sizeList.getValue().toString())) {
                sizeOfCoffee = size;
            }
        }

        // set the size for the coffee object
        this.coffee.setSize(sizeOfCoffee);

        // recalculate the subtotal and display
        setSubtotalText();
    }
}
