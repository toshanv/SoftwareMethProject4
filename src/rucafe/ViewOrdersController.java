package rucafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.text.DecimalFormat;
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
        // display the current order items
        updateOrderDisplay();

        // calculate and display the price breakdown
        setPrices();
    }

    public void updateOrderDisplay() {
        ObservableList<String> orderString = FXCollections.observableArrayList(MainMenuController.order.orderToStringList());
        itemList.setItems(orderString);
    }

    public void removeItem(ActionEvent actionEvent) {
        if (itemList.getSelectionModel().getSelectedItem() == null) {
            sendWarning("You did not select item to remove");
            return;
        }

        // TODO: find what item to remove

        // TODO: remove item

        // TODO: set selection to null

        // TODO: redisplay the items in order

        // TODO: update the price breakdown
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

    public void setPrices() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        df.setMinimumFractionDigits(2);

        double subtotal = MainMenuController.order.getSubtotal();
        String subtotalString = df.format(subtotal);
        subtotalText.setText("$" + subtotalString);

        double salestax = subtotal * Constants.SALESTAX_PERCENTAGE;
        String salestaxString = df.format(salestax);
        salestaxText.setText("$" + salestaxString);

        double total = subtotal + salestax;
        String totalString = df.format(total);
        totalText.setText("$" + totalString);
    }

    // TODO: Display Subtotal, Tax, and price for the specific item selected
    public void handleItemSelected(MouseEvent mouseEvent) {
        if (itemList.selectionModelProperty() == null) {
            // calculate and display the price breakdown of full order
            setPrices();
            return;
        }

        // TODO: Display Subtotal, Tax, and price for the specific item selected
    }
}
