package org.example;

public class ProductCalculations implements IProductCalculations{
    public double price;

    public ProductCalculations(double price) {
        this.price = price;
    }

    @Override
    public double getVat() {
        return this.price * 0.15;
    }

    @Override
    public double getCommission() {
        return this.price * 0.05;
    }

    @Override
    public double getTotal() {
        return this.price + this.getVat() + this.getCommission();
    }
}
