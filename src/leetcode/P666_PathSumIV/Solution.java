package leetcode.P666_PathSumIV;

import java.util.HashMap;
import java.util.Map;

class Solution {
    int totalSum = 0;
    Map<Integer, Integer> tree = new HashMap<>();

    public int pathSum(int[] nums) {
        for (int n : nums) {
            tree.put(n / 10, n % 10);
        }

        dfs(11, 0);
        return totalSum;
    }

    private void dfs(int pos, int currentSum) {
        if (!tree.containsKey(pos))
            return;

        int val = tree.get(pos);
        currentSum += val;

        int depth = pos / 10;
        int p = pos % 10;

        int left = (depth + 1) * 10 + (2 * p - 1);
        int right = (depth + 1) * 10 + (2 * p);

        // If it's a leaf node, add to totalSum
        // Nếu là nút lá, thêm vào totalSum
        if (!tree.containsKey(left) && !tree.containsKey(right)) {
            totalSum += currentSum;
        } else {
            dfs(left, currentSum);
            dfs(right, currentSum);
        }
    }
}
