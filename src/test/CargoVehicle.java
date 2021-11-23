package transported;
import vehicle.Vehicle;

public abstract class CargoVehicle extends Vehicle {

    private float totalCargoCapacity = 20000;
    private float totalAvailableCapacity = 0;

    public void loadCargo(Cargo cargo){
        totalAvailableCapacity += cargo.getWeight();
        System.out.println(totalAvailableCapacity);
    }

    public void unloadCargo(float cargo){
        totalAvailableCapacity -= cargo;
        System.out.println(totalAvailableCapacity);
    }

    public float getTotalCargoCapacity() {
        return totalCargoCapacity;
    }

    public float getTotalAvailableCapacity() {
        return totalAvailableCapacity;
    }

    @Override
    public String toString() {
        return "CargoVehicle{" +
                "totalCargoCapacity=" + totalCargoCapacity +
                ", totalAvailableCapacity=" + totalAvailableCapacity +
                '}';
    }
}
