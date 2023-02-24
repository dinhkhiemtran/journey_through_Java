package main.structure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node root = null;

    public void insert(T value) {
        root = put(root, value);
    }

    private Node put(Node pos, T value) {
        if (pos == null) return new Node(value);
        int cmp = value.compareTo((T) pos.getData());
        if (cmp > 0) pos.right = put(pos.right, value);
        else if (cmp <= 0) pos.left = put(pos.left, value);
        return pos;
    }

    public List<T> getAsSortedList() {
        return get(root);
    }

    private List<T> get(Node pos) {
        if (pos == null) return new ArrayList<>();
        List<T> res = get(pos.getLeft());
        res.add((T) pos.getData());
        res.addAll(get(pos.getRight()));
        return res;
    }

    public <T> List<T> getAsLevelOrderList() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        List<T> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node pos = queue.poll();
            res.add((T) pos.getData());
            if (pos.getLeft() != null) queue.offer(pos.getLeft());
            if (pos.getRight() != null) queue.offer(pos.getRight());
        }
        return res;
    }

    public <T> Node<T> getRoot() {
        return this.root;
    }

    public static class Node<T> {

        private Node left = null;

        private Node right = null;

        private T data;

        public Node(T value) {
            this.data = value;
        }

        public Node<T> getLeft() {
            return this.left;
        }

        public Node<T> getRight() {
            return this.right;
        }

        public T getData() {
            return this.data;
        }
    }
}
