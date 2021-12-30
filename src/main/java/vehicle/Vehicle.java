package vehicle;

import measurements.Space;
import measurements.TareGrossWeight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vehicle.power.Engine;

public abstract class Vehicle {
    private TareGrossWeight tareGrossWeight;
    private String name;
    protected Engine engine;
    private String color;
    private Space dimensions;

    private static final Logger LOGGER = LogManager.getLogger(Vehicle.class);

    //TareGrossWeight
    public TareGrossWeight getTareGrossWeight() {
        return tareGrossWeight;
    }

    //protected
    public void setTareGrossWeight(TareGrossWeight tareGrossWeight) {
        this.tareGrossWeight = tareGrossWeight;
    }

    //Dimensions
    public Space getDimensions() {
        return dimensions;
    }

    protected void setDimensions(Space dimensions) {
        this.dimensions = dimensions;
    }

    //Color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //Engine
    public Engine getEngine() {
        return engine;
    }

    //Name
    public String getName() {
        return name;
    }

    protected void setName(String name) {
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
