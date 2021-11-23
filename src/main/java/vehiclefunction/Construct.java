package vehiclefunction;

import vehicle.power.CombustionEngine;
import vehicle.power.ElectricEngine;
import vehicle.power.Engine;

public class Construct {

    public static Engine copy(Engine engine) {
        if(engine instanceof ElectricEngine) {
            return new ElectricEngine(((ElectricEngine) engine).getBatteryCapacity());
        }
        else if(engine instanceof CombustionEngine) {
            return new CombustionEngine(((CombustionEngine) engine).getFuelType()
                    , ((CombustionEngine) engine).getTotalEngines()
                    , ((CombustionEngine) engine).getTankCapacity());
        }

        return null;
    }
}
