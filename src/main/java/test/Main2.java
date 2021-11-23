package test;

import exceptions.VehicleCapacityException;
import vehicle.power.CombustionEngine;
import vehicle.type.Bike;
import vehiclefunction.PassengerCargoVehicle;

public class Main2 {

    public static void main(String[] args) throws VehicleCapacityException {

        CombustionEngine combustionEngine = new CombustionEngine(CombustionEngine.FuelType.GASOLINE, 1,38);
        PassengerCargoVehicle bike = new Bike(combustionEngine,"Toyota Axio");
        PassengerCargoVehicle bike2 = new Bike(combustionEngine,"Toyota Corrola");

        //bike.accelerate("Vrr");
       //bike.accelerate("Vrr");
       // bike2.accelerate("Brr");

        //bike.unloadCargo(1);
        System.out.println(bike);
        System.out.println(bike2);



    }
}
