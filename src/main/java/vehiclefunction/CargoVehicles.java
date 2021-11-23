package vehiclefunction;

import exceptions.VehicleCapacityException;
import transported.Cargo;

public interface CargoVehicles {

    void loadCargo(Cargo cargo) throws VehicleCapacityException;
    void unloadCargo(int cargoPosition) throws VehicleCapacityException;

    float getTotalCargoCapacity();

    float getTotalAvailableCapacity();
}
