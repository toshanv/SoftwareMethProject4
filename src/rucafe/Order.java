package rucafe;

import java.util.ArrayList;

public class Order implements Customizable {

    private ArrayList<MenuItem> order;
    private int orderNum;

    public Order(int orderNum) {
        this.order = new ArrayList<>();
        this.orderNum = orderNum;
    }

    public ArrayList<MenuItem> getOrder() {
        return this.order;
    }

    public int getOrderNum() {
        return this.orderNum;
    }

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

    public ArrayList<String> orderToStringList() {
        ArrayList<String> orderString = new ArrayList<>();

        for (MenuItem orderItem : this.order) {
            orderString.add(orderItem.toString());
        }

        return orderString;
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (MenuItem orderItem : this.order) {
            subtotal += orderItem.itemPrice();
        }

        return subtotal;
    }
}
