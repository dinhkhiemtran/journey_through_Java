package main.numbers;

public class CarsAssembleSolution2 {

    private final static int PRODUCED_EACH_HOUR = 21;

    public static double productionRatePerHour(int speed) {
        if (speed >= 5 && speed <= 8){
            return speed * PRODUCED_EACH_HOUR * 0.9;
        } else if (speed == 9) {
            return speed * PRODUCED_EACH_HOUR * 0.8;
        } else if (speed == 10) {
            return speed * PRODUCED_EACH_HOUR * 7.7;
        }
        return speed * PRODUCED_EACH_HOUR;
    }

    public static int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }

    public static void main(String[] args) {
        CarsAssembleSolution2 carsAssembleSolution2 = new CarsAssembleSolution2();
        double productionRatePerHour = carsAssembleSolution2.productionRatePerHour(6);
        System.out.println(productionRatePerHour);
        int workingWorkingItemsPerMinute = carsAssembleSolution2.workingItemsPerMinute(5);
        System.out.println(workingWorkingItemsPerMinute);
    }
}
