package leetcode.P1716_CalculateMoneyInLeetcodeBank;

public class Solution {
    public int totalMoney(int n) {
        int k = n / 7; // full weeks
        int d = n % 7; // remaining days

        // Sum of full weeks
        // Week 0: 28
        // Week i: 28 + 7*i
        // Sum i=0 to k-1: 28k + 7 * k*(k-1)/2
        int fullWeeks = 28 * k + 7 * k * (k - 1) / 2;

        // Remaining days
        // Start: k+1
        // d terms: (k+1) + ... + (k+d)
        // = k*d + (1 + ... + d)
        // = k*d + d*(d+1)/2
        int remaining = k * d + d * (d + 1) / 2;

        return fullWeeks + remaining;
    }
}
