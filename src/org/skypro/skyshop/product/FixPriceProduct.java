package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private static final double FIX_PRICE = 100.0;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public double getCostProduct() {
        return FIX_PRICE;
    }

    @Override
    public double getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
