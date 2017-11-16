package com.refactor.mini_project;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String name;
    private Vector<Rental> rentals = new Vector<>();

    Customer(String name) {
        this.name = name;
    }

    void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    String statement() {
        double totalAmount = getTotalCharge();
        int frequentRenterPoints = getTotalFrequentRenterPoints();
        Enumeration<Rental> rentals = this.rentals.elements();
        StringBuilder result = new StringBuilder().append("Rental Record for ").append(getName()).append("\n");
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            //show figures for this rental
            result.append("\t").append(each.getMovieTitle()).append("\t").append(String.valueOf(each.getCharge())).append("\n");
        }
        //add footer lines
        result.append("Amount owed is ").append(String.valueOf(totalAmount)).append("\n");
        result.append("You earned ").append(String.valueOf(frequentRenterPoints)).append(" frequent renter points");
        return result.toString();
    }

    private int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental rental = rentals.nextElement();
            frequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    private double getTotalCharge() {
        double totalAmount = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental rental = rentals.nextElement();
            totalAmount += rental.getCharge();
        }
        return totalAmount;
    }

}
