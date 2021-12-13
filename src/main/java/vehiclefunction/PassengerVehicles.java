package vehiclefunction;

import exceptions.PassengerException;
import transported.Person;

import java.util.ArrayList;

public interface PassengerVehicles {

    int getTotalPassengerSeats();

    void setTotalPassengerSeats(int totalPassengerSeats);

    int getTotalLoadedPassengers();

    int getTotalVacantSeats();

    void loadPassenger(Person person) throws PassengerException;

    void unloadPassenger(int number);

    ArrayList<Person> getPassenger();
}
