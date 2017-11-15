package com.refactor.mini_project;

class Movie {

    static final int CHILDREN = 2;
    static final int REGULAR = 0;
    static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    private void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    private PricingStrategy getPricingStrategy() {
        PricingStrategy ps;
        switch (getPriceCode()) {
            case REGULAR:
                 ps = new RegularPricingStrategy();
                 break;
            case NEW_RELEASE:
                ps = new NewReleasePricingStrategy();
                break;
            case CHILDREN:
                ps = new ChildrendPricingStrategy();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code.");
        }
        return ps;
    }

    int getPriceCode() {
        return priceCode;
    }

    String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        PricingStrategy ps = getPricingStrategy();
        return ps.getCharge(daysRented);
    }
}
