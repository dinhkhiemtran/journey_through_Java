package test.lists;

import main.lists.ListOps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ListOpsTest {
    @Test
    public void testAppendingEmptyLists() {
        assertThat(ListOps.append(Collections.emptyList(), Collections.emptyList())).isEmpty();
        System.out.println(ListOps.append(Collections.emptyList(), Collections.emptyList()));
    }

    @Test
    public void testAppendingListToEmptyList() {
        assertThat(ListOps.append(Collections.emptyList(), Arrays.asList('1', '2', '3', '4')))
                .containsExactly('1', '2', '3', '4');
        System.out.println(ListOps.append(Collections.emptyList(), Arrays.asList('1', '2', '3', '4')));
    }

    @Test
    public void testAppendingNonEmptyLists() {
        assertThat(ListOps.append(Arrays.asList("1", "2"), Arrays.asList("2", "3", "4", "5")))
                .containsExactly("1", "2", "2", "3", "4", "5");
        System.out.println(ListOps.append(Arrays.asList("1", "2"), Arrays.asList("2", "3", "4", "5")));
    }

    @Test
    public void testConcatEmptyList() {
        assertThat(ListOps.concat(Collections.emptyList())).isEmpty();
    }

    @Test
    public void testConcatListOfLists() {
        List<List<Character>> listOfLists = Arrays.asList(
                Arrays.asList('1', '2'),
                Collections.singletonList('3'),
                Collections.emptyList(),
                Arrays.asList('4', '5', '6')
        );
        assertThat(ListOps.concat(listOfLists)).containsExactly('1', '2', '3', '4', '5', '6');
    }

    @Test
    public void testConcatListOfNestedLists() {
        List<List<List<Character>>> listOfNestedLists = Arrays.asList(
                Arrays.asList(
                        Collections.singletonList('1'),
                        Collections.singletonList('2')
                ),
                Collections.singletonList(
                        Collections.singletonList('3')
                ),
                Collections.singletonList(
                        Collections.emptyList()
                ),
                Collections.singletonList(
                        Arrays.asList('4', '5', '6')
                )
        );
        assertThat(ListOps.concat(listOfNestedLists))
                .containsExactly(
                        Collections.singletonList('1'),
                        Collections.singletonList('2'),
                        Collections.singletonList('3'),
                        Collections.emptyList(),
                        Arrays.asList('4', '5', '6'));
    }

    @Test
    public void testFilteringEmptyList() {
        assertThat(ListOps.filter(Collections.<Integer>emptyList(), integer -> integer % 2 == 1))
                .isEmpty();
    }

    @Test
    public void testFilteringNonEmptyList() {
        assertThat(ListOps.filter(Arrays.asList(1, 2, 3, 5), integer -> integer % 2 == 1))
                .containsExactly(1, 3, 5);
    }

    @Test
    public void testSizeOfEmptyList() {
        assertThat(ListOps.size(Collections.emptyList())).isEqualTo(0);
    }

    @Test
    public void testSizeOfNonEmptyList() {
        assertThat(ListOps.size(Arrays.asList("one", "two", "three", "four"))).isEqualTo(4);
    }

    @Test
    public void testTransformingEmptyList() {
        assertThat(ListOps.map(Collections.<Integer>emptyList(), integer -> integer + 1)).isEmpty();
    }

    @Test
    public void testTransformingNonEmptyList() {
        assertThat(ListOps.map(Arrays.asList(1, 3, 5, 7), integer -> integer + 1))
                .containsExactly(2, 4, 6, 8);
    }

    @Test
    public void testFoldLeftEmptyList() {
        assertThat(
                ListOps.foldLeft(
                        Collections.<Double>emptyList(),
                        2.0,
                        (x, y) -> x * y))
                .isEqualTo(2.0);
    }

    @Test
    public void testFoldLeftDirectionIndependentFunctionAppliedToNonEmptyList() {
        assertThat(
                ListOps.foldLeft(
                        Arrays.asList(1, 2, 3, 4),
                        5,
                        (x, y) -> x + y))
                .isEqualTo(15);
    }

    @Test
    public void testFoldLeftDirectionDependentFunctionAppliedToNonEmptyList() {
        assertThat(
                ListOps.foldLeft(
                        Arrays.asList(2, 5),
                        5,
                        (x, y) -> x / y))
                .isEqualTo(0);
    }

    @Test
    public void testFoldRightEmptyList() {
        assertThat(
                ListOps.foldRight(
                        Collections.<Double>emptyList(),
                        2.0,
                        (x, y) -> x * y))
                .isEqualTo(2.0);
    }

    @Test
    public void testFoldRightDirectionIndependentFunctionAppliedToNonEmptyList() {
        assertThat(
                ListOps.foldRight(
                        Arrays.asList(1, 2, 3, 4),
                        5,
                        (x, y) -> x + y))
                .isEqualTo(15);
    }

    @Test
    public void testFoldRightDirectionDependentFunctionAppliedToNonEmptyList() {
        assertThat(
                ListOps.foldRight(
                        Arrays.asList(2, 5),
                        5,
                        (x, y) -> x / y))
                .isEqualTo(2);
    }

    @Test
    public void testReversingEmptyList() {
        assertThat(ListOps.reverse(Collections.emptyList())).isEmpty();
    }

    @Test
    public void testReversingNonEmptyList() {
        assertThat(ListOps.reverse(Arrays.asList('1', '3', '5', '7')))
                .containsExactly('7', '5', '3', '1');
        System.out.println(ListOps.reverse(ListOps.reverse(Arrays.asList('1', '3', '5', '7'))));
    }

    @Test
    public void testReversingListOfListIsNotFlattened() {
        List<List<Character>> listOfLists = Arrays.asList(
                Arrays.asList('1', '2'),
                Collections.singletonList('3'),
                Collections.emptyList(),
                Arrays.asList('4', '5', '6')
        );
        assertThat(ListOps.reverse(listOfLists))
                .containsExactly(
                        Arrays.asList('4', '5', '6'),
                        Collections.emptyList(),
                        Collections.singletonList('3'),
                        Arrays.asList('1', '2'));
    }
}