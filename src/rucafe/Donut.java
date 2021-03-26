package rucafe;

import java.util.ArrayList;

public class Donut extends MenuItem implements Customizable {

    public static ArrayList<Donut> cart = new ArrayList<>();

    private int count;
    private DONUT_TYPE donutType;
    private String donutFlavor;

    public Donut(int count, DONUT_TYPE donutType, String donutFlavor) {
        this.count = count;
        this.donutType = donutType;
        this.donutFlavor = donutFlavor;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean add(Object obj) {
        if (obj instanceof Donut) {
            // cast obj to Donut object
            Donut toAdd = (Donut) obj;

            // check if the donut already exists, if so, increment the count instead of adding new donut
            for (Donut currCartDonut : cart) {
                if ((currCartDonut.donutType == toAdd.donutType) && (currCartDonut.donutFlavor.equals(toAdd.donutFlavor))) {
                    currCartDonut.setCount(currCartDonut.count + toAdd.count);
                    return true;
                }
            }

            // this specific type and flavor is not in the cart
            cart.add(toAdd);
            return true;
        } else {
            // the object passed in was not a Donut object
            return false;
        }
    }

    @Override
    public boolean remove(Object obj) {
        boolean removedSuccessfully;
        if (obj instanceof Donut) {
            // cast obj to Donut object
            Donut roRemove = (Donut) obj;

            removedSuccessfully = cart.remove(roRemove);
        } else {
            removedSuccessfully = false;
        }

        return removedSuccessfully;
    }

    public ArrayList<String> cartToString() {
        ArrayList<String> cartString = new ArrayList<>();

        for (Donut currDonut : cart) {
            String currDonutString = currDonut.donutFlavor + " " + currDonut.donutType.getName() + " (" + currDonut.count + ")";
            cartString.add(currDonutString);
        }

        return cartString;
    }

    @Override
    public double itemPrice() {
        return 0.0;
    }
}
