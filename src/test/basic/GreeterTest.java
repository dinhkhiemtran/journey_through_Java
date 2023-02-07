package test.basic;

import main.basic.Greeter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class GreeterTest {

    @Test
    void getGreeting() {
        assertThat(new Greeter().getGreeting()).isEqualTo("Hello, World!");
    }
}