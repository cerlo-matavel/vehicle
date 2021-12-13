package test;

import exceptions.VehicleCapacityException;
import measurements.Dimensions;
import measurements.TareGrossWeight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import transported.Cargo;
import vehicle.power.CombustionEngine;
import vehicle.type.Truck;
import vehiclefunction.CargoVehicle;
//import vehiclefunction.PassengerCargoVehicle;

public class Main2 {

    public static final Logger LOGGER = LogManager.getLogger(Main2.class);

    public static void main(String[] args){

        CombustionEngine combustionEngine =
                new CombustionEngine(CombustionEngine.FuelType.GASOLINE,
                        1,
                        38);
        /*PassengerCargoVehicle bike2 = new Bike(combustionEngine,"Toyota Corrola");*/

        //bike.accelerate("Vrr");
       //bike.accelerate("Vrr");
       // bike2.accelerate("Brr");

        //bike.unloadCargo(1);
        /*System.out.println(bike);
        System.out.println(bike2);*/
        CargoVehicle truck = new Truck(combustionEngine,"Toyota Axio");
        truck.setTareGrossWeight(new TareGrossWeight(300,150));
        Cargo cargo = new Cargo(50,new Dimensions(20,30,50),
                "I still have to thing");

        try {
            truck.loadCargo(cargo);
            truck.loadCargo(cargo);
            truck.loadCargo(cargo);
        } catch (VehicleCapacityException e) {
            LOGGER.error("Car must be full.", e);
        }

        try {
            truck.unloadCargo(0);
        } catch (VehicleCapacityException e) {
            LOGGER.error("Car is empty.", e);
        }

        //System.out.println(truck.getTareGrossWeight().getTotalAvailableCapacity());
        System.out.println(truck.getCargoList());
    }
}
