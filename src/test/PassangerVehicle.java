package Passanger;

import vehicle.Vehicle;

import java.util.ArrayList;

public abstract class PassangerVehicle extends Vehicle {

    private int totalPassangerSeats = 1;
    private ArrayList<Person> person = new ArrayList<Person>();

    public int getTotalPassangerSeats() {
        return totalPassangerSeats;
    }

    public void setTotalPassangerSeats(int totalPassangerSeats) {
        this.totalPassangerSeats = totalPassangerSeats;
    }

    public int getTotalLoadedPassangers() {
        return this.person.size();
    }

    public int getTotalVacantSeats(){
        return totalPassangerSeats - this.person.size();
    }

    public void loadPassanger(Person person){
        if (totalPassangerSeats > this.person.size()) {
            this.person.add(person);
            System.out.println("Passanger " + person.getName()+" loaded");
        }
        else
            System.out.println("Can't load passanger "+person.getName()+", all chairs are occupied");

    }
    public void unloadPassanger(int number){
        this.person.remove(number);
    }

    public ArrayList<Person> getPassanger() {
        return person;
    }

    @Override
    public String toString() {
        return "PassangerVehicle{" +
                "totalPassangerSeats=" + totalPassangerSeats +
                ", totalLoadedPassangers=" + this.person.size() +
                ", passanger=" + person +
                '}';
    }
}
