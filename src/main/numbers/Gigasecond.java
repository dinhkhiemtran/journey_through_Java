package main.numbers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Gigasecond {

    private final long GIGA_SECOND = 1_000_000_000l;

    private LocalDateTime now;

    public Gigasecond(LocalDate moment) {
        this.now = moment.atStartOfDay();
    }

    public Gigasecond(LocalDateTime moment) {
        this.now = moment;
    }

    public LocalDateTime getDateTime() {
        return now.plusSeconds(GIGA_SECOND);
    }

    public static void main(String[] args) {
        Gigasecond gigaSecond = new Gigasecond(LocalDateTime.of(2015, Month.JANUARY, 24, 22, 0, 0));
        Gigasecond gigasecond = new Gigasecond(LocalDate.ofEpochDay(1));
        System.out.println(gigasecond.getDateTime());
    }
}
