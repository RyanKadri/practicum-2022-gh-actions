package xyz.rk0.housing.data.model;

public class HousingResult {
    private double result;
    private int numHouses;

    public HousingResult(double result, int numHouses) {
        this.result = result;
        this.numHouses = numHouses;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public int getNumHouses() {
        return numHouses;
    }

    public void setNumHouses(int numHouses) {
        this.numHouses = numHouses;
    }
}
