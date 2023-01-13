package classes;

public class ElonToyCar {
    private int distance;
    private int battery;

    public ElonToyCar() {
        this.battery = 100;
        this.distance = 0;
    }

    public static ElonToyCar buy() {
        return new ElonToyCar();
    }

    public String distanceDisplay() {
        return String.format("Driven %s meters", this.distance);
    }

    public String batteryDisplay() {
        if (this.battery == 0) return "Battery empty";
        return String.format("Battery at %s", this.battery);
    }

    public void drive() {
        if (this.battery != 0) {
            this.distance += 20;
            this.battery--;
        }
    }

}
