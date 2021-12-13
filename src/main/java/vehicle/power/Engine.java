package vehicle.power;

import java.time.Duration;

public abstract class Engine {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void accelerate(int depth, Duration duration){
        duration.getSeconds();
    }

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