package vehicle.type;

import measurements.Space;
import measurements.TareGrossWeight;
import vehiclefunction.PassengerCargoVehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vehicle.power.Engine;

public class Bike extends PassengerCargoVehicle {

    private static final Logger LOGGER =  LogManager.getLogger(Bike.class);

    //Constructor
    public Bike(Engine engine, String name) {
        super(3);
        this.engine = Engine.copy(engine);
        this.setName(name);
        this.setTareGrossWeight(new TareGrossWeight(100, 200));
        this.getEngine().setName(engine.getName());
        LOGGER.warn("Bike "+ this.getName() + " created");
    }

    public Bike(Engine engine, String name, Space dimensions, int passengers, TareGrossWeight tareGrossWeight) {
        super(passengers);
        this.engine = Engine.copy(engine);
        this.setName(name);
        this.setTareGrossWeight(tareGrossWeight);
        this.getEngine().setName(engine.getName());
        this.setDimensions(dimensions);
        LOGGER.warn("Bike "+ this.getName() + " created");
    }

    @Override
    public String toString() {
        return "Bike{" +
                "engine=" + engine +
                '}';
    }
}