package main.date_time;

public class Clock {

    private int hours;

    private int minutes;

    public Clock(int hours, int minutes) {
        this.hours = 0;
        this.minutes = 0;
        this.add(minutes);
        this.addHours(hours);
    }

    public void add(int minutes) {
        if (minutes > 0) {
            this.minutes += minutes;
            while (this.minutes >= 60) {
                this.minutes -= 60;
                this.addHours(1);
            }
        } else {
            this.minutes += minutes;
            while (this.minutes < 0) {
                this.minutes += 60;
                this.addHours(-1);
                //System.out.printf("%s\n",this.toString());
            }
            //System.out.printf("%s\n",this.toString());
        }
    }

    public void addHours(int hours) {
        if (hours > 0) {
            this.hours += hours;
            while (this.hours >= 24) {
                this.hours -= 24;
                //System.out.printf("%s\n",this.toString());
            }
            //System.out.printf("%s\n",this.toString());
        } else {
            this.hours += hours;
            while (this.hours < 0) {
                this.hours += 24;
                //System.out.printf("%s\n",this.toString());
            }
            //System.out.printf("%s\n",this.toString());
        }
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o.getClass() != this.getClass()) {
            return false;
        } else {
            Clock ck = (Clock) o;
            if (this.minutes == ck.getMinutes()) {
                if (this.hours == ck.getHours()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.hours * 10 + this.minutes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.hours == 0) {
            sb.append("00");
        } else if (this.hours < 10) {
            sb.append(String.format("0%d", this.hours));
        } else {
            sb.append(this.hours);
        }
        sb.append(':');
        if (this.minutes == 0) {
            sb.append("00");
        } else if (this.minutes < 10) {
            sb.append(String.format("0%d", this.minutes));
        } else {
            sb.append(this.minutes);
        }
        return sb.toString();
    }
}
