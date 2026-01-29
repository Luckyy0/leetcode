package leetcode.P1586_BinarySearchTreeIteratorII;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BSTIterator {
    private List<Integer> visited;
    private int pointer;
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.visited = new ArrayList<>();
        this.pointer = -1;
        this.stack = new Stack<>();
        pushLeft(root);
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public boolean hasNext() {
        return pointer < visited.size() - 1 || !stack.isEmpty();
    }

    public int next() {
        pointer++;
        // If pointer is within the already visited history
        if (pointer < visited.size()) {
            return visited.get(pointer);
        }

        // Otherwise, fetch next from stack
        TreeNode node = stack.pop();
        pushLeft(node.right);
        visited.add(node.val);
        return node.val;
    }

    public boolean hasPrev() {
        return pointer > 0;
    }

    public int prev() {
        pointer--;
        return visited.get(pointer);
    }
}
