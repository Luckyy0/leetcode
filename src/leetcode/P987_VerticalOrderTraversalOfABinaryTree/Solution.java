package leetcode.P987_VerticalOrderTraversalOfABinaryTree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    class Node {
        int r, c, val;

        Node(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Node> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);
        Collections.sort(nodes, (a, b) -> {
            if (a.c != b.c)
                return a.c - b.c;
            if (a.r != b.r)
                return a.r - b.r;
            return a.val - b.val;
        });

        List<List<Integer>> res = new ArrayList<>();
        if (nodes.isEmpty())
            return res;

        int currC = nodes.get(0).c;
        List<Integer> currList = new ArrayList<>();
        for (Node n : nodes) {
            if (n.c != currC) {
                res.add(currList);
                currList = new ArrayList<>();
                currC = n.c;
            }
            currList.add(n.val);
        }
        res.add(currList);
        return res;
    }

    private void dfs(TreeNode node, int r, int c, List<Node> nodes) {
        if (node == null)
            return;
        nodes.add(new Node(r, c, node.val));
        dfs(node.left, r + 1, c - 1, nodes);
        dfs(node.right, r + 1, c + 1, nodes);
    }
}
