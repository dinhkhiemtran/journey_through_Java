package array;

import java.util.Arrays;

public class BirdWatcher {

    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay;
    }

    public int[] getLastWeek() {
        return birdsPerDay;
    }

    public int getToday() {
        return birdsPerDay.length == 0 ? 0 : birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodayCount() {
        int index = birdsPerDay.length - 1;
        int lastElementBeingTodayCount = birdsPerDay[index];
        int incrementTodayCount = lastElementBeingTodayCount + 1;
        System.out.println(incrementTodayCount);
    }

    public boolean hasDayWithoutBirds() {
        for (int i = 0; i < birdsPerDay.length; i++){
            if (birdsPerDay[i] == 0) return true;
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int sum = 0;
//        int min = Math.min(numberOfDays,this.birdsPerDay.length);
        for(int i = 0; i< numberOfDays; i++) {
            sum = sum +this.birdsPerDay[i];
        }
        return sum;
    }

    public int getBusyDays() {
        int busyDay = 0;
        for (int i = 0 ; i < this.birdsPerDay.length; i++){
            if (birdsPerDay[i] >= 5){
                busyDay++;
            }
        }
        return busyDay;
    }

    public static void main(String[] args) {
        int[] birdsPerDay = new int[]{2, 5, 0, 7, 4, 1};
        BirdWatcher birdWatcher = new BirdWatcher(birdsPerDay);
        int[] lastWeek = birdWatcher.getLastWeek();
        System.out.println(Arrays.toString(lastWeek));
        int today = birdWatcher.getToday();
        System.out.println(today);
        birdWatcher.incrementTodayCount();
        System.out.println(birdWatcher.hasDayWithoutBirds());
        int countingFirstDays = birdWatcher.getCountForFirstDays(4);
        System.out.println(countingFirstDays);
        int busyDays = birdWatcher.getBusyDays();
        System.out.println(busyDays);
    }
}
