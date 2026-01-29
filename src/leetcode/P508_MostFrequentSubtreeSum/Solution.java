package leetcode.P508_MostFrequentSubtreeSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    private Map<Integer, Integer> map = new HashMap<>();
    private int maxFreq = 0;

    /**
     * Problem 508: Most Frequent Subtree Sum
     * Approach: Bottom-up Post-order traversal
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        getSum(root);

        List<Integer> res = new ArrayList<>();
        for (int sum : map.keySet()) {
            if (map.get(sum) == maxFreq) {
                res.add(sum);
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            result[i] = res.get(i);
        return result;
    }

    private int getSum(TreeNode node) {
        if (node == null)
            return 0;

        int left = getSum(node.left);
        int right = getSum(node.right);
        int sum = node.val + left + right;

        int freq = map.getOrDefault(sum, 0) + 1;
        map.put(sum, freq);
        maxFreq = Math.max(maxFreq, freq);

        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [5,2,-3]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);

        int[] res = sol.findFrequentTreeSum(root); // Subtree sums: 2, -3, 4. Each freq 1.
        System.out.println("Result: " + java.util.Arrays.toString(res));
    }
}
