package leetcode.P1838_FrequencyOfTheMostFrequentElement;

import java.util.Arrays;

public class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        long sum = 0;
        int maxFreq = 1;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            // Check condition: count * val - sum <= k
            // count = r - l + 1
            long count = r - l + 1;
            while (count * nums[r] - sum > k) {
                sum -= nums[l];
                l++;
                count = r - l + 1;
            }
            maxFreq = Math.max(maxFreq, (int) count);
        }

        return maxFreq;
    }
}
