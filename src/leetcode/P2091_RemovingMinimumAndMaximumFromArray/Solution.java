package leetcode.P2091_RemovingMinimumAndMaximumFromArray;

public class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 1;

        int minIdx = 0, maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIdx])
                minIdx = i;
            if (nums[i] > nums[maxIdx])
                maxIdx = i;
        }

        int i = Math.min(minIdx, maxIdx);
        int j = Math.max(minIdx, maxIdx);

        // Option 1: Back (remove everything after i from back? No. To remove j from
        // back: n-j. Remove i: n-i.)
        // Actually:
        // From Front: need to reach j. Count = j + 1.
        // From Back: need to reach i. Count = n - i.
        // Split: i+1 (front) + n-j (back).

        int bothFront = j + 1;
        int bothBack = n - i;
        int split = (i + 1) + (n - j);

        return Math.min(bothFront, Math.min(bothBack, split));
    }
}
