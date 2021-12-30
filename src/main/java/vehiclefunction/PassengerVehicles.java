package vehiclefunction;

import exceptions.EmptyPositionException;
import exceptions.PassengerException;
import exceptions.WeightException;
import transported.Person;

public interface PassengerVehicles {

    int getTotalPassengerSeats();

    int getTotalLoadedPassengers();

    int getTotalVacantSeats();

    void loadPassenger(Person person) throws PassengerException, WeightException;

    void unloadPassenger(int number) throws EmptyPositionException;
}
