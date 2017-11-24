package com.refactor.mini_project;

class Movie {

    static final int CHILDREN = 2;
    static final int REGULAR = 0;
    static final int NEW_RELEASE = 1;

    private String title;
    private int category;
    private PricingStrategy ps;

    Movie(String title, int category) {
        this.title = title;
        setCategory(category);
    }

    private void setCategory(int category) {
        this.category = category;
        this.ps = PricingStrategyFactory.getPricingStrategy(category);
    }

    String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        return this.ps.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return this.ps.getFrequentRenterPoints(daysRented);
    }

}
