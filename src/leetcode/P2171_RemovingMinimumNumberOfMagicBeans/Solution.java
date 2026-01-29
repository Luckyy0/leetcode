package leetcode.P2171_RemovingMinimumNumberOfMagicBeans;

import java.util.Arrays;

public class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long totalSum = 0;
        for (int b : beans)
            totalSum += b;

        long maxKept = 0;
        int n = beans.length;

        for (int i = 0; i < n; i++) {
            // Assume we keep bags >= beans[i], reducing them to beans[i]
            // Bags < beans[i] are emptied (contribute 0 to kept)
            // Number of such bags is (n - i)
            long kept = (long) beans[i] * (n - i);
            maxKept = Math.max(maxKept, kept);
        }

        return totalSum - maxKept;
    }
}
