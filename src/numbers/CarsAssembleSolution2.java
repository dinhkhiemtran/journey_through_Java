package numbers;

public class CarsAssembleSolution2 {

    private final static int PRODUCED_EACH_HOUR = 21;

    public static double getProductionRatePerHour(int speed) {
        if (speed >= 5 && speed <= 8){
            return speed * PRODUCED_EACH_HOUR * 0.9;
        } else if (speed == 9) {
            return speed * PRODUCED_EACH_HOUR * 0.8;
        } else if (speed == 10) {
            return speed * PRODUCED_EACH_HOUR * 7.7;
        }
        return speed * PRODUCED_EACH_HOUR;
    }

    public static int getWorkingItemsPerMinute(int speed) {
        return (int) (getProductionRatePerHour(speed) / 60);
    }

    public static void main(String[] args) {
        double productionRatePerHour = getProductionRatePerHour(6);
        System.out.println(productionRatePerHour);
        int workingWorkingItemsPerMinute = getWorkingItemsPerMinute(6);
        System.out.println(workingWorkingItemsPerMinute);
    }
}
