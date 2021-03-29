package rucafe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class StoreOrders implements Customizable {

    private ArrayList<Order> storeOrders;

    public StoreOrders() {
        this.storeOrders = new ArrayList<>();
    }

    public ArrayList<Integer> getOrderNumsList() {
        ArrayList<Integer> orderNumsList = new ArrayList<>();

        for (Order order : this.storeOrders) {
            orderNumsList.add(order.getOrderNum());
        }

        return orderNumsList;
    }

    public Order getOrder(int orderNum) {
        for (Order order : this.storeOrders) {
            if (order.getOrderNum() == orderNum) {
                return order;
            }
        }

        return null;
    }

    public int getSize() {
        return this.storeOrders.size();
    }

    @Override
    public boolean add(Object obj) {
        if (obj instanceof Order) {
            // cast obj to Order object
            Order toAdd = (Order) obj;

            // add order to the storeOrders list
            this.storeOrders.add(toAdd);

            return true;
        } else {
            // obj was not added
            return false;
        }
    }

    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Order) {
            // cast obj to Order object
            Order toRemove = (Order) obj;

            // remove order from the storeOrders list
            return this.storeOrders.remove(toRemove);
        } else {
            // obj was not removed
            return false;
        }
    }

    /**
     * Exports the order info for each order in storeOrder into the designated file
     * @param targetFile to export the storeOrders into
     */
    public void export(File targetFile) {
        String output = "";

        for (Order order : this.storeOrders) {
            // print order number
            output += "Order Number: " + order.getOrderNum() + "\n";

            // calculate and format total price
            DecimalFormat df = new DecimalFormat("#.##");
            df.setGroupingUsed(true);
            df.setGroupingSize(3);
            df.setMinimumFractionDigits(2);

            double subtotal = order.getSubtotal();
            double total = subtotal + subtotal * Constants.SALESTAX_PERCENTAGE;

            String totalString = df.format(total);
            output += "\tTotal Price: " + totalString + "\n";

            // print each item in the order
            for (MenuItem item : order.getOrder()) {
                output += "\t- " + item.toString() + "\n";
            }

            output += "\n";
        }

        try {
            FileWriter myWriter = new FileWriter(targetFile);
            myWriter.write(output);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}