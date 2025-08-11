package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Searchable;

public abstract class DiscountedProduct extends Product {

    public int basePrice;
    public int discount;

        @Override
        public double getCostProduct () {
        return basePrice - (basePrice * discount / 100);
    }

        @Override
        public double getPrice () {
        return basePrice - (basePrice * discount / 100);
    }

        @Override
        public boolean isSpecial () {
        return true;
    }

    @Override
    public boolean isBetter(Searchable bestResult) {
        return false;
    }

    public DiscountedProduct(String name, int price, int percent) {
        super(name);

        if (price <= 0) {
            throw new IllegalArgumentException("Цена не может быть 0 или отрицательной");
        }
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100");
        }

    }
}
