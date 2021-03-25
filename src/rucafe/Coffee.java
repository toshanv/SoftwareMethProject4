package rucafe;

import java.util.ArrayList;

public class Coffee extends MenuItem implements Customizable {

    private final ArrayList<Constants.ADDINS> currAddIns;
    private Constants.COFFEE_SIZES size;

    /**
     * Coffee constructor that initialize the coffee object
     */
    public Coffee() {
        // initialize the coffee object with no add-ins or size
        currAddIns = new ArrayList<Constants.ADDINS>();
        size = null;
    }

    @Override
    public boolean add(Object obj) {
        boolean addedSuccessfully;
        if (obj instanceof Constants.ADDINS) {
            // cast obj to ADDINS object
            Constants.ADDINS toAdd = (Constants.ADDINS) obj;

            // TODO: do we need to check if its already in the list? i dont think its possible that we will try to add something thats already in it

            this.currAddIns.add(toAdd);
            addedSuccessfully = true;
        } else {
            // the object passed in was not an ADDINS object
            addedSuccessfully = false;
        }

        return addedSuccessfully;
    }

    @Override
    public boolean remove(Object obj) {
        boolean removedSuccessfully;
        if (obj instanceof Constants.ADDINS) {
            // cast obj to ADDINS object
            Constants.ADDINS toRemove = (Constants.ADDINS) obj;

            removedSuccessfully = this.currAddIns.remove(toRemove);
        } else {
            removedSuccessfully = false;
        }

        return removedSuccessfully;
    }

    /**
     * Calculates the price of the current
     * @return
     */
    @Override
    public double itemPrice() {
        // if size has not been selected, the price should be 0
        if (this.size == null) {
            return 0;
        }

        // calculate and return the price of the coffee
        return this.size.getCost() + (this.currAddIns.size() * Constants.COFFEE_ADDIN_PRICE);
    }
}
