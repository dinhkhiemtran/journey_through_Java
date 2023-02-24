package main.structure.tree;

import java.util.ArrayList;

public class TreeNode {
    private int nodeId;

    private ArrayList<TreeNode> children;

    TreeNode(int nodeId) {
        this.nodeId = nodeId;
        this.children = new ArrayList<>();
    }

    public int getNodeId() {
        return nodeId;
    }

    public ArrayList<TreeNode> getChildren() {
        return children;
    }
}
