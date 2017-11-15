package com.refactor.mini_project;

public class RegularPricingStrategy extends PricingStrategy {
    @Override
    public double getCharge(int daysRented) {
        double amount = 2;
        if (daysRented > 2)
            amount += (daysRented - 2) * 1.5;
        return amount;
    }
}
