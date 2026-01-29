package leetcode.P1145_BinaryTreeColoringGame;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int leftSize = 0;
    int rightSize = 0;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        count(root, x);
        int parentSize = n - (leftSize + rightSize + 1);
        int maxPart = Math.max(parentSize, Math.max(leftSize, rightSize));
        return maxPart > n / 2;
    }

    private int count(TreeNode node, int x) {
        if (node == null)
            return 0;

        int l = count(node.left, x);
        int r = count(node.right, x);

        if (node.val == x) {
            leftSize = l;
            rightSize = r;
        }

        return l + r + 1;
    }
}
