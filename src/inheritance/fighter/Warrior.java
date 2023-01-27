package inheritance.fighter;

public class Warrior extends Fighter{

    Wizard wizard;

    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }

    @Override
    int damagePoints(Fighter fighter) {
        return wizard.isVulnerable()? 10: 6;
    }
}
