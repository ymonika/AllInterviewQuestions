package com.parking.lot.model;

public class TwoWheelerVehicle implements Vehicle {

    private String vehicleNumber;

    public TwoWheelerVehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber.toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TwoWheelerVehicle)) return false;

        TwoWheelerVehicle that = (TwoWheelerVehicle) o;

        return getVehicleNumber() != null ? getVehicleNumber().equals(that.getVehicleNumber()) : that.getVehicleNumber() == null;
    }

    @Override
    public int hashCode() {
        return getVehicleNumber() != null ? getVehicleNumber().hashCode() : 0;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    @Override
    public String toString() {
        return "TwoWheelerVehicle{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                '}';
    }
}
