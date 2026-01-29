package leetcode.P2096_StepByStepDirectionsFromABinaryTreeNodeToAnother;

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

public class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();

        findPath(root, startValue, startPath);
        findPath(root, destValue, destPath);

        // Reverse because DFS appends in reverse (bottom-up)?
        // Or standard DFS pushing? Standard DFS pushes 'L' then recurses.
        // My DFS implementation below will need to be correct.
        // If backtracking: add 'L', recurse, remove 'L' if invalid.
        // So StringBuilder contains path from Root to Node. Correct order.

        int i = 0;
        int minLen = Math.min(startPath.length(), destPath.length());
        while (i < minLen && startPath.charAt(i) == destPath.charAt(i)) {
            i++;
        }

        // Construct result
        StringBuilder res = new StringBuilder();
        // Up moves for the rest of startPath
        for (int k = i; k < startPath.length(); k++) {
            res.append('U');
        }
        // Moves for the rest of destPath
        res.append(destPath.substring(i));

        return res.toString();
    }

    private boolean findPath(TreeNode root, int target, StringBuilder sb) {
        if (root == null)
            return false;
        if (root.val == target)
            return true;

        sb.append('L');
        if (findPath(root.left, target, sb))
            return true;
        sb.deleteCharAt(sb.length() - 1);

        sb.append('R');
        if (findPath(root.right, target, sb))
            return true;
        sb.deleteCharAt(sb.length() - 1);

        return false;
    }
}
