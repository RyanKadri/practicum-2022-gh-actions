package xyz.rk0.housing.data.model;

public class HousingResult {

    private final double result;
    private final int numHouses;

    public HousingResult(double result, int numHouses) {
        this.result = result;
        this.numHouses = numHouses;
    }

    public double getResult() {
        return result;
    }

    public int getNumHouses() {
        return numHouses;
    }
}
