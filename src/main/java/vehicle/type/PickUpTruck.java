package vehicle.type;

import measurements.Dimensions;
import measurements.Space;
import vehicle.power.Engine;

public class PickUpTruck extends Truck {

    public PickUpTruck(Engine engine, String name, Space dimensions) {
        super(engine, name, dimensions);
    }
}
