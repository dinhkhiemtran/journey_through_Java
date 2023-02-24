package main.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleLinkedList<T> {

    Optional<Node<T>> firstMember = Optional.empty();

    public SimpleLinkedList(T[] values) {
        firstMember = Optional.of(new Node<T>(values[0]));
        if (firstMember.isPresent()) {
            Optional<Node<T>> previousMember = firstMember;
            Optional<Node<T>> nextMember;
            for (int i = 1; i < values.length; i++) {
                Optional<Node<T>> tempNode = Optional.of(new Node<T>(values[i]));
                nextMember = tempNode;
                previousMember.get().next = nextMember;
                previousMember = nextMember;
            }
        }
    }

    public SimpleLinkedList() {
        //nothing contained in here, the default firstMember is an optional empty anyways
    }
    /*
     * return the size (# of members) in the list
     */

    public int size() {
        int count = 0;
        if (!firstMember.isPresent()) {
            return count;
        } else {
            // count++;
            Optional<Node<T>> temp = Optional.of(firstMember.get());
            while (temp.isPresent()) {
                count++;
                temp = temp.get().getNext();
            }
        }
        return count;
    }
    /*
     * Pushes an element onto the list
     * Effectively adding a member to the start of the list
     */
    public void push(T t) {
        Optional<Node<T>> temp = Optional.of(new Node<T>(t, firstMember));
        firstMember = temp;
    }
    /*
     * Pops an element off of the list, returning it
     * Effectively Removes the first member of the list, reassigning the firstMember variable.
     */
    public <G> T pop() {
        Optional<Node<T>> temp1 = Optional.of(firstMember.get());
        firstMember = firstMember.get().next;
        return temp1.get().t;
    }
    /*
     * Reverses the list by first adding all elements to an arraylist, clearing the current linkedlist, and re-poppulating via push.
     */
    public void reverse() {
        T[] valueList = asArray((Class<T>) firstMember.get().t.getClass());
        //alternative to the above code, in the case that the casting causes issues.
        //		List<T valueList> = new ArrayList<T>();
//		Optional<Node<T>> temp = Optional.of(firstMember.get());
//		while(temp.isPresent()) {
//			valueList.add(temp.get().t);
//			temp = temp.get().next;
//		}
        while (firstMember.isPresent())
            pop();
        System.out.println(valueList);
        for (T t : valueList) {
            push(t);
        }
    }
    /*
     * Returns the current linkedlist in the form of an array.
     */
    public T[] asArray(Class<T> class1) {
        List<T> valueList = new ArrayList<T>();
        if (!firstMember.isPresent())
            return (T[]) valueList.toArray();
        Optional<Node<T>> temp = Optional.of(firstMember.get());
        while (temp.isPresent()) {
            valueList.add(temp.get().t);
            System.out.println(valueList);
            temp = temp.get().next;
        }
        return (T[]) valueList.toArray();
    }
    /*
     * Inner class: Node
     * This is used as a container for the linkedlist items, eachone holding a value (T) and a pointer to another Node<T> object.
     */
    protected class Node<T> {

        private Optional<Node<T>> next = Optional.empty();

        private T t;

        Node(T t) {
            this.t = t;
        }

        Node(T t, Optional<Node<T>> next) {
            this.t = t;
            this.next = next;
        }

        public Optional<Node<T>> getNext() {
            if (next != null)                //I don't see why this is necessary, but otherwise trying to use node.next.ispresent() returned a NPE
                return next;
            return Optional.empty();
        }

        public void setNext(Optional<Node<T>> next) {
            this.next = next;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }
}