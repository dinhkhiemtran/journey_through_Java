package main.basic;

public class Lasagna {

    // TODO: define the 'expectedMinutesInOven()' method

    private int EXPECTED_OVEN_TIME_IN_MINUTES = 40;

    private int MINUTES_TO_PREPARE = 2;

    public int expectedMinutesInOven(){
        return EXPECTED_OVEN_TIME_IN_MINUTES;
    }

    // // TODO: define the 'remainingMinutesInOven()' method

    public int remainingMinutesInOven(int actualMinutes){
        return EXPECTED_OVEN_TIME_IN_MINUTES - actualMinutes;
    }

    // // TODO: define the 'preparationTimeInMinutes()' method

    public int preparationTimeInMinutes(int numberOfLayers){
        return numberOfLayers * MINUTES_TO_PREPARE;
    }

    // // TODO: define the 'totalTimeInMinutes()' method

    public int totalTimeInMinutes(int numberOfLayers, int numberOfMinutes){
        return preparationTimeInMinutes(numberOfLayers) + numberOfMinutes;
    }

    public static void main(String[] args) {
        Lasagna lasagna = new Lasagna();
        System.out.println(lasagna.expectedMinutesInOven());
        System.out.println(lasagna.remainingMinutesInOven(30));
        System.out.println(lasagna.preparationTimeInMinutes(2));
        System.out.println(lasagna.totalTimeInMinutes(3, 20));
    }
}
