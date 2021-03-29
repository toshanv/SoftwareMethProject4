package rucafe;

import java.util.ArrayList;

/**
 * Order object that defines the Order object which holds all items in the current order and has a unique order number.
 *
 * @author Toshanraju Vysyaraju
 * @author Christopher Nguyen
 */
public class Order implements Customizable {
    private ArrayList<MenuItem> order;
    private int orderNum;

    /**
     * Constructor for the current order
     * @param orderNum of the current order
     */
    public Order(int orderNum) {
        this.order = new ArrayList<>();
        this.orderNum = orderNum;
    }

    /**
     * Getter method for all items in the order
     * @return list of all items in the order
     */
    public ArrayList<MenuItem> getOrder() {
        return this.order;
    }

    /**
     * Getter method for the size of the current order
     * @return size of the order
     */
    public int getSize() {
        return this.order.size();
    }

    /**
     * Getter method for the order number of the current order
     * @return order number of the order
     */
    public int getOrderNum() {
        return this.orderNum;
    }

    /**
     * Getter method a specific item in the current order
     * @param index of the item in the order
     * @return item in the order
     */
    public MenuItem getOrderItem(int index) {
        return this.order.get(index);
    }

    /**
     * Adds a MenuItem object to the current order
     * @param obj to be added to the order
     * @return true if the item was added, false if the item was not added
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Donut) {
            // cast obj to donut object
            Donut toAdd = (Donut) obj;

            // add donut to the order
            this.order.add(toAdd);

            return true;
        } else if (obj instanceof Coffee) {
            // cast obj to coffee object
            Coffee toAdd = (Coffee) obj;

            // add coffee to the order
            this.order.add(toAdd);

            return true;
        } else {
            // obj was not added
            return false;
        }
    }

    /**
     * Removes a MenuItem object from the current order
     * @param obj to be removed from the order
     * @return true if the item was removed, false if the item was not removed
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Donut) {
            // cast obj to donut object
            Donut toRemove = (Donut) obj;

            // remove donut from the order
            return this.order.remove(toRemove);
        } else if (obj instanceof Coffee) {
            // cast obj to coffee object
            Coffee toRemove = (Coffee) obj;

            // remove coffee from the order
            return this.order.remove(toRemove);
        } else {
            // obj was not removed
            return false;
        }
    }

    /**
     * Compiles all items in the order to string format
     * @return list of items in the order in string format
     */
    public ArrayList<String> orderToStringList() {
        ArrayList<String> orderString = new ArrayList<>();

        for (MenuItem orderItem : this.order) {
            orderString.add(orderItem.toString());
        }

        return orderString;
    }

    /**
     * Calculates the total price of all items in the current order
     * @return price of all items in the order
     */
    public double getSubtotal() {
        double subtotal = 0;
        for (MenuItem orderItem : this.order) {
            subtotal += orderItem.itemPrice();
        }

        return subtotal;
    }
}
