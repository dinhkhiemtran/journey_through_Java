package main.inheritance;

public abstract class Fighter {

    public boolean isVulnerable() {return false;}

    abstract int damagePoints(Fighter fighter);

}
