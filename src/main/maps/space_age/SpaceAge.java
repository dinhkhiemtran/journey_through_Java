package main.maps.space_age;

import java.util.HashMap;

public class SpaceAge {
    private double seconds;

    private static HashMap<Planet, Double> AGE = new HashMap<>();

    public SpaceAge(double seconds) {
        this.seconds = seconds;
        double ageOnEarth = getSeconds() / 31557600;
        AGE.put(Planet.EARTH, ageOnEarth);
        AGE.put(Planet.MERCURY, ageOnEarth / 0.2408467);
        AGE.put(Planet.VENUS, ageOnEarth / 0.61519726);
        AGE.put(Planet.MARS, ageOnEarth / 1.8808158);
        AGE.put(Planet.JUPITER, ageOnEarth / 11.862615);
        AGE.put(Planet.SATURN, ageOnEarth / 29.447498);
        AGE.put(Planet.URANUS, ageOnEarth / 84.016846);
        AGE.put(Planet.NEPTUNE, ageOnEarth / 164.79132);
    }

    double getSeconds() {
        return seconds;
    }

    public double onEarth() {
        return AGE.get(Planet.EARTH);
    }

    public double onMercury() {
        return AGE.get(Planet.MERCURY);
    }

    public double onVenus() {
        return AGE.get(Planet.VENUS);
    }

    public double onMars() {
        return AGE.get(Planet.MARS);
    }

    public double onJupiter() {
        return AGE.get(Planet.JUPITER);
    }

    public double onSaturn() {
        return AGE.get(Planet.SATURN);
    }

    public double onUranus() {
        return AGE.get(Planet.URANUS);
    }

    public double onNeptune() {
        return AGE.get(Planet.NEPTUNE);
    }
}
