package com.parking.lot.parking;

import com.parking.lot.model.FourWheelerVehicle;

import java.util.HashSet;
import java.util.Set;

public class FourWheelerVehicleParkingSlot implements VehicleParkingLot<FourWheelerVehicle> {

    private Set<FourWheelerVehicle> fourWheelerVehicleSet = new HashSet<>();

    public void park(FourWheelerVehicle fourWheelerVehicle) {
        if (fourWheelerVehicleSet.contains(fourWheelerVehicle)) {
            System.out.println("your vehicle is already parked...");
        } else {
            if (fourWheelerVehicleSet.size() == totalCapacity) {
                System.out.println("Parking is full for Four wheeler...");
            } else {
                fourWheelerVehicleSet.add(fourWheelerVehicle);
            }
        }
    }

    public Integer availableSlots() {
        return totalCapacity - fourWheelerVehicleSet.size();
    }

    public void exitParking(FourWheelerVehicle fourWheelerVehicle) {
        if (fourWheelerVehicleSet.contains(fourWheelerVehicle)) {
            fourWheelerVehicleSet.remove(fourWheelerVehicle);
        } else {
            System.out.println("Your Vehicle is not parked...");
        }
    }
}
