package vehicle.power;

import java.time.Duration;

public abstract class Engine {

    enum Depth {
        LIGHT_PEDAL(0.25), MEDIUM_PEDAL(0.5), FULL_PEDAL(1);

        private double depth;

        Depth(double depth) {
            this.depth = depth;
        }

        public double getDepth() {
            return depth;
        }
    }

    private String name;

    private byte Level = 100;

    public void recharge(){
        this.Level = 100;
    }

    public void setLevel(byte level) {
        this.Level = level;
    }

    public byte getLevel() {
        return Level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void accelerate(Depth depth, Duration duration) throws RuntimeException;

    public static Engine copy(Engine engine) {
        if (engine instanceof ElectricEngine) {
            return new ElectricEngine(((ElectricEngine) engine).getBatteryCapacity());
        }
        return new CombustionEngine(((CombustionEngine) engine).getFuelType()
                , ((CombustionEngine) engine).getTotalEngines()
                , ((CombustionEngine) engine).getTankCapacity());

    }
}