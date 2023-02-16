package test.condinations_if;

import main.condinations_if.BlackJack;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BlackJackTest {

    @Test
    public void blackjackWithKingAceSecond() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.isBlackjack("king", "ace")).isEqualTo(true);
    }

    @Test
    public void firstTurnWithAceAceAndDealerAce() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("ace", "ace", "ace")).isEqualTo("P");
    }

    @Test
    public void firstTurnWithTwoNineAndDealerQueen() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("two", "nine", "queen")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithKingSevenAndDealerAce() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("king", "seven", "ace")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithTwoTenAndDealerQueen() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("two", "ten", "queen")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithTwoTenAndDealerSeven() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("two", "ten", "seven")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithKingTenAndDealerAce() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("king", "ten", "ace")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithFourTenAndDealerQueen() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("four", "ten", "queen")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithFourTenAndDealerSeven() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("four", "ten", "seven")).isEqualTo("H");
    }

    @Test
    public void correctParsesEight() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.parseCard("eight")).isEqualTo(8);
    }

    @Test
    public void correctParsesQueen() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.parseCard("queen")).isEqualTo(10);
    }

    @Test
    public void correctParsesSeven() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.parseCard("seven")).isEqualTo(7);
    }

    @Test
    public void correctParsesThree() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.parseCard("three")).isEqualTo(3);
    }

    @Test
    public void firstTurnWithJackJackAndDealerAce() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("jack", "jack", "ace")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithFiveTenAndDealerKing() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("five", "ten", "king")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithEightTenAndDealerAce() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("eight", "ten", "ace")).isEqualTo("S");
    }

    @Test
    public void blackjackWithJackAceSecond() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.isBlackjack("jack", "ace")).isEqualTo(true);
    }

    @Test
    public void firstTurnWithSixTenAndDealerAce() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("six", "ten", "ace")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithSixTenAndDealerSix() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("six", "ten", "six")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithThreeTenAndDealerSix() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("three", "ten", "six")).isEqualTo("S");
    }

    @Test
    public void noBlackjackWithTwoFigures() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.isBlackjack("queen", "jack")).isEqualTo(false);
    }

    @Test
    public void firstTurnWithTwoTwoAndDealerAce() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("two", "two", "ace")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithAceKingAndDealerQueen() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("ace", "king", "queen")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithTwoEightAndDealerTwo() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("two", "eight", "two")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithKingKingAndDealerAce() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("king", "king", "ace")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithJackAceAndDealerAce() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("jack", "ace", "ace")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithFiveFiveAndAce() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("five", "five", "ace")).isEqualTo("H");
    }

    @Test
    public void noBlackjackWithKingAndFive() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.isBlackjack("king", "five")).isEqualTo(false);
    }

    @Test
    public void firstTurnWithTwoTenAndDealerSix() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("two", "ten", "six")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithFiveTenAndDealerSeven() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("five", "ten", "seven")).isEqualTo("H");
    }

    @Test
    public void blackjackWithTenAceSecond() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.isBlackjack("ten", "ace")).isEqualTo(true);
    }

    @Test
    public void firstTurnWithTwoTwoAndDealerFive() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("two", "two", "five")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithFourTenAndDealerSix() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("four", "ten", "six")).isEqualTo("S");
    }

    @Test
    public void noBlackjackWithTwoAces() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.isBlackjack("ace", "ace")).isEqualTo(false);
    }

    @Test
    public void correctParsesAce() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.parseCard("ace")).isEqualTo(11);
    }

    @Test
    public void correctParsesSix() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.parseCard("six")).isEqualTo(6);
    }

    @Test
    public void correctParsesTen() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.parseCard("ten")).isEqualTo(10);
    }

    @Test
    public void correctParsesTwo() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.parseCard("two")).isEqualTo(2);
    }

    @Test
    public void firstTurnWithNineTenAndDealerAce() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("nine", "ten", "ace")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithKingAceAndDealerNine() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("king", "ace", "nine")).isEqualTo("W");
    }

    @Test
    public void blackjackWithQueenAceSecond() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.isBlackjack("queen", "ace")).isEqualTo(true);
    }

    @Test
    public void correctParsesFive() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.parseCard("five")).isEqualTo(5);
    }

    @Test
    public void correctParsesFour() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.parseCard("four")).isEqualTo(4);
    }

    @Test
    public void correctParsesJack() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.parseCard("jack")).isEqualTo(10);
    }

    @Test
    public void noBlackjackWithNine() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.isBlackjack("ace", "nine")).isEqualTo(false);
    }

    @Test
    public void noBlackjackWithFive() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.isBlackjack("ace", "five")).isEqualTo(false);
    }

    @Test
    public void firstTurnWithThreeTenAndDealerSeven() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("three", "ten", "seven")).isEqualTo("H");
    }

    @Test
    public void noBlackjackWithEightAndFive() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.isBlackjack("eight", "five")).isEqualTo(false);
    }

    @Test
    public void firstTurnWithTwoThreeAndDealerQueen() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("two", "three", "queen")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithThreeTenAndDealerQueen() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("three", "ten", "queen")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithFiveTenAndDealerSix() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("five", "ten", "six")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithTenAceAndDealerFive() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("ten", "ace", "five")).isEqualTo("W");
    }

    @Test
    public void firstTurnWithSixTenAndDealerSeven() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.firstTurn("six", "ten", "seven")).isEqualTo("H");
    }

    @Test
    public void correctParsesNine() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.parseCard("nine")).isEqualTo(9);
    }

    @Test
    public void correctParsesKing() {
        BlackJack blackjack = new BlackJack();
        assertThat(blackjack.parseCard("king")).isEqualTo(10);
    }
}