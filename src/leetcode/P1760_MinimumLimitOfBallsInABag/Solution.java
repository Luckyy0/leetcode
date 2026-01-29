package leetcode.P1760_MinimumLimitOfBallsInABag;

public class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = 0;
        for (int num : nums)
            high = Math.max(high, num);
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(nums, mid, maxOperations)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(int[] nums, int limit, int maxOps) {
        int ops = 0;
        for (int num : nums) {
            if (num > limit) {
                // Number of splits needed to bring num <= limit.
                // e.g. num=10, limit=3. 3,3,3,1 -> 3 splits.
                // Formula: (num - 1) / limit
                ops += (num - 1) / limit;
            }
            if (ops > maxOps)
                return false;
        }
        return true;
    }
}
