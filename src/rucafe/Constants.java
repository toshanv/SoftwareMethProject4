package rucafe;

/**
 * Constants class for the RU Cafe holds all constants that are used throughout the files
 *
 * @author Toshanraju Vysyaraju
 * @author Christopher Nguyen
 */
public class Constants {
    // constants for stage sizes
    public static final int MAIN_STAGE_WIDTH = 450;
    public static final int MAIN_STAGE_HEIGHT = 400;
    public static final int ADDITIONAL_STAGE_WIDTH = 600;
    public static final int ADDITIONAL_STAGE_HEIGHT = 200;


    // constants for coffee
    public static final double COFFEE_ADDIN_PRICE = 0.2;
    public static final double COFFEE_BASE_PRICE = 1.99;
    public static final double COFFEE_UPGRADE_PRICE = 0.5;

    public static final String COFFEE_SHORT_NAME = "Short";
    public static final String COFFEE_TALL_NAME = "Tall";
    public static final String COFFEE_GRANDE_NAME = "Grande";
    public static final String COFFEE_VENTI_NAME = "Venti";

    public static final String ADDIN_CREAM_NAME = "Cream";
    public static final String ADDIN_SYRUP_NAME = "Syrup";
    public static final String ADDIN_MILK_NAME = "Milk";
    public static final String ADDIN_CARAMEL_NAME = "Caramel";
    public static final String ADDIN_WHIPPED_CREAM_NAME = "Whipped Cream";

    public static final double COFFEE_SHORT_PRICE = COFFEE_BASE_PRICE;
    public static final double COFFEE_TALL_PRICE = COFFEE_SHORT_PRICE + COFFEE_UPGRADE_PRICE;
    public static final double COFFEE_GRANDE_PRICE = COFFEE_TALL_PRICE + COFFEE_UPGRADE_PRICE;
    public static final double COFFEE_VENTI_PRICE = COFFEE_GRANDE_PRICE + COFFEE_UPGRADE_PRICE;

    // constants for donuts
    public static final double DONUT_YEAST_PRICE = 1.39;
    public static final double DONUT_CAKE_PRICE = 1.59;
    public static final double DONUT_HOLE_PRICE = 0.33;

    public static final String YEAST_DONUT_NAME = "Yeast Donut";
    public static final String CAKE_DONUT_NAME = "Cake Donut";
    public static final String DONUT_HOLES_NAME = "Donut Holes";

    public static final String[] DONUT_YEAST_FLAVORS = {"Jelly Filled", "Glaze", "Chocolate Frosted", "Lemon Filled"};
    public static final String[] DONUT_CAKE_FLAVORS = {"Old Fashion", "Blueberry", "Cinnamon Sugar"};
    public static final String[] DONUT_HOLE_FLAVORS = {"Cinnamon Sugar Holes", "Blueberry holes", "Jelly Holes"};

    // constants for order
    public static final double SALESTAX_PERCENTAGE = 0.06625;
}
