package vehiclefunction;

import exceptions.PassangerException;
import transported.Person;

import java.util.ArrayList;

public interface PassengerVehicles {

    int getTotalPassengerSeats();

    void setTotalPassengerSeats(int totalPassengerSeats);

    int getTotalLoadedPassangers();

    int getTotalVacantSeats();

    void loadPassanger(Person person) throws PassangerException;

    void unloadPassanger(int number);

    ArrayList<Person> getPassanger();
}
