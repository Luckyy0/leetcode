package leetcode.P1712_WaysToSplitArrayIntoThreeSubarrays;

public class Solution {
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int[] p = new int[n];
        p[0] = nums[0];
        for (int i = 1; i < n; i++)
            p[i] = p[i - 1] + nums[i];

        long count = 0;
        int MOD = 1_000_000_007;

        for (int i = 0; i < n - 2; i++) {
            // Need j such that:
            // 1. j > i
            // 2. j < n - 1
            // 3. P[j] >= 2 * P[i]
            // 4. P[j] <= (P[n-1] + P[i]) / 2

            int leftVal = p[i];
            int lower = 2 * leftVal;
            int upper = (p[n - 1] + leftVal) / 2;

            // Find first j > i s.t. P[j] >= lower
            int l = findLower(p, i + 1, n - 2, lower);

            // Find last j < n - 1 s.t. P[j] <= upper
            int r = findUpper(p, i + 1, n - 2, upper);

            if (l != -1 && r != -1 && l <= r) {
                count = (count + (r - l + 1)) % MOD;
            }
        }

        return (int) count;
    }

    private int findLower(int[] p, int start, int end, int val) {
        int ans = -1;
        int l = start, r = end;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (p[mid] >= val) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private int findUpper(int[] p, int start, int end, int val) {
        int ans = -1;
        int l = start, r = end;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (p[mid] <= val) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
