package com.refactor.mini_project;

public abstract class PricingStrategy {
    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
