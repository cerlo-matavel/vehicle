package vehiclefunction;

import exceptions.EmptyPositionException;
import exceptions.PassengerException;
import exceptions.SizeException;
import exceptions.WeightException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import transported.Person;
import vehicle.Vehicle;

import java.util.ArrayList;

public abstract class PassengerVehicle extends Vehicle implements PassengerVehicles {

    //Passenger Attributes
    private static final Logger LOGGER = LogManager.getLogger(PassengerVehicle.class);
    private int totalPassengerSeats = 1;
    private ArrayList<Person> person = new ArrayList<Person>();

    public PassengerVehicle(int totalPassengerSeats) {
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
    public int getTotalVacantSeats() {
        return totalPassengerSeats - getTotalLoadedPassengers();
    }

    @Override
    public void loadPassenger(Person person) throws PassengerException, WeightException{

        //Checking vacant seats in the vehicle
        if (0 < getTotalVacantSeats()) {

            //Checking person's weight compared to the available weight
            if (this.getTareGrossWeight().getAvailableWeight() > person.getWeight()) {
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
}
