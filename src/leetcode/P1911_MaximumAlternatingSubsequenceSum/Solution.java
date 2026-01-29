package leetcode.P1911_MaximumAlternatingSubsequenceSum;

public class Solution {
    public long maxAlternatingSum(int[] nums) {
        long even = 0; // Max sum ending with + operation
        long odd = 0; // Max sum ending with - operation

        for (int x : nums) {
            long tempEven = Math.max(even, odd + x);
            long tempOdd = Math.max(odd, even - x);
            even = tempEven;
            odd = tempOdd;
        }

        return even;
    }
}
