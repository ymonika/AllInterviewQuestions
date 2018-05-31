package com.parking.lot.runner;

import com.parking.lot.model.FourWheelerVehicle;
import com.parking.lot.model.TwoWheelerVehicle;
import com.parking.lot.parking.ParkingSlot;

public class ParkingSlotRunner {

    public static void main(String[] args) {
        FourWheelerVehicle fourWheelerVehicle1 = new FourWheelerVehicle("mh14dl7843");
        FourWheelerVehicle fourWheelerVehicle2 = new FourWheelerVehicle("mh14dl7847");
        FourWheelerVehicle fourWheelerVehicle3 = new FourWheelerVehicle("mh14dl7800");

        TwoWheelerVehicle twoWheelerVehicle1 = new TwoWheelerVehicle("MH14DL7843");
        TwoWheelerVehicle twoWheelerVehicle2 = new TwoWheelerVehicle("MH14DL7843");
        TwoWheelerVehicle twoWheelerVehicle3 = new TwoWheelerVehicle("MH12DL7843");

        ParkingSlot parkingSlot = new ParkingSlot();
        System.out.println(parkingSlot.availableSlots());
        parkingSlot.park(fourWheelerVehicle1);
        parkingSlot.park(fourWheelerVehicle2);
        parkingSlot.park(fourWheelerVehicle3);
        parkingSlot.park(twoWheelerVehicle1);
        System.out.println(parkingSlot.availableSlots());
        parkingSlot.exitParking(twoWheelerVehicle1);
        System.out.println(parkingSlot.availableSlots());
        parkingSlot.park(fourWheelerVehicle3);parkingSlot.park(fourWheelerVehicle3);parkingSlot.park(fourWheelerVehicle3);
        parkingSlot.exitParking(fourWheelerVehicle3);
        System.out.println(parkingSlot.availableSlots());
        parkingSlot.exitParking(fourWheelerVehicle3);
    }
}

