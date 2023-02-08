package test.generics;

import main.generics.DoublyLinkedList;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DoublyLinkedListTest {

    @Test
    public void testPushPop() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        ((DoublyLinkedList<Integer>) list).push(10);
        ((DoublyLinkedList<Integer>) list).push(20);
        ((DoublyLinkedList<Integer>) list).push(30);
        assertThat(((DoublyLinkedList<Integer>) list).pop()).isEqualTo(30);
        assertThat(((DoublyLinkedList<Integer>) list).pop()).isEqualTo(20);
        assertThat(list.pop()).isEqualTo(10);
    }

    @Test
    public void testPushShift() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        ((DoublyLinkedList<String>) list).push("10");
        list.push("20");
        list.push("30");
        assertThat(((DoublyLinkedList<String>) list).shift()).isEqualTo("10");
        assertThat(list.shift()).isEqualTo("20");
        assertThat(list.shift()).isEqualTo("30");
    }


    @Test
    public void testUnshiftShift() {
        DoublyLinkedList<Character> list = new DoublyLinkedList<>();
        ((DoublyLinkedList<Character>) list).unshift('1');
        list.unshift('2');
        list.unshift('3');
        assertThat(list.shift()).isEqualTo('3');
        assertThat(list.shift()).isEqualTo('2');
        assertThat(list.shift()).isEqualTo('1');
    }

    @Test
    public void testUnshiftPop() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.unshift(10);
        list.unshift(20);
        list.unshift(30);
        assertThat(list.pop()).isEqualTo(10);
        assertThat(list.pop()).isEqualTo(20);
        assertThat(list.pop()).isEqualTo(30);
    }

    @Test
    public void testExample() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.push("ten");
        list.push("twenty");
        assertThat(list.pop()).isEqualTo("twenty");
        list.push("thirty");
        assertThat(list.shift()).isEqualTo("ten");
        list.unshift("forty");
        list.push("fifty");
        assertThat(list.shift()).isEqualTo("forty");
        assertThat(list.pop()).isEqualTo("fifty");
        assertThat(list.shift()).isEqualTo("thirty");
    }
}