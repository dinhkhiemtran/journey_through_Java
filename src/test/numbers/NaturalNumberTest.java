package test.numbers;

import main.numbers.natural_number.Classification;
import main.numbers.natural_number.NaturalNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class NaturalNumberTest {
    @Test
    public void testSmallPerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, new NaturalNumber(6).getClassification());
    }

    @Test
    public void testMediumPerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, new NaturalNumber(28).getClassification());
    }

    @Test
    public void testLargePerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, new NaturalNumber(33550336).getClassification());
    }

    @Test
    public void testSmallAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, new NaturalNumber(12).getClassification());
    }

    @Test
    public void testMediumAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, new NaturalNumber(30).getClassification());
    }

    @Test
    public void testLargeAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, new NaturalNumber(33550335).getClassification());
    }

    @Test
    public void testSmallestPrimeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(2).getClassification());
    }

    @Test
    public void testSmallestNonPrimeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(4).getClassification());
    }

    @Test
    public void testMediumDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(32).getClassification());
    }

    @Test
    public void testLargeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(33550337).getClassification());
    }

    @Test
    public void testThatOneIsCorrectlyClassifiedAsDeficient() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(1).getClassification());
    }

    @Test
    public void testThatNonNegativeIntegerIsRejected() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new NaturalNumber(0))
                .withMessage("You must supply a natural number (positive integer)");
    }

    @Test
    public void testThatNegativeIntegerIsRejected() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new NaturalNumber(-1))
                .withMessage("You must supply a natural number (positive integer)");
    }
}