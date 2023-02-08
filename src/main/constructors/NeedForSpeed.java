package main.constructors;

public class NeedForSpeed {
    private int speed, batteryDrain, distance, battery = 100;

    public NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return (battery == 0);
    }

    public int distanceDriven() {
        return distance;
    }

    public void drive() {
        if (battery > 0) {
            distance += speed;
            battery -= batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

