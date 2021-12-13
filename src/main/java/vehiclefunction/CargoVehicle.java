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
    ArrayList<Cargo> cargo = new ArrayList<>();

    //CargoVehicle methods
    @Override
    public void loadCargo(Cargo cargo) throws VehicleCapacityException {

        //Check if car is at full capacity
        if (this.getTareGrossWeight()
                        .getTotalAvailableCapacity() >= cargo.getWeight()){
            this.cargo.add(cargo);
            this.getTareGrossWeight().setWeight(this.getTareGrossWeight().getWeight() +
                    cargo.getWeight());
            LOGGER.warn(this.getName() + " loaded cargo.");
        }else{
            throw new VehicleCapacityException("The vehicle is full or cargo if over the " +
                    "available capacity of the vehicle.");
        }
    }

    public void unloadCargo(int cargoPosition) throws VehicleCapacityException {

        //check if CargoVehicle is empty
        if (!this.cargo.isEmpty()) {
            this.cargo.remove(cargoPosition);
            LOGGER.warn(this.getName() + " unloaded cargo " + cargo);
        } else {
            throw new VehicleCapacityException("The vehicle is empty.");
        }
    }
}
