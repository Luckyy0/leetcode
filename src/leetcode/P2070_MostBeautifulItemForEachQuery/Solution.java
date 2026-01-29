package leetcode.P2070_MostBeautifulItemForEachQuery;

import java.util.Arrays;

public class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        int n = items.length;
        int[] prices = new int[n];
        int[] maxBeauty = new int[n];

        int currentMax = 0;
        for (int i = 0; i < n; i++) {
            prices[i] = items[i][0];
            currentMax = Math.max(currentMax, items[i][1]);
            maxBeauty[i] = currentMax;
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];

            // Binary search for price <= q
            int idx = floor(prices, q);
            if (idx == -1) {
                res[i] = 0;
            } else {
                res[i] = maxBeauty[idx];
            }
        }

        return res;
    }

    private int floor(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
