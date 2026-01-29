package leetcode.P1650_LowestCommonAncestorOfABinaryTreeIII;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};

public class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p;
        Node b = q;

        while (a != b) {
            a = (a.parent == null) ? q : a.parent;
            b = (b.parent == null) ? p : b.parent;
        }

        return a;
    }
}
