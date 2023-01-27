package interfaces.exp_and_prod_cars;

public class ProductionRemoteControlCar implements Comparable<ProductionRemoteControlCar>, RemoteControlCar {

    private int numberOfVictories = 0;

    private int distanceTravelled = 0;

    private int speed = 10;

    @Override
    public void drive() {
        distanceTravelled += speed;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar o) {
        return this.numberOfVictories - o.numberOfVictories;
    }
}
