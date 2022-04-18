package xyz.rk0.housing.data.model;

import java.time.LocalDate;

public class HousingRecord {
    private double price;
    private double squareFeet;
    private String zipCode;
    private LocalDate saleDate;

    public HousingRecord(double price, double squareFeet, String zipCode, LocalDate saleDate) {
        this.price = price;
        this.squareFeet = squareFeet;
        this.zipCode = zipCode;
        this.saleDate = saleDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(double squareFeet) {
        this.squareFeet = squareFeet;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }
}
