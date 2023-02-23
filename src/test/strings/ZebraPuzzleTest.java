package test.strings;

import main.strings.ZebraPuzzle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZebraPuzzleTest {
    @Test
    public void residentWhoDrinksWater() {
        ZebraPuzzle zebraPuzzle = new ZebraPuzzle();
        assertEquals("Norwegian", zebraPuzzle.getWaterDrinker());
    }

    @Test
    public void residentWhoOwnsZebra() {
        ZebraPuzzle zebraPuzzle = new ZebraPuzzle();
        assertEquals("Japanese", zebraPuzzle.getZebraOwner());
    }
}