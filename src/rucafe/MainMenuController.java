package rucafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainMenuController {
    public void handleClickOrderDonuts(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader;
            fxmlLoader = new FXMLLoader(getClass().getResource("Donut.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("Ru Cafe Donut Menu");
            stage.setScene(new Scene(root1));
            stage.setX(600);
            stage.setY(200);
            stage.showAndWait();
        } catch (Exception e) {
            System.out.print("Can't Load New Window");
        }
    }
}
