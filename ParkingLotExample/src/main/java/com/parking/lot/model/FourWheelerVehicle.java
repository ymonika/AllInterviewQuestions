package com.parking.lot.model;

public class FourWheelerVehicle implements Vehicle {

    private String vehicleNumber;

    public FourWheelerVehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber.toUpperCase();
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    @Override
    public String toString() {
        return "FourWheelerVehicleimplements{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                '}';
    }
}
