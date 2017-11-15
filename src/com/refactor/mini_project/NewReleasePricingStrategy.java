package com.refactor.mini_project;

public class NewReleasePricingStrategy extends PricingStrategy {
    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }
}
