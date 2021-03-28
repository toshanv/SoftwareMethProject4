package rucafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ViewStoreOrdersController {

    @FXML
    public ComboBox orderList;

    @FXML
    public TextField totalText;

    @FXML
    public ListView displayOrderList;

    public void initialize() {
        // TODO: Initialize orderList here with the list of orders based off their number
    }

    // TODO: BASED On Order Selected from orderList comboBox display the order in displayOrderList
    public void displayOrder(ActionEvent actionEvent) {
        if (orderList.getValue() == null) {
            return;
        }
    }

    // TODO: Cancel the order selected get rid of it from order list
    public void cancelOrder(ActionEvent actionEvent) {
        if (displayOrderList.getSelectionModel() == null || orderList.getValue() == null) {
            sendWarning("No order has been selected to cancel");
        }
    }

    //TODO: EXPORT
    public void exportOrder(ActionEvent actionEvent) {
        if (displayOrderList.getSelectionModel() == null || orderList.getValue() == null) {
            sendWarning("No order has been selected to export");
        }
    }

    public void sendWarning (String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning!!");
        alert.setHeaderText("Invalid Command");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
