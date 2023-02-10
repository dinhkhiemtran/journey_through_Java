package main.ternary_operators;

import java.util.Scanner;

public class SalaryCalculator {

    private static Scanner scanner = new Scanner(System.in);

    private static final double REGULAR_SALARY_MULTIPLIER = 1;

    private static final int DAYS_SKIPPED_ALLOWANCE = 5;

    private static final double DAYS_SKIPPED_SALARY_MULTIPLIER = 0.85;

    private static final int REGULAR_BONUS_MULTIPLIER = 10;

    private static final int SIGNIFICANT_NUM_PRODUCTS = 20;

    private static final int SIGNIFICANT_NUM_PRODUCTS_BONUS_MULTIPLIER = 13;

    private static final double BASE_SALARY = 1000.0;

    private static final double MAX_TOTAL_SALARY = 2000.0;


    public double multiplierPerDaysSkipped(int daysSkipped) {
        return daysSkipped > DAYS_SKIPPED_ALLOWANCE ?
                DAYS_SKIPPED_SALARY_MULTIPLIER : REGULAR_SALARY_MULTIPLIER;
    }

    public int multiplierPerProductsSold(int productsSold) {
        return productsSold > SIGNIFICANT_NUM_PRODUCTS ? SIGNIFICANT_NUM_PRODUCTS_BONUS_MULTIPLIER : REGULAR_BONUS_MULTIPLIER;
    }

    public double bonusForProductSold(int productsSold) {
        return this.multiplierPerProductsSold(productsSold) * productsSold;
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double salary = BASE_SALARY * this.multiplierPerDaysSkipped(daysSkipped) + this.bonusForProductSold(productsSold);
        return Math.min(salary, MAX_TOTAL_SALARY);
    }

    public int getDaySkipped() {
        System.out.print("Day skipped: ");
        int numberOfDaysSkipped = scanner.nextInt();
        return numberOfDaysSkipped;
    }

    public int getProductSold() {
        System.out.print("Products Sold: ");
        int productsSold = scanner.nextInt();
        return productsSold;
    }

    public void getSalary() {
        int daysSkipped = getDaySkipped();
        int productsSold = getProductSold();
        System.out.println("Salary: " + finalSalary(daysSkipped, productsSold));
    }

    public static void main(String[] args) {
        SalaryCalculator calculator = new SalaryCalculator();
        calculator.getSalary();
    }
}
