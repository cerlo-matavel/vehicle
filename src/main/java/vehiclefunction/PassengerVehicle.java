package vehiclefunction;

import exceptions.PassengerException;
import transported.Person;
import vehicle.Vehicle;

import java.util.ArrayList;

public abstract class PassengerVehicle extends Vehicle implements PassengerVehicles {

    //Passenger Attributes
    int totalPassengerSeats = 1;
    ArrayList<Person> person = new ArrayList<Person>();

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
            //this.person.forEach((e)-> this.person.get(1).getWeight());
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
                throw new PassengerException("Passenger can't be loaded, because the car is overloaded.");
            }
        }
        else
            throw new PassengerException("Passenger can't be loaded, because car is in full capacity.");

    }

    @Override
    public void unloadPassenger(int number) throws PassengerException {

        if(!this.person.isEmpty() || this.person.size() <= number){
            this.person.remove(number);
        }else{
            throw new PassengerException("Vehicle is empty or the selected seat in unoccupied");
        }
    }
}
