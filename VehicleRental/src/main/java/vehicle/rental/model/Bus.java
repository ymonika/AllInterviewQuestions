package vehicle.rental.model;

import vehicle.rental.constant.FuelType;

public class Bus extends Vehicle {

    public Bus(boolean isAC, Integer distance){
        this.isAC=isAC;
        this.fuelType= FuelType.DIESEL;
        this.distanceToTravel =distance;
        this.stdFairCharges=8;
        this.fairCharges=this.stdFairCharges;
    }

}
