package vehicle.power;

import exceptions.LowBatteryException;

import java.time.Duration;

public class ElectricEngine extends Engine {

    private float batteryCapacity;

    public ElectricEngine(float batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public float getBatteryCapacity() {
        return batteryCapacity;
    }

    public float getAvailableCapacity(){
        return (this.getLevel() * this.batteryCapacity)/100;
    }

    @Override
    public void accelerate(Depth depth, Duration duration) throws LowBatteryException{
        byte tankLevel = (byte) Math.round(this.getLevel() - (depth.getDepth() * duration.getSeconds() * 0.8));
        if (tankLevel <= 0){
            throw new LowBatteryException("Your battery is dead.");
        }else if (this.getLevel() <= 15){
            System.out.println("Your battery is low, you should recharge it.");
            this.setLevel(tankLevel);
        }
        else{
            this.setLevel(tankLevel);
        }
    }

    @Override
    public String toString() {
        return "ElectricEngine{" +
                "batteryCapacity=" + batteryCapacity +
                ", batteryLevel=" + this.getLevel() +
                '}';
    }
}