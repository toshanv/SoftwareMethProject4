package rucafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Controller class for the Store Orders GUI. Users can browse all orders, delete specific orders, and export all orders to a specified file.
 *
 * @author Toshanraju Vysyaraju
 * @author Christopher Nguyen
 */
public class ViewStoreOrdersController {
    @FXML
    public ComboBox orderList;

    @FXML
    public TextField totalText;

    @FXML
    public ListView displayOrderList;

    /**
     * Initializes the Store Orders GUI
     */
    public void initialize() {
        // set orderList with list of order nums
        setOrderList();
    }

    /**
     * Populates the drop down of order numbers with the current list of order numbers in the store orders list
     */
    public void setOrderList() {
        ArrayList<Integer> orderNumsList = MainMenuController.storeOrders.getOrderNumsList();

        ObservableList<Integer> donutTypes = FXCollections.observableArrayList(orderNumsList);
        this.orderList.setItems(donutTypes);
    }

    /**
     * Displays the order based on what order number was selected
     * @param actionEvent passed when an order number is selected from the drop down
     */
    public void displayOrder(ActionEvent actionEvent) {
        if (this.orderList.getValue() == null) {
            this.displayOrderList.setItems(null);
            setTotalText();
            return;
        }

        int orderNum = Integer.parseInt(orderList.getValue().toString());
        ObservableList<String> orderString = FXCollections.observableArrayList(MainMenuController.storeOrders.getOrder(orderNum).orderToStringList());
        this.displayOrderList.setItems(orderString);

        setTotalText();
    }

    /**
     * Calculates and displays the total price of an entire order
     */
    public void setTotalText() {
        if (this.orderList.getValue() == null) {
            this.totalText.setText(null);
            return;
        }

        DecimalFormat df = new DecimalFormat("#.##");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        df.setMinimumFractionDigits(2);

        // calculate the total
        double subtotal = MainMenuController.storeOrders.getOrder(Integer.parseInt(orderList.getValue().toString())).getSubtotal();
        double total = subtotal + subtotal * Constants.SALESTAX_PERCENTAGE;

        // display the total
        String totalString = df.format(total);
        totalText.setText("$" + totalString);
    }

    /**
     * Cancels the order that is currently selected and updates the GUI
     * @param actionEvent passed when the cancel order button is pressed
     */
    public void cancelOrder(ActionEvent actionEvent) {
        if (this.orderList.getValue() == null) {
            sendWarning("No order has been selected to cancel");
            return;
        }

        // confirmation alert that cancels an order based on button click
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm Your Order To Cancel", ButtonType.YES, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            // find and create object for order to remove
            int orderNum = Integer.parseInt(orderList.getValue().toString());
            Order toRemove = MainMenuController.storeOrders.getOrder(orderNum);

            // remove the order from storeOrders
            boolean removedSuccessfully = MainMenuController.storeOrders.remove(toRemove);

            if (!removedSuccessfully) {
                sendWarning("Order was unable to be cancelled. Please try again.");
                return;
            }

            // update order nums list
            setOrderList();

            return;
        } else if (alert.getResult() == ButtonType.CANCEL) {
            alert.close();
            return;
        }

        return;

    }

    /**
     * Exports the store order information into a new file
     * @param actionEvent passed when the export button is pressed
     */
    public void exportOrder(ActionEvent actionEvent) {
        if (MainMenuController.storeOrders.getSize() == 0) {
            sendWarning("There are no orders to export.");
            return;
        }

        // confirmation alert that performs export based on button click
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm Your Order To Export", ButtonType.YES, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            // export order
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Open Target File for Export");
            chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                    new FileChooser.ExtensionFilter("All Files", "*.*"));
            Stage stage = new Stage();
            File targetFile = chooser.showSaveDialog(stage);

            MainMenuController.storeOrders.export(targetFile);

            return;
        } else if (alert.getResult() == ButtonType.CANCEL) {
            alert.close();
            return;
        }

        return;

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
}
