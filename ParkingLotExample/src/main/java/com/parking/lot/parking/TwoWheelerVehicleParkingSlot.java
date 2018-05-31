package com.parking.lot.parking;

import com.parking.lot.model.TwoWheelerVehicle;

import java.util.HashSet;
import java.util.Set;

public class TwoWheelerVehicleParkingSlot implements VehicleParkingLot<TwoWheelerVehicle> {

    private Set<TwoWheelerVehicle> twoWheelerVehicleSet = new HashSet<>();

    public void park(TwoWheelerVehicle twoWheelerVehicle) {
        if (twoWheelerVehicleSet.contains(twoWheelerVehicle)) {
            System.out.println("your vehicle is already parked...");
        } else {
            if (twoWheelerVehicleSet.size() == totalCapacity) {
                System.out.println("Parking is full for Two wheeler...");
            } else {
                twoWheelerVehicleSet.add(twoWheelerVehicle);
            }
        }
    }

    public Integer availableSlots() {
        return totalCapacity - twoWheelerVehicleSet.size();
    }

    public void exitParking(TwoWheelerVehicle twoWheelerVehicle) {
        if (twoWheelerVehicleSet.contains(twoWheelerVehicle)) {
            twoWheelerVehicleSet.remove(twoWheelerVehicle);
        } else {
            System.out.println("Your Vehicle is not parked...");
        }
    }
}
