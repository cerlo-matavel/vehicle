package vehiclefunction;

import exceptions.VehicleCapacityException;
import transported.Cargo;

import java.util.ArrayList;

public interface CargoVehicles {
    ArrayList<Cargo> cargo = new ArrayList<>();

    void loadCargo(Cargo cargo) throws VehicleCapacityException;
    void unloadCargo(int cargoPosition) throws VehicleCapacityException;

    default String getCargoList(){
        String cargoList = "";
        for (int i = 0; i <= this.cargo.size(); i++) {
            cargoList += this.cargo + "\n";
        }
        return cargoList;
    }
}
