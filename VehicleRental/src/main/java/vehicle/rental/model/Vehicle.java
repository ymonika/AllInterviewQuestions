package vehicle.rental.model;

import vehicle.rental.constant.FuelType;

public abstract class Vehicle {

    protected boolean isAC;
    protected FuelType fuelType;
    protected Integer distanceToTravel;
    protected Integer stdFairCharges;
    protected Integer fairCharges;

    public boolean isAC() {
        return isAC;
    }

    public void setAC(boolean AC) {
        isAC = AC;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getDistanceToTravel() {
        return distanceToTravel;
    }

    public void setDistanceToTravel(Integer distanceToTravel) {
        this.distanceToTravel = distanceToTravel;
    }

    public Integer getStdFairCharges() {
        return stdFairCharges;
    }

    public void setStdFairCharges(Integer stdFairCharges) {
        this.stdFairCharges = stdFairCharges;
    }

    public Integer getFairCharges() {
        return fairCharges;
    }

    public void setFairCharges(Integer fairCharges) {
        this.fairCharges = fairCharges;
    }
}
