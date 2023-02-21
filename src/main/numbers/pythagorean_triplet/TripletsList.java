package main.numbers.pythagorean_triplet;

import java.util.ArrayList;
import java.util.List;

public class TripletsList {
    private int n;

    private Integer maxFactor = null;
    //
    //    This is the limit of the ratio of legs a, b: a = b
    //    a < b => a < n/(2 + √2)
    //

    private static final double PERIMETER_RATIO_LIMIT = 1 + 1 + Math.sqrt(2);

    public TripletsList withFactorsLessThanOrEqualTo(int maxFactor) {
        this.maxFactor = maxFactor;
        return this;
    }

    public TripletsList thatSumTo(int n) {
        this.n = n;
        if (maxFactor == null) {
            maxFactor = n;
        }
        return this;
    }
    //
    //    Assuming that a + b + c = n and a² + b² = c², then:
    //    b + c = n - a
    //    and
    //    a² + b² + 2bc + c² = c² + 2bc + c²
    //    a² + (b + c)² = 2bc + 2c²
    //    a² + (b + c)² = c(2b + 2c)
    //
    //    a² + (b + c)²
    //    ------------- = c
    //      2(b + c)
    //
    //    Substituting n - a for b + c:
    //    a² + (n - a)²
    //    ------------- = c
    //      2(n - a)
    //

    public List<PythagoreanTriplet> build() {
        List<PythagoreanTriplet> triplets = new ArrayList<>();
        for (int i = 1; i <= Math.floor(n / PERIMETER_RATIO_LIMIT); i++) {
            int numerator = i * i + (int) Math.pow(n - i, 2);
            int denominator = 2 * (n - i);
            if (numerator % denominator == 0) {
                int c = numerator / denominator;
                if (c <= maxFactor) {
                    int b = n - i - c;
                    triplets.add(new PythagoreanTriplet(i, b, c));
                }
            }
        }
        return triplets;
    }
}
