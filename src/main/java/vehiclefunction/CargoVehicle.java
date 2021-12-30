package vehiclefunction;

import exceptions.EmptyPositionException;
import exceptions.SizeException;
import exceptions.WeightException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import transported.Cargo;
import vehicle.Vehicle;

import java.util.ArrayList;

public abstract class CargoVehicle extends Vehicle implements CargoVehicles{

    //CargoVariables
    private static final Logger LOGGER = LogManager.getLogger(CargoVehicle.class);
    private ArrayList<Cargo> cargo = new ArrayList<>();

    //CargoVehicle methods
    @Override
    public void loadCargo(Cargo cargoIn) throws WeightException, SizeException {
        Cargo cargo = Cargo.copy(cargoIn);
        //Check if car is at full weight capacity
        if (this.getTareGrossWeight()
                        .getAvailableWeight() >= cargo.getWeight()){

            //check if cargo can fit in the car and if there is enough
            if (cargo.getDimensions().calculateVector()
                    <= this.getDimensions().getAvailableSpace()){
                this.cargo.add(cargo);

                //Adding the weight
                this.getTareGrossWeight().setWeight(this.getTareGrossWeight().getWeight() +
                        cargo.getWeight());

                //Subtracting available space
                this.getDimensions().setAvailableSpace(this.getDimensions()
                        .getAvailableSpace()
                        - cargo.getDimensions()
                        .calculateVector());

                LOGGER.warn(this.getName() + " loaded cargo.");
            }
            else{
                throw new SizeException("The cargo is too bit to fit in the vehicle");
            }
        }else{
            throw new WeightException("The vehicle is at full weight capacity or cargo weight is" +
                    " over the available capacity of the vehicle.");
        }
    }

    public void unloadCargo(int cargoPosition) throws EmptyPositionException {
        Cargo removed;
        try{
            removed = this.cargo.get(cargoPosition-1);
            this.cargo.remove(cargoPosition-1);

            //Subtracting the weight occupied by the eliminated cargo
            this.getTareGrossWeight().setWeight(this.getTareGrossWeight().getWeight() -
                    removed.getWeight());

            //Adding available space that was being occupied by the cargo
            this.getDimensions().setAvailableSpace(this.getDimensions()
                    .getAvailableSpace()
                    + removed.getDimensions()
                    .calculateVector());
            LOGGER.warn(this.getName() + " unloaded cargo\n" + removed);
        }
        catch (IndexOutOfBoundsException e){
            throw new EmptyPositionException("Vehicle is empty or the chosen position is empty");
        }
    }

    public String getCargoList(){
        String cargoList = "";
        for (int i = 0; i < this.cargo.size(); i++) {
            cargoList += (i+1) +" "+ this.cargo.get(i);
        }
        return cargoList;
    }
}
