package leet_code.Problem_590_Easy_N_ary_Tree_Postorder_Traversal;

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
     * N-ary tree postorder traversal using Mirror-and-Reverse logic.
     * Strategy: (Root, Right-to-Left) then Reverse.
     * Time: O(N), Space: O(H).
     */
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null)
            return result;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            // addFirst effectively reverses the list while building it
            result.addFirst(curr.val);

            // Push children in normal order (left to right)
            if (curr.children != null) {
                for (Node child : curr.children) {
                    stack.push(child);
                }
            }
        }

        return result;
    }
}

class Solution_Recursive {
    /**
     * N-ary tree postorder traversal using Recursion.
     */
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(Node node, List<Integer> result) {
        if (node == null)
            return;
        // Visit children first
        for (Node child : node.children) {
            traverse(child, result);
        }
        // Then visit root
        result.add(node.val);
    }
}
