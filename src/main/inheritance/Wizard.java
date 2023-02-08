package main.inheritance;

public class Wizard extends Fighter {
    boolean spellPrepared = false;

    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }

    @Override
    public boolean isVulnerable() {
        return !spellPrepared;
    }

    @Override
    public int damagePoints(Fighter warrior) {
        return spellPrepared ? 12 : 3;
    }

    public void prepareSpell() {
        spellPrepared = true;
    }
}
