package main.condinations_if;

public class Darts {

    private final static int INNER_RING = 1;
    private final static int MIDDLE_RING = 5;
    private final static int OUTER_RING = 10;

    public int score(double xOfDart, double yOfDart) {
        double distance = Math.sqrt(Math.pow(xOfDart, 2) + Math.pow(yOfDart, 2));
        if (distance > OUTER_RING) {
            return 0;
        } else if (distance > MIDDLE_RING) {
            return INNER_RING;
        } else if (distance > INNER_RING) {
            return MIDDLE_RING;
        } else {
            return OUTER_RING;
        }
    }
}
