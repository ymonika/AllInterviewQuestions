package vehicle.rental;

import vehicle.rental.calculator.RateCalculator;
import vehicle.rental.constant.Distance;
import vehicle.rental.constant.FuelType;
import vehicle.rental.model.Bus;
import vehicle.rental.model.Car;
import vehicle.rental.model.SUV;

import java.util.Arrays;

public class CalculateVehicleFair {

    public static void main(String[] args){

        Car car = new Car(false, FuelType.DIESEL, Distance.calculateDistance(Distance.PUNE,Distance.MUMBAI).intValue());
        System.out.println(RateCalculator.calculateTotalExpenses(car, 7, Arrays.asList(100)));

        SUV suv = new SUV(Distance.calculateDistance(Distance.BANGLORE,Distance.MUMBAI).intValue());
        System.out.println(RateCalculator.calculateTotalExpenses(suv,7,Arrays.asList(100,150)));

        Bus bus = new Bus(true, Distance.calculateDistance(Distance.BANGLORE,Distance.MUMBAI).intValue());
       // System.out.println(RateCalculator.calculateTotalExpenses(bus,45, Arrays.asList(100,150) ));
    }
}
