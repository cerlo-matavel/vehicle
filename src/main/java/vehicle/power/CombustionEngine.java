package vehicle.power;

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
    private short fuelTankLevel = 100;

    public CombustionEngine(FuelType fuelType, int totalEngines, int tankCapacity) {
        this.fuelType = fuelType;
        this.totalEngines = (short) totalEngines;
        this.tankCapacity = tankCapacity;
    }

    public short getFuelTankLevel() {
        return fuelTankLevel;
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

    public void fillTank(){
        fuelTankLevel = (short)100;
        System.out.println("Tank filled.");
    }

    @Override
    public String toString() {
        return "CombustionEngine{" +
                "totalEngines=" + totalEngines +
                ", fuelType='" + fuelType + '\'' +
                ", fuelTankLevel=" + fuelTankLevel +
                '}';
    }
}
