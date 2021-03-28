package rucafe;

public enum ADDINS {
    CREAM(Constants.ADDIN_CREAM_NAME),
    SYRUP(Constants.ADDIN_SYRUP_NAME),
    MILK(Constants.ADDIN_MILK_NAME),
    CARAMEL(Constants.ADDIN_CARAMEL_NAME),
    WHIPPED_CREAM(Constants.ADDIN_WHIPPED_CREAM_NAME);

    private final String name;

    ADDINS(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
