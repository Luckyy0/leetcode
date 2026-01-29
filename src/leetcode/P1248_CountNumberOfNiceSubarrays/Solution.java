package leetcode.P1248_CountNumberOfNiceSubarrays;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int odds = 0;
        int left = 0;
        int temp = 0; // Number of prefixes for current window

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) {
                odds++;
                temp = 0; // Reset prefix count since we encountered new odd
            }

            while (odds == k) {
                temp++;
                if (nums[left] % 2 == 1) {
                    odds--;
                }
                left++;
            }

            count += temp;
        }

        return count;
    }
}
