package main.generics;

import java.util.LinkedList;
import java.util.List;

public class DoublyLinkedList<Object> {

    private List<Object> list = new LinkedList<>();

    public void push(Object value) {
        list.add(value);
    }

    public Object pop() {
        return list.remove(list.size() - 1);
    }

    public void unshift(Object value) {
        list.add(0, value);
    }

    public Object shift() {
        return list.remove(0);
    }

    private final class Element<T> {
        private final Object value;
        private Element<Object> prev;
        private Element<Object> next;

        Element(Object value, Element<Object> prev, Element<Object> next) {
            throw new UnsupportedOperationException("Please implement the Element constructor.");
        }
    }

}
