package vehicle.type;

import measurements.Space;
import measurements.TareGrossWeight;
import vehicle.power.Engine;

public class PickUpTruck extends Truck {

    public PickUpTruck(Engine engine, String name, Space dimensions, TareGrossWeight tareGrossWeight) {
        super(engine, name, dimensions, tareGrossWeight);
    }
}
