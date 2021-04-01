package rucafe;

/**
 * Abstract MenuItem class that enforces itemPrice for Coffee and Donut objects.
 *
 * @author Toshanraju Vysyaraju
 * @author Christopher Nguyen
 */
abstract class MenuItem {
    private int count;

    /**
     * Constructor method to initialize the count data field for Donut and Coffee
     * @param count
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

    abstract double itemPrice();
}