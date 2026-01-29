package leetcode.P995_MinimumNumberOfKConsecutiveBitFlips;

class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        int res = 0, currentFlips = 0;

        for (int i = 0; i < n; i++) {
            currentFlips += diff[i];
            // If bit is 0 after currentFlips, or bit is 1 and it's flipped odd times
            if ((nums[i] + currentFlips) % 2 == 0) {
                if (i + k > n)
                    return -1;
                res++;
                currentFlips++;
                diff[i + k]--;
            }
        }
        return res;
    }
}
