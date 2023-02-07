package main.numbers;

import java.util.Map;

public class CarsAssembleSolution1 {

    private final static int PRODUCED_EACH_HOUR = 21;

    private final static Map<Integer, Double> SUCCESS_RATE = Map.ofEntries(
            Map.entry(1, 1.0),
            Map.entry(2, 1.0),
            Map.entry(3, 1.0),
            Map.entry(4, 1.0),
            Map.entry(5, 0.9),
            Map.entry(6, 0.9),
            Map.entry(7, 0.9),
            Map.entry(8, 0.9),
            Map.entry(9, 0.8),
            Map.entry(10, 0.77)
    );


    public static double getProductionRatePerHour(int speed) {
        return speed * PRODUCED_EACH_HOUR * SUCCESS_RATE.get(speed);
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
