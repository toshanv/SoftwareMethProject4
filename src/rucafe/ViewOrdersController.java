package rucafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Controller class for the Orders GUI.
 * Users can see all items in the order, see the price breakdown for the order and for each item, remove an item from the order, and place an order.
 *
 * @author Toshanraju Vysyaraju
 * @author Christopher Nguyen
 */
public class ViewOrdersController {

    @FXML
    public ListView itemList;

    @FXML
    public TextField subtotalText;

    @FXML
    public TextField salestaxText;

    @FXML
    public TextField totalText;

    @FXML
    public Button placeOrder;

    /**
     * Initializes the Orders GUI
     */
    public void initialize() {
        // display the current order items
        updateOrderDisplay();

        // calculate and display the price breakdown
        setPrices();
    }

    /**
     * Displays all items in the current order
     */
    public void updateOrderDisplay() {
        ObservableList<String> orderString = FXCollections.observableArrayList(MainMenuController.order.orderToStringList());
        this.itemList.setItems(orderString);
    }

    /**
     * Removes an item from the order
     * @param actionEvent passed when the remove from order button is pressed
     */
    public void removeItem(ActionEvent actionEvent) {
        if (this.itemList.getSelectionModel().getSelectedItem() == null) {
            sendWarning("You did not select item to remove");
            return;
        }

        // create MenuItem object using the selected item in the order
        MenuItem toRemove = MainMenuController.order.getOrderItem((int) this.itemList.getSelectionModel().getSelectedIndices().get(0));

        // remove the selected order item from the order
        boolean removedSuccessfully = MainMenuController.order.remove(toRemove);

        if (!removedSuccessfully) {
            sendWarning("Item was not removed, please try again.");
            return;
        }

        // update the order list to display current order
        updateOrderDisplay();

        // recalculate and display the price breakdown
        setPrices();
    }

    /**
     * Places the current order and adds it to the list of store orders
     * @param actionEvent passed when the place order button is pressed
     */
    public void placeOrder(ActionEvent actionEvent) {
        if (MainMenuController.order.getSize() == 0) {
            sendWarning("You have no items in your order");
            return;
        }

        // add the current order to storeOrders
        boolean addedSuccessfully = MainMenuController.storeOrders.add(MainMenuController.order);

        if (!addedSuccessfully) {
            sendWarning("Order was not able to be placed. Please try again.");
            return;
        }

        MainMenuController.orderExist = false;

        // TODO: Confirmation page - FOR CHRIS

        // added successfully
        Stage stage = (Stage) placeOrder.getScene().getWindow();
        stage.close();
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
     * Calculates and displays the subtotal of all items in the order, the sales tax, and the total price of the order
     */
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

    /**
     * Calculates and displays the subtotal of a specific item in the order, the sales tax for the item, and the total price of the item
     * @param subtotal of the item
     */
    public void setPrices(double subtotal) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        df.setMinimumFractionDigits(2);

        String subtotalString = df.format(subtotal);
        subtotalText.setText("$" + subtotalString);

        double salestax = subtotal * Constants.SALESTAX_PERCENTAGE;
        String salestaxString = df.format(salestax);
        salestaxText.setText("$" + salestaxString);

        double total = subtotal + salestax;
        String totalString = df.format(total);
        totalText.setText("$" + totalString);
    }

    /**
     * Updates information on the display based on what item in the order is selected
     * @param mouseEvent passed when an item in the order is selected
     */
    public void handleItemSelected(MouseEvent mouseEvent) {
        if (itemList.getSelectionModel().getSelectedItem() == null) {
            // calculate and display the price breakdown of full order
            setPrices();
            return;
        }

        // create MenuItem object using the selected item in the order
        MenuItem selectedItem = MainMenuController.order.getOrderItem((int) this.itemList.getSelectionModel().getSelectedIndices().get(0));

        // calculate and display the price breakdown of a specific item
        setPrices(selectedItem.itemPrice());
    }
}
