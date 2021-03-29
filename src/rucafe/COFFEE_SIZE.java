package rucafe;

/**
 * Enum class for the Coffee Sizes
 *
 * @author Toshanraju Vysyaraju
 * @author Christopher Nguyen
 */
public enum COFFEE_SIZE {
    SHORT(Constants.COFFEE_SHORT_NAME, Constants.COFFEE_SHORT_PRICE),
    TALL(Constants.COFFEE_TALL_NAME, Constants.COFFEE_TALL_PRICE),
    GRANDE(Constants.COFFEE_GRANDE_NAME, Constants.COFFEE_GRANDE_PRICE),
    VENTI(Constants.COFFEE_VENTI_NAME, Constants.COFFEE_VENTI_PRICE);

    private final String name;
    private final double price;

    /**
     * Constructor for the enum COFFEE_SIZE
     * @param price of the coffee
     */
    COFFEE_SIZE(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Getter for price of a coffee size
     * @return price of coffee based on size
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Getter method for the name of the coffee size
     * @return string representation of the coffee size
     */
    public String getName() {
        return this.name;
    }
}
