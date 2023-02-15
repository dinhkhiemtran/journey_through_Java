package main.classes.bowling_game;

public class Frame {
    int first;
    int second;
    int fillBall;

    public Frame(int first) {
        this.first = first;
        this.second = 0;
    }

    public int sum() {
        return first + second +fillBall;
    }

    public boolean isStrike() {
        return first == 10;
    }

    public boolean isSpare() {
        return !isStrike() && sum() == 10;
    }

    @Override
    public String toString() {
        return "Frame{" +
                "first=" + first +
                ", second=" + second +
                ", fillBall=" + fillBall +
                '}';
    }
}
