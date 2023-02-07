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


    public double productionRatePerHour(int speed) {
        return speed * PRODUCED_EACH_HOUR * SUCCESS_RATE.get(speed);
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }

    public static void main(String[] args) {
        CarsAssembleSolution1 carsAssembleSolution1 = new CarsAssembleSolution1();
        double productionRatePerHour = carsAssembleSolution1.productionRatePerHour(6);
        System.out.println(productionRatePerHour);
        int workingWorkingItemsPerMinute = carsAssembleSolution1.workingItemsPerMinute(5);
        System.out.println(workingWorkingItemsPerMinute);
    }
}
