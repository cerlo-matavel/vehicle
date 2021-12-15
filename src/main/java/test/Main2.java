package test;

import exceptions.EmptyPositionException;
import exceptions.SizeException;
import exceptions.WeightException;
import measurements.Dimensions;
import measurements.Space;
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
        CargoVehicle truck = new Truck(combustionEngine
                ,"Toyota Axio"
                , new Space(15, 3, 5));
        truck.setTareGrossWeight(new TareGrossWeight(300,80));
        Cargo cargo = new Cargo(50,new Dimensions(100,12,30),
                "I still have to thing");
        LOGGER.warn("Available space: "+ truck.getDimensions().getAvailableSpace());
        LOGGER.warn("Available weight: "+ truck.getTareGrossWeight().getAvailableWeight());
        try {
            truck.loadCargo(cargo);
            //truck.loadCargo(new Cargo(50,new Dimensions(7,1,1),"Think"));
            truck.loadCargo(new Cargo(20,new Dimensions(3,1,2),"thinking"));
            truck.loadCargo(new Cargo(10,new Dimensions(8,3,4),"thought"));
            truck.loadCargo(new Cargo(10,new Dimensions(8,3,4),"thought"));
            truck.loadCargo(new Cargo(10,new Dimensions(8,3,4),"thought"));
        } catch (WeightException e) {
            LOGGER.error(e);
        } catch (SizeException e) {
            LOGGER.error("Cargo wouldn't fit in the vehicle.", e);
        }
        LOGGER.warn("Available space: "+ truck.getDimensions().getAvailableSpace());
        LOGGER.warn("Available weight: "+ truck.getTareGrossWeight().getAvailableWeight());
        System.out.println(truck.getCargoList());
        try {
            truck.unloadCargo(1);
        } catch (EmptyPositionException e) {
            LOGGER.error("Car is empty.", e);
        }
        LOGGER.warn("Available space: "+ truck.getDimensions().getAvailableSpace());
        LOGGER.warn("Available weight: "+ truck.getTareGrossWeight().getAvailableWeight());
        //System.out.println(truck.getTareGrossWeight().getTotalAvailableCapacity());
        //System.out.println(truck.getCargoList());
    }
}
