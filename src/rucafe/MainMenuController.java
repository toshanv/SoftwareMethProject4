package rucafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class MainMenuController {

    // TODO: initialize orders and store orders here
    public static Order order;

    private int orderNumber = 0;
    private boolean orderExist = false;

    public void handleClickOrderDonuts(ActionEvent actionEvent) {
        try {
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

            if (!orderExist) {
                // initialize current order if one does not exist already
                this.order = new Order(this.orderNumber);

                this.orderExist = true;

                this.orderNumber++;
            }

            // disable main menu after opening donut window
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            // TODO: replace with alert
            // System.out.print("Can't Load New Window");
        }
    }

    public boolean addToOrder(Object obj) {
        return this.order.add(obj);
    }
}
