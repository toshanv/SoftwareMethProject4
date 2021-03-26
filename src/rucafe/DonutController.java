package rucafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

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

    // TODO: should closing the donut controller clear the cart?

    // TODO: do all these functions need @FXML tags?
    public void initialize() {
        // TODO: set a default donut type to avoid exception
        ArrayList<String> donutTypesList = new ArrayList<>();
        for (Constants.DONUT_TYPE type : Constants.DONUT_TYPE.values()) {
            donutTypesList.add(type.getName());
        }
        ObservableList<String> donutTypes = FXCollections.observableArrayList(donutTypesList);
        donutSelection.setItems(donutTypes);

        quantityText.setText("1");
    }

    public void incrementQuantity(ActionEvent actionEvent) {
        int incrementValue = Integer.parseInt(quantityText.getText());
        incrementValue++;
        quantityText.setText(String.valueOf(incrementValue));
    }

    public void decrementQuantity(ActionEvent actionEvent) {
        int decrementValue = Integer.parseInt(quantityText.getText());

        if (decrementValue == 1) {
            sendWarning("Cannot choose a quantity less than 1 to add to order.");
            return;
        }
        decrementValue--;
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
            ObservableList<String> yeastTypes = FXCollections.observableArrayList(Constants.DONUT_TYPE.YEAST.getFlavors());
            flavorDonuts.setItems(yeastTypes);
        } else if (donutSelection.getValue().toString().equals("Cake Donut")) {
            ObservableList<String> cakeTypes = FXCollections.observableArrayList(Constants.DONUT_TYPE.CAKE.getFlavors());
            flavorDonuts.setItems(cakeTypes);
        } else if (donutSelection.getValue().toString().equals("Donut Holes")) {
            ObservableList<String> holeTypes = FXCollections.observableArrayList(Constants.DONUT_TYPE.HOLE.getFlavors());
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

    public void insertToCart(ActionEvent actionEvent) {
        if (flavorDonuts.getSelectionModel().getSelectedItem() == null && (donutSelection.getValue() == null || donutSelection.getValue().equals(""))) {
            sendWarning("Please select a donut and a flavor for the donut.");
            return;
        } else if (flavorDonuts.getSelectionModel().getSelectedItem() == null) {
            sendWarning("Please Select A Flavor.");
            return;
        }

        Constants.DONUT_TYPE typeOfDonut = null;
        for (Constants.DONUT_TYPE type : Constants.DONUT_TYPE.values()) {
            if (type.getName().equals(donutSelection.getValue().toString())) {
                typeOfDonut = type;
            }
        }

        String flavorOfDonut = flavorDonuts.getSelectionModel().getSelectedItem().toString();
        int quantityOfDonut = Integer.parseInt(quantityText.getText());

        Donut donutToAdd = new Donut(quantityOfDonut, typeOfDonut, flavorOfDonut);
        donutToAdd.add(donutToAdd);

        // donutOrders.add(flavorDonuts.getSelectionModel().getSelectedItem().toString() + "(" + quantityText.getText() + ')');
        // donutOrderList.setItems(donutOrders);

        ObservableList<String> cartString = FXCollections.observableArrayList(donutToAdd.cartToString());
        donutOrderList.setItems(cartString);

        resetDonutMenu();
        return;
    }

    public void removeFromCart(ActionEvent actionEvent) {
        // check that something is selected
        if (Donut.cart.size() == 0) {
            sendWarning("The cart is empty, nothing to remove.");
            return;
        } else if (donutOrderList.getSelectionModel().getSelectedItem() == null) {
            sendWarning("Please select a donut to remove from the cart.");
            return;
        }

        // create donut object using the string
        Donut toRemove = Donut.cart.get((int)donutOrderList.getSelectionModel().getSelectedIndices().get(0));
        toRemove.remove(toRemove);

        ObservableList<String> cartString = FXCollections.observableArrayList(toRemove.cartToString());
        donutOrderList.setItems(cartString);

        resetDonutMenu();
        return;
    }
}
