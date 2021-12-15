package vehicle.type;

import measurements.Dimensions;
import measurements.Space;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vehicle.power.Engine;
import vehiclefunction.CargoVehicle;

public class Truck extends CargoVehicle {

    private static final Logger LOGGER =  LogManager.getLogger(Truck.class);

    public Truck(Engine engine, String name, Space dimensions) {
        this.engine = Engine.copy(engine);
        this.setName(name);
        this.getEngine().setName(engine.getName());
        this.setDimensions(dimensions);
        LOGGER.warn("Truck "+ this.getName() + " created");
    }
}
