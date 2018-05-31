package com.parking.lot.parking;

public interface VehicleParkingLot<T> {

    int totalCapacity = 2;

    void park(T t);

    Integer availableSlots();

    void exitParking(T t);
}
