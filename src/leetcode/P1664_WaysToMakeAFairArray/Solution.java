package leetcode.P1664_WaysToMakeAFairArray;

public class Solution {
    public int waysToMakeFair(int[] nums) {
        int totalEven = 0;
        int totalOdd = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                totalEven += nums[i];
            else
                totalOdd += nums[i];
        }

        int currEven = 0;
        int currOdd = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            // Remaining sums excluding nums[i]
            int suffixEven = totalEven - currEven - (i % 2 == 0 ? nums[i] : 0);
            int suffixOdd = totalOdd - currOdd - (i % 2 != 0 ? nums[i] : 0);

            // New sums after removal
            // Even indices after i become odd
            // Odd indices after i become even
            int newEven = currEven + suffixOdd;
            int newOdd = currOdd + suffixEven;

            if (newEven == newOdd) {
                count++;
            }

            // Update prefix sums
            if (i % 2 == 0)
                currEven += nums[i];
            else
                currOdd += nums[i];
        }

        return count;
    }
}
