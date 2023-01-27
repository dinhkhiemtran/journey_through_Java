package interfaces.exp_and_prod_cars;

public class ExperimentalRemoteControlCar implements RemoteControlCar {

    private final int SPEED = 20;

    private int distanceTraveled;

    @Override
    public void drive() {
        distanceTraveled += SPEED;
    }

    @Override
    public int getDistanceTravelled() {
        return distanceTraveled;
    }
}
