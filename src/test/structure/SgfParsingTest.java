package test.structure;

import main.structure.sgf_parsing.SgfNode;
import main.structure.sgf_parsing.SgfParsing;
import main.structure.sgf_parsing.SgfParsingException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SgfParsingTest {
    @Test
    public void emptyInput() {
        String input = "";
        assertThrows(
                SgfParsingException.class,
                () -> new SgfParsing().parse(input));
    }

    @Test
    public void treeWithNoNodes() {
        String input = "()";
        assertThrows(
                SgfParsingException.class,
                () -> new SgfParsing().parse(input));
    }

    @Test
    public void nodeWithoutTree() {
        String input = ";";
        assertThrows(
                SgfParsingException.class,
                () -> new SgfParsing().parse(input));
    }

    @Test
    public void nodeWithoutProperties() throws SgfParsingException {
        String input = "(;)";
        SgfNode expected = new SgfNode();
        SgfNode actual = new SgfParsing().parse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void singleNodeTree() throws SgfParsingException {
        String input = "(;A[B])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("B")));
        SgfNode actual = new SgfParsing().parse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void multipleProperties() throws SgfParsingException {
        String input = "(;A[b]C[d])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("b"),
                "C", List.of("d")));
        SgfNode actual = new SgfParsing().parse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void propertiesWithoutDelimiter()  {
        String input = "(;A)";
        assertThrows(
                SgfParsingException.class,
                () -> new SgfParsing().parse(input));
    }

    @Test
    public void allLowercaseProperty() {
        String input = "(;a[b])";
        assertThrows(
                SgfParsingException.class,
                () -> new SgfParsing().parse(input));
    }

    @Test
    public void upperAndLowercaseProperty() {
        String input = "(;Aa[b])";
        assertThrows(
                SgfParsingException.class,
                () -> new SgfParsing().parse(input));
    }

    @Test
    public void twoNodes() throws SgfParsingException {
        String input = "(;A[B];B[C])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("B")),
                List.of(
                        new SgfNode(Map.of("B", List.of("C")))
                ));
        SgfNode actual = new SgfParsing().parse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void twoChildTrees() throws SgfParsingException {
        String input = "(;A[B](;B[C])(;C[D]))";
        SgfNode expected = new SgfNode(Map.of("A", List.of("B")),
                List.of(
                        new SgfNode(Map.of("B", List.of("C"))),
                        new SgfNode(Map.of("C", List.of("D")))
                ));
        SgfNode actual = new SgfParsing().parse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void multiplePropertyValues() throws SgfParsingException {
        String input = "(;A[b][c][d])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("b", "c", "d")));
        SgfNode actual = new SgfParsing().parse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void escapedProperty() throws SgfParsingException {
        String input = "(;A[\\]b\nc\nd\t\te \n\\]])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("]b\nc\nd\t\te \n]")));
        SgfNode actual = new SgfParsing().parse(input);
        assertEquals(expected, actual);
    }
}