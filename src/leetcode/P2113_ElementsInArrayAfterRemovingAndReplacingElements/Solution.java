package leetcode.P2113_ElementsInArrayAfterRemovingAndReplacingElements;

public class Solution {
    public int[] elementInNums(int[] nums, int[][] queries) {
        int n = nums.length;
        int period = 2 * n;
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int time = queries[i][0];
            int index = queries[i][1];

            int t = time % period;

            if (t < n) {
                // Shrinking phase
                // Start index increases by t
                // Size is n - t
                if (index < n - t) {
                    res[i] = nums[t + index];
                } else {
                    res[i] = -1;
                }
            } else {
                // Growing phase
                // Start index is 0
                // Size is t - n
                // Elements are nums[0...size-1]
                if (index < t - n) {
                    res[i] = nums[index];
                } else {
                    res[i] = -1;
                }
            }
        }

        return res;
    }
}
