package vehiclefunction;

import exceptions.PassangerException;
import exceptions.VehicleCapacityException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import transported.Cargo;
import transported.Person;
import vehicle.Vehicle;

import java.util.ArrayList;

public abstract class PassengerCargoVehicle extends Vehicle implements CargoVehicles, PassengerVehicles {

    //Passanger Atributes
    int totalPassengerSeats = 1;
    ArrayList<Person> person = new ArrayList<Person>();

    //CargoVariables
    private static final Logger LOGGER = LogManager.getLogger(PassengerCargoVehicle.class);
    private float totalCargoCapacity = 20000;
    ArrayList<Cargo> cargo = new ArrayList<Cargo>();

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

    //cargo Weight
    private float totoalCargoWeight(){
        float totalWeight = 0;
        if (!this.cargo.isEmpty()) {

            for (Cargo var :
                    this.cargo) {
                totalWeight += var.getWeight();
            }
            return totalWeight;
        }
        return 0;
    }

    //CargoVehicle methods
    @Override
    public void loadCargo(Cargo cargo) throws VehicleCapacityException {

        //Check if car is on maxWeight
        if (totoalCargoWeight()
                + this.getTareGrossWeight().getTare()
                + cargo.getWeight() < this.getTareGrossWeight().getGrossWeight() ){
            LOGGER.warn(this.getName() + " loaded cargo " + cargo.getDescription() );

        }else{
            VehicleCapacityException a = new VehicleCapacityException("The vehicle is full.");
            LOGGER.fatal(this.getName() + " tried to unload an empty vehicle.",a);
            throw a;
        }
        //System.out.println(totalAvailableCapacity);
    }


    public void unloadCargo(int cargoPosition) throws VehicleCapacityException {

        if (!this.cargo.isEmpty()) {
            this.cargo.remove(cargoPosition);
            LOGGER.warn(this.getName() + " unloaded cargo " + cargo);
        } else {
            VehicleCapacityException a = new VehicleCapacityException("The vehicle is emply.");
            LOGGER.fatal(this.getName() + " tried to unload an empty vehicle.",a);
            throw a;
        }

    }

    @Override
    public float getTotalCargoCapacity() {
        return totalCargoCapacity;
    }

    @Override
    public float getTotalAvailableCapacity() {
        return this.getTareGrossWeight().getGrossWeight() - totoalCargoWeight();
    }
}
