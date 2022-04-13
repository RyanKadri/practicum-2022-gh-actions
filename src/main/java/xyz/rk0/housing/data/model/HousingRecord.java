package xyz.rk0.housing.data.model;

import java.time.LocalDate;

public record HousingRecord(
    double price,
    double squareFeet,
    String zipCode,
    LocalDate saleDate) {

    public double getPrice() {
        return price;
    }

    public double getSquareFeet() {
        return squareFeet;
    }

    public String getZipCode() {
        return zipCode;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }
}
