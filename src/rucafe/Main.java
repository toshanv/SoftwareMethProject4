package rucafe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * This class is the main driver that runs the program and starts the application
 *
 * @author Christopher Nguyen
 * @author Toshanraju Vysyaraju
 */
public class Main extends Application {

    /**
     * Starts the application window and sets its parameters
     * @param primaryStage initial stage of the application
     * @throws Exception thrown if application window is not opened properly
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("Ru Cafe Main Menu");
        // TODO: replace magic numbers
        primaryStage.setScene(new Scene(root, 450, 400));
        primaryStage.show();
    }

    /**
     * Main driver that runs the RU Cafe
     * @param args is array of arguments passed in when starting the program
     */
    public static void main(String[] args) {
        launch(args);
    }
}
