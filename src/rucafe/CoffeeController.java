package rucafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

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

    public void initialize() {

        ArrayList<String> coffeeSizeList = new ArrayList<>();
        for (COFFEE_SIZE type : COFFEE_SIZE.values()) {
            coffeeSizeList.add(type.getName());
        }

        ObservableList<String> coffeeSizes = FXCollections.observableArrayList(coffeeSizeList);
        sizeList.setItems(coffeeSizes);

        quantityText.setText("1");

        // TODO: INITIALIZE SUBTOTAL HERE TO DISPLAY INITIALLY
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

    public void addToOrder(ActionEvent actionEvent) {
        if (sizeList.getValue() == null) {
            sendWarning("Please Choose A Size");
            resetCoffeeMenu();
            return;
        }

        // TODO: add to order
    }

    public void resetCoffeeMenu() {
        creamAddIn.setSelected(false);
        syrupAddIn.setSelected(false);
        milkAddIn.setSelected(false);
        caramelAddIn.setSelected(false);
        whippedcreamAddIn.setSelected(false);
        quantityText.setText("1");
        // TODO: RESET SUBTOTAL TO 0 HERE
        return;
    }
    public void handleCream(ActionEvent actionEvent) {
        if (!creamAddIn.isSelected()) {
            // TODO: REMOVE IT FROM SUBTOTAL
            return;
        }

        // TODO: ADD TO SUBTOTAL IT HAS BEEN SELECTED
    }

    public void handleSyrup(ActionEvent actionEvent) {
        if (!syrupAddIn.isSelected()) {
            // TODO: REMOVE IT FROM SUBTOTAL
            return;
        }

        // TODO: ADD TO SUBTOTAL IT HAS BEEN SELECTED
    }

    public void handleMilk(ActionEvent actionEvent) {
        if (!milkAddIn.isSelected()) {
            // TODO: REMOVE IT FROM SUBTOTAL
            return;
        }

        // TODO: ADD TO SUBTOTAL IT HAS BEEN SELECTED
    }

    public void handleCaramel(ActionEvent actionEvent) {
        if (!caramelAddIn.isSelected()) {
            // TODO: REMOVE IT FROM SUBTOTAL
            return;
        }

        // TODO: ADD TO SUBTOTAL IT HAS BEEN SELECTED
    }

    public void handleWhippedCream(ActionEvent actionEvent) {
        if (!whippedcreamAddIn.isSelected()) {
            // TODO: REMOVE IT FROM SUBTOTAL
            return;
        }

        // TODO: ADD TO SUBTOTAL IT HAS BEEN SELECTED
    }

    public void handleSize(ActionEvent actionEvent) {
        // TODO: CALCULATE SUBTOTAL BASED OFF SIZE
    }
}
