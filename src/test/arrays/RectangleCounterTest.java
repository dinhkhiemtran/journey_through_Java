package test.arrays;

import main.arrays.RectangleCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleCounterTest {

    private RectangleCounter rectangleCounter;

    @BeforeEach
    public void setUp() {
        rectangleCounter = new RectangleCounter();
    }

    @Test
    public void testInputWithNoRowsContainsNoRectangles() {
        String[] inputGrid = new String[]{};
        assertEquals(0, rectangleCounter.countRectangles(inputGrid));
    }

    @Test
    public void testInputWithNoColumnsContainsNoRectangles() {
        String[] inputGrid = new String[]{""};
        assertEquals(0, rectangleCounter.countRectangles(inputGrid));
    }

    @Test
    public void testNonTrivialInputWithNoRectangles() {
        String[] inputGrid = new String[]{" "};
        assertEquals(0, rectangleCounter.countRectangles(inputGrid));
    }

    @Test
    public void testInputWithOneRectangle() {
        String[] inputGrid = new String[]{
                "+-+",
                "| |",
                "+-+"
        };
        assertEquals(1, rectangleCounter.countRectangles(inputGrid));
    }

    @Test
    public void testInputWithTwoRectanglesWithoutSharedEdges() {
        String[] inputGrid = new String[]{
                "  +-+",
                "  | |",
                "+-+-+",
                "| |  ",
                "+-+  "
        };
        assertEquals(2, rectangleCounter.countRectangles(inputGrid));
    }

    @Test
    public void testInputWithFiveRectanglesWithSharedEdges() {
        String[] inputGrid = new String[]{
                "  +-+",
                "  | |",
                "+-+-+",
                "| | |",
                "+-+-+"
        };
        assertEquals(5, rectangleCounter.countRectangles(inputGrid));
    }

    @Test
    public void testThatRectangleOfHeightOneIsCounted() {
        String[] inputGrid = new String[]{
                "+--+",
                "+--+"
        };
        assertEquals(1, rectangleCounter.countRectangles(inputGrid));
    }

    @Test
    public void testThatRectangleOfWidthOneIsCounted() {
        String[] inputGrid = new String[]{
                "++",
                "||",
                "++"
        };
        assertEquals(1, rectangleCounter.countRectangles(inputGrid));
    }

    @Test
    public void testThatOneByOneSquareIsCounted() {
        String[] inputGrid = new String[]{
                "++",
                "++"
        };
        assertEquals(1, rectangleCounter.countRectangles(inputGrid));
    }

    @Test
    public void testThatIncompleteRectanglesAreNotCounted() {
        String[] inputGrid = new String[]{
                "  +-+",
                "    |",
                "+-+-+",
                "| | -",
                "+-+-+"
        };
        assertEquals(1, rectangleCounter.countRectangles(inputGrid));
    }

    @Test
    public void testThatRectanglesOfDifferentSizesAreAllCounted() {
        String[] inputGrid = new String[]{
                "+------+----+",
                "|      |    |",
                "+---+--+    |",
                "|   |       |",
                "+---+-------+"
        };
        assertEquals(3, rectangleCounter.countRectangles(inputGrid));
    }

    @Test
    public void testThatIntersectionsWithoutCornerCharacterDoNotCountAsRectangleCorners() {
        String[] inputGrid = new String[]{
                "+------+----+",
                "|      |    |",
                "+------+    |",
                "|   |       |",
                "+---+-------+"
        };
        assertEquals(2, rectangleCounter.countRectangles(inputGrid));
    }

    @Test
    public void testLargeInputWithManyRectangles() {
        String[] inputGrid = new String[]{
                "+---+--+----+",
                "|   +--+----+",
                "+---+--+    |",
                "|   +--+----+",
                "+---+--+--+-+",
                "+---+--+--+-+",
                "+------+  | |",
                "          +-+"
        };
        assertEquals(60, rectangleCounter.countRectangles(inputGrid));
    }
}