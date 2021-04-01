package rucafe;

import java.util.ArrayList;

/**
 * Coffee class that defines the coffee object
 *
 * @author Toshanraju Vysyaraju
 * @author Christopher Nguyen
 */
public class Coffee extends MenuItem implements Customizable {
    private final ArrayList<ADDINS> currAddIns;
    private COFFEE_SIZE size;

    /**
     * Coffee constructor that initialize the coffee object
     */
    public Coffee() {
        super(0);

        // initialize the coffee object with no add-ins or size
        this.currAddIns = new ArrayList<ADDINS>();
        this.size = null;
    }

    /**
     * Getter method for the size of the coffee object
     * @return size enum of the coffee object
     */
    public COFFEE_SIZE getSize() {
        return this.size;
    }

    /**
     * Setter to set the size of the coffee object
     * @param size object that the user wants
     */
    public void setSize(COFFEE_SIZE size) {
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
        if (obj instanceof ADDINS) {
            // cast obj to ADDINS object
            ADDINS toAdd = (ADDINS) obj;

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
        if (obj instanceof ADDINS) {
            // cast obj to ADDINS object
            ADDINS toRemove = (ADDINS) obj;

            removedSuccessfully = this.currAddIns.remove(toRemove);
        } else {
            removedSuccessfully = false;
        }

        return removedSuccessfully;
    }

    /**
     * Calculates the price of the current coffee object
     * @return price of the coffee
     */
    @Override
    public double itemPrice() {
        // if size has not been selected, the price should be 0
        if (this.size == null) {
            return 0;
        }

        // calculate and return the price of the coffee
        return (this.size.getPrice() + (this.currAddIns.size() * Constants.COFFEE_ADDIN_PRICE)) * getCount();
    }

    /**
     * Compiles the current coffee object to string format
     * @return string representation of the coffee object
     */
    @Override
    public String toString() {
        String addIns = "[";
        if (this.currAddIns.size() == 0) {
            addIns += "]";
        } else {
            int i;

            for (i = 0; i < this.currAddIns.size() - 1; i++) {
                addIns += this.currAddIns.get(i).getName() + ", ";
            }

            addIns += this.currAddIns.get(i).getName() + "]";
        }

        return "Coffee (" + getCount() + ") " + this.size.getName() + " " + addIns;
    }
}
