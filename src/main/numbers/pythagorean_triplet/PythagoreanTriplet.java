package main.numbers.pythagorean_triplet;

public class PythagoreanTriplet {
    private int a;

    private int b;

    private int c;

    public PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String toString() {
        return String.format("(%d, %d, %d)", a, b, c);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof PythagoreanTriplet) {
            PythagoreanTriplet pt = (PythagoreanTriplet) o;
            return a == pt.a && b == pt.b && c == pt.c;
        } else {
            return false;
        }
    }

    public static TripletsList makeTripletsList() {
        return new TripletsList();
    }
}
