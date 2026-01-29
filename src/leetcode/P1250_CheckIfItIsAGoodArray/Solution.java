package leetcode.P1250_CheckIfItIsAGoodArray;

class Solution {
    public boolean isGoodArray(int[] nums) {
        int res = nums[0];
        for (int x : nums) {
            res = gcd(res, x);
            if (res == 1)
                return true;
        }
        return res == 1;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
