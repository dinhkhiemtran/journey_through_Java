package main.constructors;

import java.util.Random;

public class DnDCharacter {

    private Random random;

    private final int strength;

    private final int dexterity;

    private final int constitution;

    private final int intelligence;

    private final int wisdom;

    private final int charisma;

    public DnDCharacter() {
        this.random = new Random();
        this.strength = ability();
        this.dexterity = ability();
        this.constitution = ability();
        this.intelligence = ability();
        this.wisdom = ability();
        this.charisma = ability();
    }

    public int ability() {
        return random.ints(4, 1, 7)
                .sorted()
                .skip(1)
                .sum();
    }

    public int modifier(int input) {
        return Math.floorDiv(input - 10, 2);
    }

    public int getStrength() {
        return this.strength;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public int getConstitution() {
        return this.constitution;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public int getWisdom() {
        return this.wisdom;
    }

    public int getCharisma() {
        return this.charisma;
    }

    public int getHitpoints() {
        return 10 + modifier(constitution);
    }
}
