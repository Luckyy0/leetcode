package leet_code.Problem_508_Medium_Most_Frequent_Subtree_Sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Definition for a binary tree node.
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

public class Solution_DFS {

    private Map<Integer, Integer> countMap;
    private int maxFreq;

    /**
     * Finds most frequent subtree sum.
     * Strategy: Post-order DFS.
     * Time: O(N), Space: O(N).
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        countMap = new HashMap<>();
        maxFreq = 0;

        getSum(root);

        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                resultList.add(entry.getKey());
            }
        }

        int[] res = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            res[i] = resultList.get(i);
        }
        return res;
    }

    private int getSum(TreeNode node) {
        if (node == null)
            return 0;

        int leftSum = getSum(node.left);
        int rightSum = getSum(node.right);

        int currentSum = node.val + leftSum + rightSum;

        int freq = countMap.getOrDefault(currentSum, 0) + 1;
        countMap.put(currentSum, freq);

        maxFreq = Math.max(maxFreq, freq);

        return currentSum;
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);

        int[] res = solution.findFrequentTreeSum(root);
        System.out.print("Result: ");
        for (int val : res) {
            System.out.print(val + " "); // 2 -3 4 (order varies)
        }
    }
}
