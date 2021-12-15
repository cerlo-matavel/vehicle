package vehicle;

import measurements.Dimensions;
import measurements.Space;
import measurements.TareGrossWeight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vehicle.power.CombustionEngine;
import vehicle.power.ElectricEngine;
import vehicle.power.Engine;

public abstract class Vehicle {
    private TareGrossWeight tareGrossWeight;
    private String name;
    protected Engine engine;
    private String color;
    private Space dimensions;
    private static final Logger LOGGER = LogManager.getLogger(Vehicle.class);

    public TareGrossWeight getTareGrossWeight() {
        return tareGrossWeight;
    }

    public void setTareGrossWeight(TareGrossWeight tareGrossWeight) {
        this.tareGrossWeight = tareGrossWeight;
    }

    public Space getDimensions() {
        return dimensions;
    }

    public void setDimensions(Space dimensions) {
        this.dimensions = dimensions;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public void accelerate(String engineSound) {
        //System.out.println("Accelerating " + engineSound);
        if (engine instanceof CombustionEngine){
            ((CombustionEngine) engine).setFuelTankLevel((short) (((CombustionEngine) engine).getFuelTankLevel() - 1));
        }
        else if (engine instanceof ElectricEngine) {
            ((ElectricEngine) engine).setBatteryLevel(((ElectricEngine) engine).getBatteryLevel() - 1);
        }
        LOGGER.info(this.name+ " accelerated.");
    }*/

    public void brake() {
        LOGGER.info(this.name+" braking.");
    }


}
