package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    public FixPriceProduct(String name) {
        super(name);
    }
    private static final double FIX_PRICE = 100.0;

    @Override
    public double getCostProduct() {
        return FIX_PRICE;
    }

    @Override
    public double getPrice() {
        return FIX_PRICE;
    }
}
