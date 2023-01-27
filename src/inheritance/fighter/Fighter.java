package inheritance.fighter;

abstract class Fighter {

    public boolean isVulnerable() {return false;}

    abstract int damagePoints(Fighter fighter);

}
