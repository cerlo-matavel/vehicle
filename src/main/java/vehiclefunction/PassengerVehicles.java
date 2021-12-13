package vehiclefunction;

import exceptions.PassengerException;
import transported.Person;

public interface PassengerVehicles {

    int getTotalPassengerSeats();

    int getTotalLoadedPassengers();

    int getTotalVacantSeats();

    void loadPassenger(Person person) throws PassengerException;

    void unloadPassenger(int number) throws PassengerException;
}
