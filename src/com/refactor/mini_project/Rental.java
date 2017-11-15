package com.refactor.mini_project;

class Rental {

    Movie movie;
    private int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    Movie getMovie() {
        return movie;
    }

    int getDaysRented() {
        return daysRented;
    }

    public String getMovieTitle() {
        return this.movie.getTitle();
    }

    int getFrequentRenterPoints() {
        //add bonus for a two day new release rental
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                getDaysRented() > 1)
            return 2;
        return 1;
    }

    double getCharge() {
        return this.movie.getCharge(daysRented);
    }

}
