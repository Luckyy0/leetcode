package leetcode.P1522_DiameterOfNAryTree;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution {
    int maxDiameter = 0;

    public int diameter(Node root) {
        dfs(root);
        return maxDiameter;
    }

    private int dfs(Node node) {
        if (node == null)
            return 0;

        int max1 = 0;
        int max2 = 0;

        for (Node child : node.children) {
            int len = dfs(child);
            if (len > max1) {
                max2 = max1;
                max1 = len;
            } else if (len > max2) {
                max2 = len;
            }
        }

        maxDiameter = Math.max(maxDiameter, max1 + max2);
        return max1 + 1;
    }
}
