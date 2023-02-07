package main.for_loop;

import java.util.Arrays;

public class BirdWatcherSolution {

    private int[] birdsPerDay;

    public BirdWatcherSolution(int[] birdsPerDay){
        this.birdsPerDay = birdsPerDay;
    }

    public int[] getLastWeek(){
        return birdsPerDay;
    }

    public int getToday(){
        return birdsPerDay.length == 0 ? 0 : birdsPerDay[birdsPerDay.length -1];
    }

    public int incrementTodayCount(){
        return ++birdsPerDay[birdsPerDay.length - 1];
    }

    public boolean hasDayWithoutBirds(){
        return Arrays.stream(birdsPerDay).filter(elements -> elements == 0).findAny().isPresent();
    }

    public int getCountForFirstDays(int numberOfDays){
        return Arrays.stream(birdsPerDay).limit(numberOfDays).sum();
    }

    public int getBusyDays(){
        return (int)Arrays.stream(birdsPerDay).filter(elements -> elements >= 5).count();
    }

    public static void main(String[] args) {
        int[] birdsPerDay = new int[]{2, 5, 0, 7, 4, 1};
        BirdWatcherSolution birdWatcherSolution = new BirdWatcherSolution(birdsPerDay);
        System.out.println(Arrays.toString(birdWatcherSolution.getLastWeek()));
        System.out.println(birdWatcherSolution.getToday());
        System.out.println(birdWatcherSolution.incrementTodayCount());
        System.out.println(birdWatcherSolution.hasDayWithoutBirds());
        System.out.println(birdWatcherSolution.getCountForFirstDays(4));
        System.out.println(birdWatcherSolution.getBusyDays());
    }
}
