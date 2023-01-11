package Boolean;

public class AnnalynsInfiltration {

    public static boolean canFastAttack(boolean knightIsAwake) {
        return !knightIsAwake;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        return knightIsAwake || archerIsAwake || prisonerIsAwake;
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        return !archerIsAwake && prisonerIsAwake;
    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {
        return (!knightIsAwake && !archerIsAwake && prisonerIsAwake) || (!archerIsAwake && petDogIsPresent);
    }

    public static void testCase1(){
        boolean knightIsAwake = false;
        System.out.println(canFastAttack(knightIsAwake));
    }

    public static void testCase2(){
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        System.out.println(canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake));
    }

    public static void testCase3(){
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        System.out.println(canSignalPrisoner(archerIsAwake, prisonerIsAwake));
    }

    public static void testCase4(){
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = false;
        System.out.println(canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent));
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
        testCase4();
    }
}
