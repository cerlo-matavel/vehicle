package vehicle.type;

import measurements.Dimensions;
import measurements.Space;
import measurements.TareGrossWeight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vehicle.power.CombustionEngine;
import vehicle.power.Engine;
import vehiclefunction.CargoVehicle;

public class Truck extends CargoVehicle {

    private static final Logger LOGGER =  LogManager.getLogger(Truck.class);

    public Truck(Engine engine, String name, Space dimensions, TareGrossWeight tareGrossWeight) {
        this.engine = Engine.copy(engine);
        this.setName(name);
        this.setTareGrossWeight(tareGrossWeight);
        this.getEngine().setName(engine.getName());
        this.setDimensions(dimensions);
        LOGGER.warn("Truck "+ this.getName() + " created");
    }
}
