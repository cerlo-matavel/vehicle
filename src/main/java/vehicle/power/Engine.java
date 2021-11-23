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
}