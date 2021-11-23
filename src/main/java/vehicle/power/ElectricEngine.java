package vehicle.power;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ElectricEngine extends Engine {

    private int batteryCapacity = 10_000, batteryLevel = 100;
    private static final Logger LOGGER =  LogManager.getLogger(ElectricEngine.class);

    public void rechargeBattery(){
        //LOGGER.info(+ "Battery charged");
        this.batteryLevel = 100;
    }

    public ElectricEngine(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public String toString() {
        return "ElectricEngine{" +
                "batteryCapacity=" + batteryCapacity +
                ", batteryLevel=" + batteryLevel +
                '}';
    }
}