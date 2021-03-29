package rucafe;

/**
 * Customizable interface to allows Coffee objects to add and remove Add-Ins, Order objects to add and remove MenuItems, and StoreOrder objects to add and remove Orders.
 *
 * @author Toshanraju Vysyaraju
 * @author Christopher Nguyen
 */
public interface Customizable {
    boolean add(Object obj);
    boolean remove(Object obj);
}