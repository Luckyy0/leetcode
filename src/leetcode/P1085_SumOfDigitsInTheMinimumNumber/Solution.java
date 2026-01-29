package leetcode.P1085_SumOfDigitsInTheMinimumNumber;

class Solution {
    public int sumOfDigits(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        for (int x : nums)
            minVal = Math.min(minVal, x);

        int sum = 0;
        while (minVal > 0) {
            sum += minVal % 10;
            minVal /= 10;
        }

        return sum % 2 == 0 ? 1 : 0;
    }
}
