package main.date_time.meet_up;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.*;

public class Meetup {

    private final int month;
    private final int year;

    public Meetup(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public LocalDate day(DayOfWeek dayOfWeek, MeetupSchedule schedule) {
        LocalDate meetingDate = LocalDate.of(year, month, 13);
        switch (schedule) {
            case FIRST:
                return meetingDate.with(firstInMonth(dayOfWeek));
            case SECOND:
                return meetingDate.with(dayOfWeekInMonth(2, dayOfWeek));
            case THIRD:
                return meetingDate.with(dayOfWeekInMonth(3, dayOfWeek));
            case FOURTH:
                return meetingDate.with(dayOfWeekInMonth(4, dayOfWeek));
            case LAST:
                return meetingDate.with(lastInMonth(dayOfWeek));

            case TEENTH:
                return meetingDate.with(nextOrSame(dayOfWeek));
            default:
                throw new IllegalStateException("The switch case statement is expected to be exhaustive as to never reach this code path here.");
        }
    }

}
