package rucafe;

import java.util.ArrayList;

public class Donut extends MenuItem {

    private int count;
    private DONUT_TYPE donutType;
    private String donutFlavor;

    public Donut(int count, DONUT_TYPE donutType, String donutFlavor) {
        this.count = count;
        this.donutType = donutType;
        this.donutFlavor = donutFlavor;
    }

    public int getCount() {
        return this.count;
    }

    public DONUT_TYPE getDonutType() {
        return this.donutType;
    }

    public String getDonutFlavor() {
        return this.donutFlavor;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public double itemPrice() {
        return this.donutType.getPrice() * this.count;
    }

    @Override
    public String toString() {
        return this.getDonutFlavor() + " " + this.getDonutType().getName() + " (" + this.getCount() + ")";
    }
}
