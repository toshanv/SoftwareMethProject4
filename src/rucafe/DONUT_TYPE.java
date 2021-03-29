package rucafe;

/**
 * Enum class for the types of donuts
 *
 * @author Toshanraju Vysyaraju
 * @author Christopher Nguyen
 */
public enum DONUT_TYPE {
    YEAST(Constants.YEAST_DONUT_NAME, Constants.DONUT_YEAST_PRICE, Constants.DONUT_YEAST_FLAVORS),
    CAKE(Constants.CAKE_DONUT_NAME, Constants.DONUT_CAKE_PRICE, Constants.DONUT_CAKE_FLAVORS),
    HOLE(Constants.DONUT_HOLES_NAME, Constants.DONUT_HOLE_PRICE, Constants.DONUT_HOLE_FLAVORS);

    private final String name;
    private final double price;
    private final String[] flavors;

    /**
     * Constructor for enum DONUT_TYPE
     * @param price of the donut
     * @param flavors for the donut
     */
    DONUT_TYPE(String name, double price, String[] flavors) {
        this.name = name;
        this.price = price;
        this.flavors = flavors;
    }

    /**
     * Getter for the name of the donut
     * @return name of the donut based on type
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for price of the donut
     * @return price of donut based on type
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Getter for the flavors of the donut
     * @return flavors of the donut based on type
     */
    public String[] getFlavors() {
        return this.flavors;
    }
}
