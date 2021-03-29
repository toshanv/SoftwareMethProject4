package rucafe;

/**
 * Enum class for the Add-Ins for coffee
 *
 * @author Toshanraju Vysyaraju
 * @author Christopher Nguyen
 */
public enum ADDINS {
    CREAM(Constants.ADDIN_CREAM_NAME),
    SYRUP(Constants.ADDIN_SYRUP_NAME),
    MILK(Constants.ADDIN_MILK_NAME),
    CARAMEL(Constants.ADDIN_CARAMEL_NAME),
    WHIPPED_CREAM(Constants.ADDIN_WHIPPED_CREAM_NAME);

    private final String name;

    /**
     * Constructor for the ADDIN enum
     * @param name of the Add-In
     */
    ADDINS(String name) {
        this.name = name;
    }

    /**
     * Getter that returns the name of the Add-In
     * @return the name of the Add-In
     */
    public String getName() {
        return this.name;
    }
}
