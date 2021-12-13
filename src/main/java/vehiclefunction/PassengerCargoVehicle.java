package vehiclefunction;

import exceptions.PassengerException;
import exceptions.VehicleCapacityException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import transported.Cargo;
import transported.Person;
import vehicle.Vehicle;

import java.util.ArrayList;

public abstract class PassengerCargoVehicle extends Vehicle implements CargoVehicles, PassengerVehicles {

    //Passenger Attributes
    int totalPassengerSeats;
    ArrayList<Person> person = new ArrayList<>();

    //Cargo Attributes
    private static final Logger LOGGER = LogManager.getLogger(PassengerCargoVehicle.class);
    ArrayList<Cargo> cargo = new ArrayList<>();

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

    @Override
    public void loadPassenger(Person person) throws PassengerException {
        if (totalPassengerSeats > this.person.size()) {
            float aaa = 0;
            for (Person var :
                    this.person) {
                aaa += var.getWeight();
            }
            if(person.getWeight() + aaa + this.getTareGrossWeight().getTare() < getTareGrossWeight().getTare()){
                this.person.add(person);
                System.out.println("Passenger "+ person.getName()+" loaded");
            }
            else{
                throw new PassengerException("Passenger can't be loaded, because the car is overloaded");
            }
        }
        else {
            throw new PassengerException("Passenger can't be loaded, because car is in full capacity");
        }
    }

    @Override
    public void unloadPassenger(int number){
        this.person.remove(number);
    }

    //CargoVehicle methods
    @Override
    public void loadCargo(Cargo cargo) throws VehicleCapacityException {

        //Check if car is at full capacity
        if (this.getTareGrossWeight().getTotalAvailableCapacity() >= cargo.getWeight()){
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
