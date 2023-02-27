package main.structure.zipper;

import java.util.Objects;

public class Zipper {

    private int val;

    public Zipper right;

    public Zipper left;

    public Zipper up;

    public Zipper(int val) {
        this.val = val;
    }

    public BinaryTree toTree() {
        Zipper root = this;
        while (Objects.nonNull(root.getUp())) {
            root = root.getUp();
        }
        return new BinaryTree(root);
    }

    public Zipper getLeft() {
        return left;
    }

    public Zipper getRight() {
        return right;
    }

    public Zipper getUp() {
        return up;
    }

    public void setLeft(Zipper left) {
        if (Objects.nonNull(left)) {
            left.setUp(this);
        }
        this.left = left;
    }

    public void setRight(Zipper right) {
        if (Objects.nonNull(right)) {
            right.setUp(this);
        }
        this.right = right;
    }

    public void setUp(Zipper up) {
        this.up = up;
    }

    public int getValue() {
        return this.val;
    }

    public void setValue(int value) {
        this.val = value;
    }
}

