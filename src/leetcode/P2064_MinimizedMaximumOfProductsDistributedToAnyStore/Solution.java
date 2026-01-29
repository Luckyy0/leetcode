package leetcode.P2064_MinimizedMaximumOfProductsDistributedToAnyStore;

public class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = 100000; // max quantity constraint
        // Wait, max quantity could be 10^5. Range correct.

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canDistribute(n, quantities, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canDistribute(int n, int[] quantities, int maxLoad) {
        if (maxLoad == 0)
            return false;
        int storesNeeded = 0;
        for (int q : quantities) {
            storesNeeded += (q + maxLoad - 1) / maxLoad; // ceil(q / max)
            if (storesNeeded > n)
                return false;
        }
        return storesNeeded <= n;
    }
}
