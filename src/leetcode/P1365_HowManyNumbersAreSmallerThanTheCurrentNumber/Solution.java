package leetcode.P1365_HowManyNumbersAreSmallerThanTheCurrentNumber;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        for (int x : nums) {
            count[x]++;
        }

        int[] prefix = new int[101];
        int running = 0;
        for (int i = 0; i <= 100; i++) {
            prefix[i] = running;
            running += count[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix[nums[i]];
        }

        return res;
    }
}
