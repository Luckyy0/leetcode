package leetcode.P1979_FindGreatestCommonDivisorOfArray;

public class Solution {
    public int findGCD(int[] nums) {
        int min = 1001, max = 0;
        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return gcd(min, max);
    }

    // Iterative
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
