package vehicle.rental.model;

import vehicle.rental.constant.FuelType;

public class SUV extends Vehicle {

    public SUV(Integer distance){
        this.isAC=true;
        this.fuelType= FuelType.DIESEL;
        this.distanceToTravel=distance;
        this.stdFairCharges=8;
        this.fairCharges=this.stdFairCharges;
    }

}
