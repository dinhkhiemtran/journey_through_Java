package test.strings;

import main.strings.Twofer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoferTest {

    private Twofer twofer;


    @Test
    public void noNameGiven() {
        twofer = new Twofer();
        assertThat(twofer.twofer(null))
                .isEqualTo("One for you, one for me.");
    }

    @Test
    public void aNameGiven() {
        twofer = new Twofer();
        assertThat(twofer.twofer("Alice"))
                .isEqualTo("One for Alice, one for me.");
    }
    @Test
    public void anotherNameGiven() {
        twofer = new Twofer();
        assertThat(twofer.twofer("Bob"))
                .isEqualTo("One for Bob, one for me.");
    }

}