package vehicle.type;

import measurements.Space;
import measurements.TareGrossWeight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vehicle.power.Engine;
import vehiclefunction.PassengerCargoVehicle;

public class Airplane extends PassengerCargoVehicle {

    private static final Logger LOGGER =  LogManager.getLogger(Airplane.class);

    public Airplane(Engine engine, String name, Space dimensions) {
        super(0);
        this.engine = Engine.copy(engine);
        this.setName(name);
        this.getEngine().setName(engine.getName());
        this.setDimensions(dimensions);
        LOGGER.warn("Airplane "+ this.getName() + " created");
    }

    public Airplane(Engine engine, String name, Space dimensions, int passengers, TareGrossWeight tareGrossWeight) {
        super(passengers);
        this.engine = Engine.copy(engine);
        this.setName(name);
        this.setTareGrossWeight(tareGrossWeight);
        this.getEngine().setName(engine.getName());
        this.setDimensions(dimensions);
        LOGGER.warn("Airplane "+ this.getName() + " created");
    }
}
