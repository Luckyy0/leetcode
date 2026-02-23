package leet_code.Problem_589_Easy_N_ary_Tree_Preorder_Traversal;

import java.util.*;

/**
 * Definition for an n-ary tree node.
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class Solution_Iterative {

    /**
     * N-ary tree preorder traversal using a Stack.
     * Strategy: Push children in reverse order.
     * Time: O(N), Space: O(H).
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            result.add(curr.val);

            // Push children in reverse order so the leftmost is processed first
            if (curr.children != null) {
                for (int i = curr.children.size() - 1; i >= 0; i--) {
                    stack.push(curr.children.get(i));
                }
            }
        }

        return result;
    }
}

class Solution_Recursive {
    /**
     * N-ary tree preorder traversal using Recursion.
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(Node node, List<Integer> result) {
        if (node == null)
            return;
        result.add(node.val);
        for (Node child : node.children) {
            traverse(child, result);
        }
    }
}
