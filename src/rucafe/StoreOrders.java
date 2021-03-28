package rucafe;

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
}
