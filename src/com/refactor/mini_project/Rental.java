package com.refactor.mini_project;

class Rental {

    Movie movie;
    private int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public String getMovieTitle() {
        return this.movie.getTitle();
    }

    double getCharge() {
        return this.movie.getCharge(daysRented);
    }

    public int getFrequentRenterPoints() {
        return this.movie.getFrequentRenterPoints(daysRented);
    }
}
