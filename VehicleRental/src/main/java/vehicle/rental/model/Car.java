package vehicle.rental.model;

import vehicle.rental.constant.FuelType;

public class Car extends Vehicle {

    private static Integer MAX_LIMIT=5;

    public Car(boolean isAC, FuelType fuelType, Integer distance){
        this.isAC=isAC;
        this.fuelType=fuelType;
        this.distanceToTravel=distance;
        this.stdFairCharges= fuelType.equals(FuelType.PETROL) ? 9 : 8;
        this.fairCharges=this.stdFairCharges;
    }

    public boolean getExtraPassengers(Integer noOfPassengers){
            return noOfPassengers > MAX_LIMIT ? true : false;
    }
}
