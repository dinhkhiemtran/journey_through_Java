package main.structure.zipper;

public class BinaryTree {

    private Zipper root;

    public BinaryTree(Zipper root) {
        this.root = root;
    }

    public BinaryTree(int value) {
        root = new Zipper(value);
    }

    public Zipper getRoot() {
        return root;
    }

    @Override
    public boolean equals(Object obj) {
        BinaryTree other = (BinaryTree) obj;
        return root.equals(other.root);
    }

    public String printTree() {
        return print(root);
    }

    String print(Zipper zipper) {
        if (zipper == null) {
            return "null";
        }
        return String.format("value: %d, left: %s, right: %s", zipper.getValue(), wrap(print(zipper.left)),
                wrap(print(zipper.right)));
    }

    String wrap(String s) {
        return s == "null" ? s : ("{ " + s + " }");
    }
}
