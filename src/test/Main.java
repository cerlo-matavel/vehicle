package test;

import exceptions.PassangerException;
import vehiclefunction.PassengerVehicles;
import transported.Person;
import vehicle.Vehicle;
import vehicle.power.ElectricEngine;
import vehicle.type.Bike;

//Passanger != person check
//fazer logging check
//usar exception check
//Enum para gasolina, diesel, etc etc check
//abstract passanger implements PassangerVehicles, vehicle implements CargoVehicle and passanger vehicle implements
//PassangerVehicle and CargoVehicle


public class Main {

    public static void main(String[] args){

        //CombustionEngine engine = new CombustionEngine();
        /*CombustionEngine engine = new CombustionEngine();
        engine.setFuelType(CombustionEngine.FuelType.GASOLINE);
        CombustionEngine engine1 = new CombustionEngine();
        engine1.setFuelType(CombustionEngine.FuelType.DIESEL);
        System.out.println("Fuel 1: "+engine.getFuelType().getFuel());

        System.out.println("Fuel 2: "+engine1.getFuelType().getFuel());
        PassangerVehicles bike = new Bike(engine);
        bike.loadPassanger(new Person("Patricia"));
        bike.loadPassanger(new Person("Melba"));
        bike.loadPassanger(new Person("Marta"));
        bike.loadPassanger(new Person("Amanda"));
        bike.setTotalPassangerSeats(2);
        System.out.println(bike.getPassanger().size());

        Bike bike2 = new Bike(engine);
        bike2.loadPassanger(new Person("Patr4a"));
        bike2.loadPassanger(new Person("Melsa"));
        bike2.loadPassanger(new Person("Ma]a"));
        bike2.loadPassanger(new Person("Am"));
        bike2.setTotalPassangerSeats(5);
        System.out.println(bike.getPassanger().size());
        */


        //CombustionEngine engine = new CombustionEngine();
        ElectricEngine electricEngine = new ElectricEngine(50_000);
        PassengerVehicles bike2 = new Bike(electricEngine);
        ((Bike) bike2).setName("Maria");

        PassengerVehicles bike = new Bike(electricEngine);
        ((Vehicle)bike).setName("BMX");

        System.out.println(((Vehicle)bike2).getEngine());
        System.out.println(((Vehicle)bike).getEngine());

        //((CombustionEngine)((Vehicle)bike).getEngine()).setFuelType(CombustionEngine.FuelType.KEROSENE);
        //((CombustionEngine) bike.getEngine()).setFuelType("Gasoline");

        ((Vehicle)bike).accelerate("Vroom");
        ((Vehicle)bike).accelerate("Vroom");
        ((Vehicle)bike).accelerate("Vroom");
        ((Vehicle)bike).accelerate("Vroom");
        System.out.println(((Vehicle)bike).getEngine());
        ((Vehicle)bike).brake();
        bike.setTotalPassengerSeats(2);

        try {
            bike.loadPassanger(new Person("Patricia"));
            bike2.loadPassanger(new Person("Melba"));
            bike.loadPassanger(new Person("Marta"));
            bike.loadPassanger(new Person("Amanda"));
        } catch (PassangerException e) {
            e.printStackTrace();
        }

        System.out.println("");
        ((Vehicle)bike2).accelerate("Brrrr");
        ((Vehicle)bike2).accelerate("brrrrr");
        System.out.println(((Vehicle)bike2).getEngine());
        System.out.println(((Vehicle)bike2).getName());
    }
}
