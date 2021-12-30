package test;

import vehiclefunction.PassengerCargoVehicle;
import vehiclefunction.PassengerVehicle;
import vehiclefunction.PassengerVehicles;
import transported.Person;
import vehicle.Vehicle;
import vehicle.power.ElectricEngine;
import vehicle.type.Bike;

//Passanger != person check
//fazer logging check
//usar exception check
//Enum para gasolina, diesel, etc etc check
//abstract passanger implements PassangerVehicles, vehicle implements CargoVehicle and passanger vehicle implements
//PassangerVehicle and CargoVehicle


public class Main {

    public static void main(String[] args) {
        ElectricEngine electricEngine = new ElectricEngine(108.9);
        PassengerCargoVehicle bike = new Bike(electricEngine, "BMX");

        //((CombustionEngine)((Vehicle)bike).getEngine()).setFuelType(CombustionEngine.FuelType.KEROSENE);
        //((CombustionEngine) bike.getEngine()).setFuelType("Gasoline");

        System.out.println(bike.getEngine());

        //((Vehicle)bike).brake();
        System.out.println(bike.getTareGrossWeight().getAvailableWeight());

        try {
            bike.loadPassenger(new Person("Amanda", (short) 70, 11));
            System.out.println(bike.getTareGrossWeight().getAvailableWeight());
            bike.loadPassenger(new Person("Amanda", (short) 100, 11));
            bike.loadPassenger(new Person("Amanda", (short) 100, 11));
        }catch (RuntimeException e){
            bike.loadPassenger(new Person("Amanda", (short) 20, 11));
        }
        /*bike.loadPassenger(new Person("Marta"));
        bike.loadPassenger(new Person("Amanda"));*/

    }
}
