package main.inheritance;

public class Warrior extends Fighter{

    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }

    @Override
    public int damagePoints(Fighter wizard) {
        return wizard.isVulnerable()? 10: 6;
    }
}
