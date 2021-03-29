package rucafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

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

    public void cancelOrder(ActionEvent actionEvent) {
        if (this.orderList.getValue() == null) {
            sendWarning("No order has been selected to cancel");
            return;
        }

        // find and create object for order to remove
        int orderNum = Integer.parseInt(orderList.getValue().toString());
        Order toRemove = MainMenuController.storeOrders.getOrder(orderNum);

        // remove the order from storeOrders
        boolean removedSuccessfully = MainMenuController.storeOrders.remove(toRemove);

        if (!removedSuccessfully) {
            sendWarning("Order was unable to be cancelled. Please try again.");
            return;
        }

        // TODO: confirmation window

        // update order nums list
        setOrderList();
    }

    public void exportOrder(ActionEvent actionEvent) {
        if (MainMenuController.storeOrders.getSize() == 0) {
            sendWarning("There are no orders to export.");
            return;
        }

        // TODO: create file and export

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Target File for Export");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
        File targetFile = chooser.showSaveDialog(stage);

        MainMenuController.storeOrders.export(targetFile);
    }

    public void sendWarning (String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning!!");
        alert.setHeaderText("Invalid Command");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
