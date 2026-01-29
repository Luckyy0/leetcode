package leetcode.P1891_CuttingRibbons;

public class Solution {
    public int maxLength(int[] ribbons, int k) {
        long sum = 0;
        int max = 0;
        for (int r : ribbons) {
            sum += r;
            max = Math.max(max, r);
        }

        if (sum < k)
            return 0;

        int low = 1, high = max;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canCut(ribbons, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canCut(int[] ribbons, int k, int len) {
        int count = 0;
        for (int r : ribbons) {
            count += r / len;
            if (count >= k)
                return true;
        }
        return false;
    }
}
