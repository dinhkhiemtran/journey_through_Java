package main.numbers;

public class Rational {
    private int numerator;

    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    private void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
    }

    private int gcd(int numerator, int denominator) {
        return denominator == 0 ? numerator : gcd(denominator, numerator % denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Rational add(Rational other) {
        int n = numerator * other.getDenominator() + other.getNumerator() * denominator;
        int d = denominator * other.getDenominator();
        return new Rational(n, d);
    }

    public Rational subtract(Rational other) {
        int n = numerator * other.getDenominator() - other.getNumerator() * denominator;
        int d = denominator * other.getDenominator();
        return new Rational(n, d);
    }

    public Rational multiply(Rational other) {
        int n = numerator * other.getNumerator();
        int d = denominator * other.getDenominator();
        return new Rational(n, d);
    }

    public Rational divide(Rational other) {
        int n = numerator * other.getDenominator();
        int d = denominator * other.getNumerator();
        return new Rational(n, d);
    }

    public Rational abs() {
        return new Rational(Math.abs(numerator), Math.abs(denominator));
    }
    // a rational raised to the nth power

    public Rational pow(int n) {
        if (n < 0) {
            int m = -n;
            return new Rational((int) Math.pow(denominator, m), (int) Math.pow(numerator, m));
        }
        return new Rational((int) Math.pow(numerator, n), (int) Math.pow(denominator, n));
    }
    // n raised to this rational

    public double exp(double n) {
        return Math.pow(Math.pow(n, 1.0 / denominator), numerator);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", this.getNumerator(), this.getDenominator());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !this.getClass().isAssignableFrom(obj.getClass())) {
            return false;
        }
        Rational other = (Rational) obj;
        return this.getNumerator() == other.getNumerator()
                && this.getDenominator() == other.getDenominator();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + this.getNumerator();
        result = prime * result + this.getDenominator();
        return result;
    }
}
