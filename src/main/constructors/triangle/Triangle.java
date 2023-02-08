package main.constructors.triangle;

public class Triangle {

    private double side1;

    private double side2;

    private double side3;

    public Triangle(double side1, double side2, double side3) throws TriangleException {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        if (side1 == 0 || side2 == 0 || side3 == 0) throw new TriangleException();
        if (side1 + side2 < side3 || side1 + side3 < side2 || side2 + side3 < side1) throw new TriangleException();
    }

    public boolean isEquilateral() {
        return this.side1 == this.side2 && this.side1 == side3;
    }

    public boolean isIsosceles() {
        return this.side1 == this.side2 || this.side2 == this.side3 || this.side3 == this.side1;
    }

    public boolean isScalene() {
        return !isIsosceles() && !isIsosceles() &&
                !(isIsosceles()) && !(isEquilateral());
    }

    public static void main(String[] args) throws TriangleException {
        double side1 = 2;
        double side2 = 3;
        double side3 = 2;
        Triangle triangle = new Triangle(side1, side2, side3);
        System.out.println("Is Equilateral? " + triangle.isEquilateral());
        System.out.println("Is Isosceles? " + triangle.isIsosceles());
        System.out.println("Is Scalene? " + triangle.isScalene());
    }
}
