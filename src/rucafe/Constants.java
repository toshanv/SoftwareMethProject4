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

    // constants for donuts
    private static final double DONUT_YEAST_PRICE = 1.39;
    private static final double DONUT_CAKE_PRICE = 1.59;
    private static final double DONUT_HOLE_PRICE = 0.33;
    private static final String YEAST_DONUT_NAME = "Yeast Donut";
    private static final String CAKE_DONUT_NAME = "Cake Donut";
    private static final String DONUT_HOLES_NAME = "Donut Holes";
    private static final String[] DONUT_YEAST_FLAVORS = {"Jelly Filled", "Glaze", "Chocolate Frosted", "Lemon Filled"};
    private static final String[] DONUT_CAKE_FLAVORS = {"Old Fashion", "Blueberry", "Cinnamon Sugar"};
    private static final String[] DONUT_HOLE_FLAVORS = {"Cinnamon Sugar Holes", "Blueberry holes", "Jelly Holes"};

    /**
     * Coffee Size enum
     */
    public static enum COFFEE_SIZE {
        SHORT(COFFEE_SHORT_PRICE),
        TALL(COFFEE_TALL_PRICE),
        GRANDE(COFFEE_GRANDE_PRICE),
        VENTI(COFFEE_VENTI_PRICE);

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

    /**
     * Donut Type enum
     */
    public static enum DONUT_TYPE {
        YEAST(YEAST_DONUT_NAME, DONUT_YEAST_PRICE, DONUT_YEAST_FLAVORS),
        CAKE(CAKE_DONUT_NAME, DONUT_CAKE_PRICE, DONUT_CAKE_FLAVORS),
        HOLE(DONUT_HOLES_NAME, DONUT_HOLE_PRICE, DONUT_HOLE_FLAVORS);

        private final String name;
        private final double price;
        private final String[] flavors;

        /**
         * Setter for enum DONUT_TYPE
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
}
