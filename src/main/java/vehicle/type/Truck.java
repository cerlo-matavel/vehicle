package vehicle.type;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vehicle.power.Engine;
import vehiclefunction.CargoVehicle;

public class Truck extends CargoVehicle {

    private static final Logger LOGGER =  LogManager.getLogger(Truck.class);
    public Truck(Engine engine, String name) {
        this.engine = Engine.copy(engine);
        this.setName(name);
        this.getEngine().setName(engine.getName());
        LOGGER.warn("Truck "+ this.getName() + " created");
    }
}
