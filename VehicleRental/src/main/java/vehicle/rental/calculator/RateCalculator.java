package vehicle.rental.calculator;

import vehicle.rental.model.Bus;
import vehicle.rental.model.Car;
import vehicle.rental.model.Vehicle;

import java.util.List;

public class RateCalculator {

    public static double calculateTotalExpenses(Vehicle vehicle, Integer passengers, List<Integer> toll) {
        double totalExp= toll != null ? toll.stream().reduce(0,Integer::sum) : 0;
        if (vehicle.isAC()) {
            vehicle.setFairCharges(vehicle.getStdFairCharges() + 2);
        }

        if (vehicle instanceof Bus) {
            totalExp= vehicle.getFairCharges() * vehicle.getDistanceToTravel() * 0.98;
        } else if (vehicle instanceof Car && ( (Car) vehicle ).getExtraPassengers(passengers) ) {
            totalExp=vehicle.getFairCharges() * vehicle.getDistanceToTravel() * 1.5 ;
        }  else {
            totalExp=vehicle.getFairCharges() * vehicle.getDistanceToTravel();
        }
        return totalExp;
    }

    public static void main(String[] args){
        System.out.println("string".equals(null));
    }
}
