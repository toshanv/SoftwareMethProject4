package rucafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class DonutController {
    @FXML
    public TextField quantityText;

    @FXML
    public ComboBox donutSelection;

    @FXML
    public ListView flavorDonuts;

    @FXML
    public ListView donutOrderList;

    ObservableList<String> donutOrders =  FXCollections.observableArrayList();

    public void initialize() {
        // TODO: set a default donut type to avoid exception
        ObservableList<String> donutTypes = FXCollections.observableArrayList("Yeast Donut", "Cake Donut", "Donut Holes");
        donutSelection.setItems(donutTypes);
        quantityText.setText("1");
    }

    public void incrementQuantity(ActionEvent actionEvent) {
        int incrementValue = Integer.parseInt(quantityText.getText());
        incrementValue ++;
        quantityText.setText(String.valueOf(incrementValue));
    }

    public void decrementQuantity(ActionEvent actionEvent) {
        int decrementValue = Integer.parseInt(quantityText.getText());

        if (decrementValue == 1) {
            sendWarning("Cannot choose a quantity less than 1 to add to order.");
            return;
        }
        decrementValue --;
        quantityText.setText(String.valueOf(decrementValue));
    }

    public void sendWarning (String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning!!");
        alert.setHeaderText("Invalid Command");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void setFlavors(ActionEvent actionEvent) {
        if  (donutSelection.getValue().toString().equals("Yeast Donut")) {
            ObservableList<String> yeastTypes = FXCollections.observableArrayList("Jelly Filled", "Glaze", "Chocolate Frosted", "Lemon Filled");
            flavorDonuts.setItems(yeastTypes);
        } else if (donutSelection.getValue().toString().equals("Cake Donut")) {
            ObservableList<String> cakeTypes = FXCollections.observableArrayList("Old Fashion", "Blueberry", "Cinnamon Sugar");
            flavorDonuts.setItems(cakeTypes);
        } else if (donutSelection.getValue().toString().equals("Donut Holes")) {
            ObservableList<String> holeTypes = FXCollections.observableArrayList("Cinnamon Sugar Holes", "Blueberry holes", "Jelly Holes");
            flavorDonuts.setItems(holeTypes);
        } else {
            flavorDonuts.setItems(null);
        }
    }

    public void resetDonutMenu() {
        flavorDonuts.setItems(null);
        donutSelection.setValue("");
        quantityText.setText("1");
    }

    public void insertToOrder(ActionEvent actionEvent) {
        if (flavorDonuts.getSelectionModel().getSelectedItem() == null && (donutSelection.getValue() == null || donutSelection.getValue().equals(""))) {
            sendWarning("Please select a donut and a flavor for the donut.");
            return;
        } else if (flavorDonuts.getSelectionModel().getSelectedItem() == null) {
            sendWarning("Please Select A Flavor.");
        }

        // THIS IS WHERE WE CREATE DONUT OBJ
        String typeOfDonut = donutSelection.getValue().toString();
        String flavorOfDonut = flavorDonuts.getSelectionModel().getSelectedItem().toString();
        String quantityOfDonut = quantityText.getText();

        donutOrders.add(flavorDonuts.getSelectionModel().getSelectedItem().toString() + "(" + quantityText.getText() + ')');
        donutOrderList.setItems(donutOrders);
        resetDonutMenu();
        return;
    }
}
