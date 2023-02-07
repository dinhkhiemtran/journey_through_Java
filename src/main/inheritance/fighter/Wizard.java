package main.inheritance.fighter;

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
    int damagePoints(Fighter warrior) {
        return spellPrepared ? 12 : 3;
    }

    void prepareSpell() {
        spellPrepared = true;
    }
}
