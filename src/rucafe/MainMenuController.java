package rucafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 * Controller class for the main menu of the RU Cafe. Users can open donut and coffee menus, open current order, and open all store orders.
 *
 * @author Toshanraju Vysyaraju
 * @author Christopher Nguyen
 */
public class MainMenuController {
    public static Order order;
    public static StoreOrders storeOrders = new StoreOrders();

    private int orderNumber = 0;
    public static boolean orderExist = false;

    /**
     * Opens the Donut Menu GUI
     * @param actionEvent passed when the order donuts button is pressed
     */
    public void handleClickOrderDonuts(ActionEvent actionEvent) {
        try {
            createNewOrder();

            FXMLLoader fxmlLoader;
            FXMLLoader primaryLoader;
            fxmlLoader = new FXMLLoader(getClass().getResource("Donut.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Order Donuts");
            stage.setScene(new Scene(root1));

            // TODO: replace magic nums
            stage.setX(600);
            stage.setY(200);

            // disable main menu after opening donut window
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            sendWarning("Can't Load New Window");
        }
    }

    /**
     * Opens the Coffee Menu GUI
     * @param actionEvent passed when the order coffee button is pressed
     */
    public void handleClickOrderCoffee(ActionEvent actionEvent) {
        try {
            createNewOrder();

            FXMLLoader fxmlLoader;
            FXMLLoader primaryLoader;
            fxmlLoader = new FXMLLoader(getClass().getResource("Coffee.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Order Coffee");
            stage.setScene(new Scene(root1));

            // TODO: replace magic nums
            stage.setX(600);
            stage.setY(200);

            // disable main menu after opening donut window
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            sendWarning("Can't Load New Window");
        }
    }

    /**
     * Opens the Order GUI
     * @param actionEvent passed when the view order button is pressed
     */
    public void handleClickViewOrder(ActionEvent actionEvent) {
        try {
            createNewOrder();

            FXMLLoader fxmlLoader;
            FXMLLoader primaryLoader;
            fxmlLoader = new FXMLLoader(getClass().getResource("ViewOrders.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("View Your Current Order");
            stage.setScene(new Scene(root1));

            // TODO: replace magic nums
            stage.setX(600);
            stage.setY(200);

            // disable main menu after opening donut window
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            sendWarning("Can't Load New Window");
        }
    }

    /**
     * Opens the Store Orders GUI
     * @param actionEvent passed when the view store orders button is pressed
     */
    public void handleClickViewStoreOrders(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader;
            FXMLLoader primaryLoader;
            fxmlLoader = new FXMLLoader(getClass().getResource("ViewStoreOrders.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("View Your Store Orders");
            stage.setScene(new Scene(root1));

            // TODO: replace magic nums
            stage.setX(600);
            stage.setY(200);

            // disable main menu after opening donut window
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            sendWarning("Can't Load New Window");
        }
    }

    /**
     * Creates new order if order does not already exist
     */
    private void createNewOrder() {
        if (!this.orderExist) {
            // initialize current order if one does not exist already
            this.order = new Order(this.orderNumber);

            this.orderExist = true;

            this.orderNumber++;
        }
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
