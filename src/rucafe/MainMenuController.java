package rucafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class MainMenuController {
    public void handleClickOrderDonuts(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader;
            FXMLLoader primaryLoader;
            fxmlLoader = new FXMLLoader(getClass().getResource("Donut.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            // TODO: wtf is this line
            //stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("Order Donuts");
            stage.setScene(new Scene(root1));
            stage.setX(600);
            stage.setY(200);
            stage.showAndWait();
            // TODO: after opening donut menu, should we disable the main menu so they cant interact with it?
        } catch (Exception e) {
            // println isn't allowed
            //System.out.print("Can't Load New Window");
        }
    }

}
