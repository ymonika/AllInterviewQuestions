package com.parking.lot.parking;

import com.parking.lot.model.FourWheelerVehicle;
import com.parking.lot.model.TwoWheelerVehicle;
import com.parking.lot.model.Vehicle;

public class ParkingSlot {

    FourWheelerVehicleParkingSlot fourWheelerVehicleParkingSlot = new FourWheelerVehicleParkingSlot();
    TwoWheelerVehicleParkingSlot twoWheelerVehicleParkingSlot = new TwoWheelerVehicleParkingSlot();

    public void park(Vehicle vehicle) {
        if(vehicle instanceof FourWheelerVehicle) {
            fourWheelerVehicleParkingSlot.park((FourWheelerVehicle) vehicle);
        } else {
            twoWheelerVehicleParkingSlot.park((TwoWheelerVehicle) vehicle);
        }
    }

    public String availableSlots() {
        return "Four wheeler available slots:" + fourWheelerVehicleParkingSlot.availableSlots() + "\n" +
        "Two wheeler available slots:" + twoWheelerVehicleParkingSlot.availableSlots();
    }

    public void exitParking(Vehicle vehicle) {
        if(vehicle instanceof FourWheelerVehicle) {
            fourWheelerVehicleParkingSlot.exitParking((FourWheelerVehicle) vehicle);
        } else {
            twoWheelerVehicleParkingSlot.exitParking((TwoWheelerVehicle) vehicle);
        }
    }

}
