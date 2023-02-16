package test.classes;

import main.classes.dominoes.ChainNotFoundException;
import main.classes.dominoes.Domino;
import main.classes.dominoes.Dominoes;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DominoesTest {
    @Test
    public void emtpyInputEmptyOutputTest() throws ChainNotFoundException {
        Dominoes dominoes = new Dominoes();
        List<Domino> dominoesList = new ArrayList<>();
        List<Domino> chain = dominoes.formChain(dominoesList);
        assertEquals(0, chain.size());
    }

    @Test
    public void singletonInputSingletonOutput() throws ChainNotFoundException {
        Dominoes dominoes = new Dominoes();
        Domino[] dominoesArray = {new Domino(1, 1)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);
        List<Domino> chain = dominoes.formChain(dominoesList);
        assertValidChain(dominoesList, chain);
    }

    @Test
    public void singletonCantBeChainedTest() {
        Dominoes dominoes = new Dominoes();
        Domino[] dominoesArray = {new Domino(1, 2)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);
        assertThatExceptionOfType(ChainNotFoundException.class)
                .isThrownBy(() -> dominoes.formChain(dominoesList))
                .withMessage("No domino chain found.");
    }

    @Test
    public void threeElementsTest() throws ChainNotFoundException {
        Dominoes dominoes = new Dominoes();
        Domino[] dominoesArray = {new Domino(1, 2), new Domino(3, 1), new Domino(2, 3)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);
        List<Domino> chain = dominoes.formChain(dominoesList);
        assertValidChain(dominoesList, chain);
    }

    @Test
    public void canReverseDominoesTest() throws ChainNotFoundException {
        Dominoes dominoes = new Dominoes();
        Domino[] dominoesArray = {new Domino(1, 2), new Domino(1, 3), new Domino(2, 3)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);
        List<Domino> chain = dominoes.formChain(dominoesList);
        assertValidChain(dominoesList, chain);
    }

    @Test
    public void cantBeChainedTest() {
        Dominoes dominoes = new Dominoes();
        Domino[] dominoesArray = {new Domino(1, 2), new Domino(4, 1), new Domino(2, 3)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);
        assertThatExceptionOfType(ChainNotFoundException.class)
                .isThrownBy(() -> dominoes.formChain(dominoesList))
                .withMessage("No domino chain found.");
    }

    @Test
    public void disconnectedSimpleTest() {
        Dominoes dominoes = new Dominoes();
        Domino[] dominoesArray = {new Domino(1, 1), new Domino(2, 2)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);
        assertThatExceptionOfType(ChainNotFoundException.class)
                .isThrownBy(() -> dominoes.formChain(dominoesList))
                .withMessage("No domino chain found.");
    }

    @Test
    public void disconnectedDoubleLoopTest() {
        Dominoes dominoes = new Dominoes();
        Domino[] dominoesArray = {new Domino(1, 2), new Domino(2, 1), new Domino(3, 4), new Domino(4, 3)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);
        assertThatExceptionOfType(ChainNotFoundException.class)
                .isThrownBy(() -> dominoes.formChain(dominoesList))
                .withMessage("No domino chain found.");
    }

    @Test
    public void disconnectedSingleIsolatedTest() {
        Dominoes dominoes = new Dominoes();
        Domino[] dominoesArray = {new Domino(1, 2), new Domino(2, 3), new Domino(3, 1), new Domino(4, 4)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);
        assertThatExceptionOfType(ChainNotFoundException.class)
                .isThrownBy(() -> dominoes.formChain(dominoesList))
                .withMessage("No domino chain found.");
    }

    @Test
    public void needBacktrackTest() throws ChainNotFoundException {
        Dominoes dominoes = new Dominoes();
        Domino[] dominoesArray = {new Domino(1, 2), new Domino(2, 3), new Domino(3, 1), new Domino(2, 4),
                new Domino(4, 2)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);
        List<Domino> chain = dominoes.formChain(dominoesList);
        assertValidChain(dominoesList, chain);
    }

    @Test
    public void separateLoopsTest() throws ChainNotFoundException {
        Dominoes dominoes = new Dominoes();
        Domino[] dominoesArray = {new Domino(1, 2), new Domino(2, 3), new Domino(3, 1),
                new Domino(1, 1), new Domino(2, 2), new Domino(3, 3)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);
        List<Domino> chain = dominoes.formChain(dominoesList);
        assertValidChain(dominoesList, chain);
    }

    @Test
    public void nineElementsTest() throws ChainNotFoundException {
        Dominoes dominoes = new Dominoes();
        Domino[] dominoesArray = {new Domino(1, 2), new Domino(5, 3), new Domino(3, 1),
                new Domino(1, 2), new Domino(2, 4), new Domino(1, 6),
                new Domino(2, 3), new Domino(3, 4), new Domino(5, 6)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);
        List<Domino> chain = dominoes.formChain(dominoesList);
        assertValidChain(dominoesList, chain);
    }

    @Test
    private void assertValidChain(List<Domino> inputDominoes, List<Domino> outputDominoes) {
        assertSameDominoes(inputDominoes, outputDominoes);
        assertEndDominoesMatch(outputDominoes);
        assertConsecutiveDominoes(outputDominoes);
    }
    @Test
    private void assertEndDominoesMatch(List<Domino> outputDominoes) {
        int leftValueOfFirstDomino = outputDominoes.get(0).getLeft();
        int rightValueOfLastDomino = outputDominoes.get(outputDominoes.size() - 1).getRight();
        assertEquals(leftValueOfFirstDomino, rightValueOfLastDomino);
    }

    @Test
    private void assertSameDominoes(List<Domino> inputDominoes, List<Domino> outputDominoes) {
        assertEquals(inputDominoes.size(), outputDominoes.size());
        for (Domino domino : inputDominoes) {
            int inputFrequency = Collections.frequency(inputDominoes, domino);
            int outputFrequency = Collections.frequency(outputDominoes, domino);
            assertEquals(inputFrequency, outputFrequency);
        }
    }

    private void assertConsecutiveDominoes(List<Domino> dominoes) {
        for (int i = 0; i < dominoes.size() - 1; i++) {
            assertEquals(dominoes.get(i).getRight(), dominoes.get(i + 1).getLeft());
        }
    }
}