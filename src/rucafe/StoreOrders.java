package rucafe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Store Orders class that defines the Store Orders object which holds all orders in the store.
 *
 * @author Toshanraju Vysyaraju
 * @author Christopher Nguyen
 */
public class StoreOrders implements Customizable {
    private ArrayList<Order> storeOrders;

    /**
     * Constructor for the list of all store orders
     */
    public StoreOrders() {
        this.storeOrders = new ArrayList<>();
    }

    /**
     * Getter method for a list of all order numbers in the store
     * @return list of all order numbers
     */
    public ArrayList<Integer> getOrderNumsList() {
        ArrayList<Integer> orderNumsList = new ArrayList<>();

        for (Order order : this.storeOrders) {
            orderNumsList.add(order.getOrderNum());
        }

        return orderNumsList;
    }

    /**
     * Getter method for a specific order in the store
     * @param orderNum of the order wanted
     * @return the order object that is wanted
     */
    public Order getOrder(int orderNum) {
        for (Order order : this.storeOrders) {
            if (order.getOrderNum() == orderNum) {
                return order;
            }
        }

        return null;
    }

    /**
     * Getter method for number of orders in the store
     * @return the number of orders in the store
     */
    public int getSize() {
        return this.storeOrders.size();
    }

    /**
     * Adds an order to the store
     * @param obj to be added to the store
     * @return true if the order was added, false if it was not
     */
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

    /**
     * Removes an order from the store
     * @param obj to be removed from the store
     * @return true if the order was removed, false if it was not
     */
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
            output += "\tTotal Price: $" + totalString + "\n";

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