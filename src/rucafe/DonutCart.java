package rucafe;

import java.util.ArrayList;

/**
 * Donut Cart class that defines the Donut Cart object which holds a list of donuts that are in the current cart before they are added to the order itself.
 *
 * @author Toshanraju Vysyaraju
 * @author Christopher Nguyen
 */
public class DonutCart {
    private ArrayList<Donut> cart;

    /**
     * Constructor for the current cart of donuts
     */
    public DonutCart() {
        this.cart = new ArrayList<>();
    }

    /**
     * Getter method for a donut in the cart
     * @param index of the donut in the cart
     * @return Donut object of the specified donut
     */
    public Donut getDonut(int index) {
        return this.cart.get(index);
    }

    /**
     * Getter method for the size of the cart
     * @return size of the cart
     */
    public int getSize() {
        return this.cart.size();
    }

    /**
     * Getter method for the cart
     * @return list of Donut objects in the cart
     */
    public ArrayList<Donut> getCart() {
        return this.cart;
    }

    /**
     * Adds donut to the cart. If the specific donut already exists in the cart, the count of the donut is updated rather than adding a new object.
     * @param toAdd object of the donut to be added
     */
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

    /**
     * Removes donut from the cart
     * @param toRemove object of the donut to be removed
     */
    public void removeFromCart(Donut toRemove) {
        this.cart.remove(toRemove);
    }

    /**
     * Calculates the total price of all donuts in the cart
     * @return total price of the cart
     */
    public double getTotalPrice() {
        double totalPrice = 0;

        for (Donut currDonut : this.cart) {
            totalPrice += currDonut.itemPrice();
        }

        return totalPrice;
    }

    /**
     * Compiles the entire cart to a list of strings
     * @return list of strings of donuts in the cart
     */
    public ArrayList<String> cartToStringList() {
        ArrayList<String> cartString = new ArrayList<>();

        for (Donut currDonut : this.cart) {
            cartString.add(currDonut.toString());
        }

        return cartString;
    }
}
