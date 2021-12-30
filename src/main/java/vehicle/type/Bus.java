package vehicle.type;

import measurements.Space;
import measurements.TareGrossWeight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vehicle.power.Engine;
import vehiclefunction.PassengerVehicle;

public class Bus extends PassengerVehicle {

    private static final Logger LOGGER =  LogManager.getLogger(Bus.class);

    public Bus(Engine engine, String name, Space dimensions, int passengers, TareGrossWeight tareGrossWeight) {
        super(passengers);
        this.engine = Engine.copy(engine);
        this.setName(name);
        this.setTareGrossWeight(tareGrossWeight);
        this.getEngine().setName(engine.getName());
        this.setDimensions(dimensions);
        LOGGER.warn("Bus "+ this.getName() + " created");
    }
}
