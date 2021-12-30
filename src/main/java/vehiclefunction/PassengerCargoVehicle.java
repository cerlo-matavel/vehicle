package vehiclefunction;

import exceptions.EmptyPositionException;
import exceptions.PassengerException;
import exceptions.SizeException;
import exceptions.WeightException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import transported.Cargo;
import transported.Person;
import vehicle.Vehicle;

import java.util.ArrayList;

public abstract class PassengerCargoVehicle extends Vehicle implements CargoVehicles, PassengerVehicles {

    private static final Logger LOGGER = LogManager.getLogger(PassengerCargoVehicle.class);

    //Passenger Attributes
    private int totalPassengerSeats = 1;
    ArrayList<Person> person = new ArrayList<>();

    //Cargo Attributes
    ArrayList<Cargo> cargo = new ArrayList<>();

    public PassengerCargoVehicle(int totalPassengerSeats) {
        this.totalPassengerSeats = totalPassengerSeats;
    }

    //PassengerVehicle methods
    @Override
    public int getTotalPassengerSeats() {
        return totalPassengerSeats;
    }

    @Override
    public int getTotalLoadedPassengers() {
        return this.person.size();
    }

    @Override
    public int getTotalVacantSeats(){
        return totalPassengerSeats - this.person.size();
    }

    public void loadPassenger(Person person) throws PassengerException, WeightException{

        //Checking vacant seats in the vehicle
        if (this.getTotalVacantSeats() > 0) {

            //Checking person's weight compared to the available weight
            if (person.getWeight() < this.getTareGrossWeight().getAvailableWeight()) {
                this.person.add(person);
                this.getTareGrossWeight().setWeight(this.getTareGrossWeight().getWeight()
                        + person.getWeight());
                LOGGER.warn("Passenger " + person.getName() + " loaded");

            } else {
                throw new WeightException("Passenger can't be loaded, because his weight would exceed" +
                        " the maximum weight the vehicle can carry.");
            }
        } else
            throw new PassengerException("Passenger can't be loaded, because the vehicle is at full capacity.");

    }

    @Override
    public void unloadPassenger(int number) throws EmptyPositionException {
        Person removed;
        try {
            removed = this.person.get(number - 1);
            this.person.remove(number-1);
            this.getTareGrossWeight().setWeight(this.getTareGrossWeight().getWeight() - removed.getWeight());
            LOGGER.warn(this.getName() + " unloaded cargo\n" + removed);
        } catch (IndexOutOfBoundsException e){
            throw new EmptyPositionException("Vehicle is empty or the selected seat in unoccupied");
        }
    }

    //CargoVehicle methods
    @Override
    public void loadCargo(Cargo cargo) throws WeightException, SizeException {

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
