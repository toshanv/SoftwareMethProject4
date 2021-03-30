package rucafe;

/**
 * Donut class that defines the Donut object
 *
 * @author Toshanraju Vysyaraju
 * @author Christopher Nguyen
 */
public class Donut extends MenuItem {
    private int count;
    private DONUT_TYPE donutType;
    private String donutFlavor;

    /**
     * Constructor for the donut object
     * @param count of donuts wanted
     * @param donutType enum of the type of donut wanted
     * @param donutFlavor string of the flavor of donut wanted
     */
    public Donut(int count, DONUT_TYPE donutType, String donutFlavor) {
        this.count = count;
        this.donutType = donutType;
        this.donutFlavor = donutFlavor;
    }

    /**
     * Getter method for the number of donuts
     * @return number of donuts
     */
    public int getCount() {
        return this.count;
    }

    /**
     * Getter method for the type of donut
     * @return type of donut
     */
    public DONUT_TYPE getDonutType() {
        return this.donutType;
    }

    /**
     * Getter method for the flavor of donut
     * @return flavor of donut
     */
    public String getDonutFlavor() {
        return this.donutFlavor;
    }

    /**
     * Setter method to set the count of donuts
     * @param count of donuts wanted
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Calculates the price of the current donut object
     * @return price of the donut
     */
    @Override
    public double itemPrice() {
        if (this.donutType == null) {
            return 0;
        }

        return this.donutType.getPrice() * this.count;
    }

    /**
     * Compiles the current donut object to string format
     * @return string representation of the donut object
     */
    @Override
    public String toString() {
        return this.getDonutFlavor() + " " + this.getDonutType().getName() + " (" + this.getCount() + ")";
    }
}
