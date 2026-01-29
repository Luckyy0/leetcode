package leetcode.P1612_CheckIfTwoExpressionTreesAreEquivalent;

class Node {
    char val;
    Node left;
    Node right;

    Node() {
        this.val = ' ';
    }

    Node(char val) {
        this.val = val;
    }

    Node(char val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public boolean checkEquivalence(Node root1, Node root2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        dfs(root1, count1);
        dfs(root2, count2);

        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }

    private void dfs(Node node, int[] count) {
        if (node == null)
            return;

        if (node.val != '+') {
            count[node.val - 'a']++;
        }

        dfs(node.left, count);
        dfs(node.right, count);
    }
}
