package main.switch_statements;

import java.util.Scanner;

public class FootballMatchReports {

    private static Scanner scanner = new Scanner(System.in);

    public int getShirtNum(){
        System.out.print("Shirt Number: ");
        int shirtNumb = scanner.nextInt();
        return shirtNumb;
    }

    public static String onField(int shirtNum) {
        switch (shirtNum) {
            case 1:
                return "goalie";
            case 2:
                return "left back";
            case 3:
            case 4:
                return "center back";
            case 5:
                return "right back";
            case 6:
            case 7:
            case 8:
                return "midfielder";
            case 9:
                return "left wing";
            case 10:
                return "striker";
            case 11:
                return "right wing";
            default:
                throw new IllegalArgumentException();
        }
    }

    private void display(){
        int shirtNumb = getShirtNum();
        System.out.println("Position on field: " + onField(shirtNumb));
    }

    public static void main(String[] args) {
        FootballMatchReports footballMatchReports = new FootballMatchReports();
        footballMatchReports.display();
    }
}
