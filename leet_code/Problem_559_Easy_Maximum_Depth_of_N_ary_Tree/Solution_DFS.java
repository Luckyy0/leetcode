package leet_code.Problem_559_Easy_Maximum_Depth_of_N_ary_Tree;

import java.util.List;

// Definition for a Node.
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

public class Solution_DFS {

    /**
     * Calculates the maximum depth of an N-ary tree.
     * Strategy: Recursive DFS.
     * Time: O(N), Space: O(H).
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int maxChildDepth = 0;
        if (root.children != null) {
            for (Node child : root.children) {
                maxChildDepth = Math.max(maxChildDepth, maxDepth(child));
            }
        }

        return 1 + maxChildDepth;
    }
}
