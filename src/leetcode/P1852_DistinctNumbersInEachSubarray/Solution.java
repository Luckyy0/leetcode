package leetcode.P1852_DistinctNumbersInEachSubarray;

public class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int[] counts = new int[100001]; // Assuming values <= 10^5
        int distinct = 0;

        // First window
        for (int i = 0; i < k; i++) {
            if (counts[nums[i]] == 0)
                distinct++;
            counts[nums[i]]++;
        }
        result[0] = distinct;

        // Slide
        for (int i = k; i < n; i++) {
            // Remove nums[i-k]
            int removeVal = nums[i - k];
            counts[removeVal]--;
            if (counts[removeVal] == 0)
                distinct--;

            // Add nums[i]
            int addVal = nums[i];
            if (counts[addVal] == 0)
                distinct++;
            counts[addVal]++;

            result[i - k + 1] = distinct;
        }

        return result;
    }
}
