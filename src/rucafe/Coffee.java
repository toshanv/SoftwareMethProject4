package rucafe;

import java.util.ArrayList;

public class Coffee extends MenuItem implements Customizable {

    private final ArrayList<Constants.ADDINS> currAddIns;
    private Constants.COFFEE_SIZE size;

    /**
     * Coffee constructor that initialize the coffee object
     */
    public Coffee() {
        // initialize the coffee object with no add-ins or size
        currAddIns = new ArrayList<Constants.ADDINS>();
        size = null;
    }

    /**
     * Setter to set the size of the coffee object
     * @param size object that the user wants
     */
    public void setSize(Constants.COFFEE_SIZE size) {
        this.size = size;
    }

    /**
     * Adds a new add-in to the coffee object
     * @param obj of add-in to be added to the coffee
     * @return true if successfully added, false if not added
     */
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

    /**
     * Removes add-in from the coffee object
     * @param obj of add-in to be removed from the coffee
     * @return true if successfully removed, false if not removed
     */
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
     * Calculates the price of the current coffee object
     * @return price of coffee
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
