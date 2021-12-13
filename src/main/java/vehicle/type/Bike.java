package vehicle.type;

import vehiclefunction.PassengerCargoVehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vehicle.power.Engine;

public class Bike extends PassengerCargoVehicle {

    private static final Logger LOGGER =  LogManager.getLogger(Bike.class);

    //Constructor
    public Bike(Engine engine, String name) {
        this.engine = Engine.copy(engine);
        this.setName(name);
        this.getEngine().setName(engine.getName());
        LOGGER.warn("Bike "+ this.getName() + " created");
    }

    @Override
    public String toString() {
        return "Bike{" +
                "engine=" + engine +
                '}';
    }
}