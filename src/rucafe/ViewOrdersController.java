package rucafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class ViewOrdersController {

    @FXML
    public ListView itemList;

    @FXML
    public TextField subtotalText;

    @FXML
    public TextField salestaxText;

    @FXML
    public TextField totalText;


    public void initialize() {
        // TODO: Initialize list display here and original price values for subtotal tax and total created vars for u already above
    }

    // TODO: Remove Item that is selected in the menu
    // TODO: Do not forget to change the display after removing item
    public void removeItem(ActionEvent actionEvent) {
        if (itemList.getSelectionModel().getSelectedItem() == null) {
            sendWarning("You did not select item to remove");
        }
    }

    // TODO: Confirmation page and close window - FOR CHRIS
    public void placeOrder(ActionEvent actionEvent) {
        if (itemList.getSelectionModel() == null) {
            sendWarning("You have no items in your order");
        }
    }

    public void sendWarning (String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning!!");
        alert.setHeaderText("Invalid Command");
        alert.setContentText(message);
        alert.showAndWait();
    }

    // TODO: Display Subtotal, Tax, and price for the specific item selected
    public void handleItemSelected(MouseEvent mouseEvent) {
        if (itemList.selectionModelProperty() == null) {
            // TODO: Display the subtotal tax and price of whole order
        }

        // TODO: Display Subtotal, Tax, and price for the specific item selected
    }
}
