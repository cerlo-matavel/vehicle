package vehiclefunction;

import exceptions.EmptyPositionException;
import exceptions.SizeException;
import exceptions.WeightException;
import transported.Cargo;

public interface CargoVehicles {
    void loadCargo(Cargo cargo) throws WeightException, SizeException;
    void unloadCargo(int cargoPosition) throws WeightException, EmptyPositionException;
}
