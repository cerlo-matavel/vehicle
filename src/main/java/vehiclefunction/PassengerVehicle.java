package vehiclefunction;

import exceptions.PassangerException;
import transported.Person;
import vehicle.Vehicle;

import java.util.ArrayList;

public abstract class PassengerVehicle extends Vehicle implements PassengerVehicles {

    //Passanger Atributes
    int totalPassengerSeats = 1;
    ArrayList<Person> person = new ArrayList<Person>();

    //PassangerVehicle methods
    @Override
    public int getTotalPassengerSeats() {
        return totalPassengerSeats;
    }

    @Override
    public void setTotalPassengerSeats(int totalPassengerSeats) {
        this.totalPassengerSeats = totalPassengerSeats;
    }

    @Override
    public int getTotalLoadedPassangers() {
        return this.person.size();
    }

    @Override
    public int getTotalVacantSeats(){
        return totalPassengerSeats - this.person.size();
    }

    @Override
    public void loadPassanger(Person person) throws PassangerException {
        if (totalPassengerSeats > this.person.size()) {
            //this.person.forEach((e)-> this.person.get(1).getWeight());
            float aaa = 0;
            for (Person var :
                    this.person) {
                aaa += var.getWeight();
            }
            if(person.getWeight() + aaa + this.getTareGrossWeight().getTare() < getTareGrossWeight().getTare()){
                this.person.add(person);
                System.out.println("Passanger "+ person.getName()+" loaded");
            }
            else{

                throw new PassangerException("Passanger can't be loaded, because the car is overloaded");
            }
        }
        else
            throw new PassangerException("Passanger can't be loaded, because car is in full capacity");

    }

    @Override
    public void unloadPassanger(int number){
        this.person.remove(number);
    }

    @Override
    public ArrayList<Person> getPassanger() {
        return person;
    }
}
