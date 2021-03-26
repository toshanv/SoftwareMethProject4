package rucafe;

public enum COFFEE_SIZE {
    SHORT(Constants.COFFEE_SHORT_PRICE),
    TALL(Constants.COFFEE_TALL_PRICE),
    GRANDE(Constants.COFFEE_GRANDE_PRICE),
    VENTI(Constants.COFFEE_VENTI_PRICE);

    private final double price;

    /**
     * Setter for the enum COFFEE_SIZE
     * @param price of the coffee
     */
    COFFEE_SIZE(double price) {
        this.price = price;
    }

    /**
     * getter for price of a coffee size
     * @return price of coffee based on size
     */
    public double getPrice() {
        return this.price;
    }
}
