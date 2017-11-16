package com.refactor.mini_project;

public class PricingStrategyFactory {

    public static PricingStrategy getPricingStrategy(int category) {
        PricingStrategy ps;
        switch (category) {
            case Movie.REGULAR:
                ps = new RegularPricingStrategy();
                break;
            case Movie.NEW_RELEASE:
                ps = new NewReleasePricingStrategy();
                break;
            case Movie.CHILDREN:
                ps = new ChildrendPricingStrategy();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code.");
        }
        return ps;
    }
}
