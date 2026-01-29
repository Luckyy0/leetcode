package leetcode.P2190_MostFrequentNumberFollowingKeyInAnArray;

public class Solution {
    public int mostFrequent(int[] nums, int key) {
        int[] counts = new int[1001];
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == key) {
                counts[nums[i + 1]]++;
            }
        }

        int maxCount = 0;
        int res = -1;
        for (int i = 0; i <= 1000; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                res = i;
            }
        }
        return res;
    }
}
