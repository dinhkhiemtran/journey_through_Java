package main.numbers;

public class ComplexNumber {

    private Double real;

    private Double image;

    public ComplexNumber(double real, double image) {
        this.real = real;
        this.image = image;
    }

    ComplexNumber(double real) {
        this.real = real;
        this.image = 0.0;
    }

    public Double getReal() {
        return real;
    }

    public void setReal(Double real) {
        this.real = real;
    }

    public Double getImag() {
        return image;
    }

    public void setImage(Double image) {
        this.image = image;
    }

    public ComplexNumber times(ComplexNumber other) {
        double realPart = real * other.getReal() - image * other.getImag();
        double imagePart = real * other.getImag() + image * other.getReal();
        return new ComplexNumber(realPart, imagePart);
    }

    public ComplexNumber add(ComplexNumber other) {
        double realPart = real + other.getReal();
        double imagPart = image + other.getImag();
        return new ComplexNumber(realPart, imagPart);
    }

    public ComplexNumber minus(ComplexNumber other) {
        double realPart = real - other.getReal();
        double imagPart = image - other.getImag();
        return new ComplexNumber(realPart, imagPart);
    }

    public ComplexNumber div(ComplexNumber other) {
        // division of two complex numbers:
        // (a + ib)/(c + id) = (ac + db)/(c^2 + d^2) + i(bc - da)/(c^2 + d^2)
        double realPart = (real * other.getReal() + image * other.getImag()) /
                (other.getReal() * other.getReal() + other.getImag() * other.getImag());
        double imagePart = (image * other.getReal() - real * other.getImag()) /
                (other.getReal() * other.getReal() + other.getImag() * other.getImag());
        return new ComplexNumber(realPart, imagePart);
    }

    public ComplexNumber exponentialOf() {
        // Exponential of a complex number:
        // exp(x + iy) = exp(x)*exp(iy) = exp(x)(cosy + isiny)
        double realPart = Math.pow(Math.E, real) * Math.cos(image);
        double imagPart = Math.pow(Math.E, real) * Math.sin(image);
        return new ComplexNumber(realPart, imagPart);
    }

    public Double abs() {
        // Abs of a complex:
        // abs(x + iy) = sqrt(x^2 + y^2)
        return Math.sqrt(Math.pow(real, 2) + Math.pow(image, 2));
    }

    public ComplexNumber conjugate() {
        // conjugate of a complex:
        // conj(x + yi) = x - iy
        return new ComplexNumber(real, -image);
    }
}
