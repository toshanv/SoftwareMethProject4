package rucafe;

import java.util.ArrayList;

public class DonutCart {
    private ArrayList<Donut> cart;

    public DonutCart() {
        this.cart = new ArrayList<>();
    }

    public Donut getDonut(int index) {
        return this.cart.get(index);
    }

    public int getSize(){
        return this.cart.size();
    }

    public void addToCart(Donut toAdd) {
        // check if the donut already exists, if so, increment the count instead of adding new donut
        for (Donut currDonut : this.cart) {
            if ((currDonut.getDonutType() == toAdd.getDonutType()) && (currDonut.getDonutFlavor().equals(toAdd.getDonutFlavor()))) {
                currDonut.setCount(currDonut.getCount() + toAdd.getCount());
                return;
            }
        }

        // this specific type and flavor is not in the cart
        this.cart.add(toAdd);
    }

    public void removeFromCart(Donut toRemove) {
        cart.remove(toRemove);
    }

    public double getTotalPrice() {
        double totalPrice = 0;

        for (Donut currDonut : this.cart) {
            totalPrice += currDonut.itemPrice();
        }

        return totalPrice;
    }

    public ArrayList<String> cartToString() {
        ArrayList<String> cartString = new ArrayList<>();

        for (Donut currDonut : this.cart) {
            String currDonutString = currDonut.getDonutFlavor() + " " + currDonut.getDonutType().getName() + " (" + currDonut.getCount() + ")";
            cartString.add(currDonutString);
        }

        return cartString;
    }
}
