package rucafe;

public class Constants {
    // constants for coffee
    public static final double COFFEE_ADDIN_PRICE = 0.2;
    private static final double COFFEE_BASE_PRICE = 1.99;
    private static final double COFFEE_UPDGRADE_PRICE = 0.5;
    private static final double COFFEE_SHORT_PRICE = COFFEE_BASE_PRICE;
    private static final double COFFEE_TALL_PRICE = COFFEE_SHORT_PRICE + COFFEE_UPDGRADE_PRICE;
    private static final double COFFEE_GRANDE_PRICE = COFFEE_TALL_PRICE + COFFEE_UPDGRADE_PRICE;
    private static final double COFFEE_VENTI_PRICE = COFFEE_GRANDE_PRICE + COFFEE_UPDGRADE_PRICE;

    /**
     * Coffee Size enum
     */
    public static enum COFFEE_SIZE {
        SHORT(COFFEE_SHORT_PRICE),
        TALL(COFFEE_TALL_PRICE),
        GRANDE(COFFEE_GRANDE_PRICE),
        VENTI(COFFEE_VENTI_PRICE);

        private final double cost;
        COFFEE_SIZE(double cost) {
            this.cost = cost;
        }

        /**
         * getter for cost of a coffee size
         * @return cost of coffee based on size
         */
        public double getCost() {
            return this.cost;
        }
    }

    /**
     * Coffee Add-In enum
     */
    public static enum ADDINS {
        CREAM,
        SYRUP,
        MILK,
        CARAMEL,
        WHIPPED_CREAM;
    }
}
