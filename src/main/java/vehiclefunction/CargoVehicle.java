package vehiclefunction;

import exceptions.VehicleCapacityException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import transported.Cargo;
import vehicle.Vehicle;

import java.util.ArrayList;

public abstract class CargoVehicle extends Vehicle implements CargoVehicles{

    //CargoVariables
    private static final Logger LOGGER = LogManager.getLogger(CargoVehicle.class);
    private float totalCargoCapacity = 20000;
    ArrayList<Cargo> cargo = new ArrayList<Cargo>();

    //cargo Weight
    private float totalCargoWeight(){
        float totalWeight = 0;
        if (!this.cargo.isEmpty()) {

            for (Cargo var :
                    this.cargo) {
                totalWeight += var.getWeight();
            }
            return totalWeight;
        }
        return 0;
    }

    //CargoVehicle methods
    @Override
    public void loadCargo(Cargo cargo) throws VehicleCapacityException {

        //Check if car is on maxWeight
        if (totalCargoWeight()
                + this.getTareGrossWeight().getTare()
                + cargo.getWeight() < this.getTareGrossWeight().getGrossWeight() ){
            LOGGER.warn(this.getName() + " loaded cargo " + cargo.getDescription() );

        }else{
            VehicleCapacityException a = new VehicleCapacityException("The vehicle is full.");
            LOGGER.fatal(this.getName() + " tried to unload an empty vehicle.",a);
            throw a;
        }
        //System.out.println(totalAvailableCapacity);
    }


    public void unloadCargo(int cargoPosition) throws VehicleCapacityException {

        if (this.cargo.isEmpty()) {
            this.cargo.remove(cargoPosition);
            LOGGER.warn(this.getName() + " unloaded cargo " + cargo);
        } else {
            System.out.println(this.cargo.size());

            VehicleCapacityException a = new VehicleCapacityException("The vehicle is empty.");
            LOGGER.fatal(this.getName() + " tried to unload an empty vehicle.",a);
            throw a;
        }

    }

    @Override
    public float getTotalCargoCapacity() {
        return totalCargoCapacity;
    }

    @Override
    public float getTotalAvailableCapacity() {
        return this.getTareGrossWeight().getGrossWeight() - totalCargoWeight();
    }
}
