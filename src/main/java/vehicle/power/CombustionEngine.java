package vehicle.power;

import exceptions.LowTankException;

import java.time.Duration;

public class CombustionEngine extends Engine {

    public enum FuelType {
        GASOLINE("Gasoline"),DIESEL("Diesel"), KEROSENE("Kerosene");

        private final String fuel;

        FuelType(String fuel){
            this.fuel = fuel;
        }

        public String getFuel() {
            return fuel;
        }
    }

    private final FuelType fuelType;
    private final short totalEngines;
    private final int tankCapacity;

    public CombustionEngine(FuelType fuelType, int totalEngines, int tankCapacity) {
        this.fuelType = fuelType;
        this.totalEngines = (short) totalEngines;
        this.tankCapacity = tankCapacity;
    }

    public short getTotalEngines() {
        return totalEngines;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public float getAvailableCapacity(){
        return (this.getLevel() * this.tankCapacity)/100;
    }

    @Override
    public void accelerate(Depth depth, Duration duration) throws LowTankException {
        byte tankLevel = (byte) Math.round(this.getLevel() - (depth.getDepth() * duration.getSeconds() * 0.8));
        if (tankLevel <= 0){
            throw new LowTankException("Your tank is empty.");
        }else if (this.getLevel() <= 15){
            System.out.println("Your tank is almost empty, you should refill it.");
            this.setLevel(tankLevel);
        }
        else{
            this.setLevel(tankLevel);
        }
    }

    @Override
    public String toString() {
        return "CombustionEngine{" +
                "totalEngines=" + totalEngines +
                ", fuelType='" + fuelType + '\'' +
                ", fuelTankLevel=" + this.getLevel() +
                '}';
    }
}
