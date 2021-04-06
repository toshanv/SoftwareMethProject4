package rucafe;

/**
 * Abstract MenuItem class that enforces itemPrice for Coffee and Donut objects.
 *
 * @author Toshanraju Vysyaraju
 * @author Christopher Nguyen
 */
public abstract class MenuItem {
    private int count;
    abstract double itemPrice();

    /**
     * Constructor method to initialize the count data field for Donut and Coffee
     * @param count of the menu item
     */
    public MenuItem(int count) {
        this.count = count;
    }

    /**
     * Getter method for the number of MenuItem
     * @return number of MenuItem
     */
    public int getCount() {
        return this.count;
    }

    /**
     * Setter method to set the count of MenuItem
     * @param count of the MenuItem wanted
     */
    public void setCount(int count) {
        this.count = count;
    }

}