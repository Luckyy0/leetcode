package leetcode.P1963_MinimumNumberOfSwapsToMakeTheStringBalanced;

public class Solution {
    public int minSwaps(String s) {
        int balance = 0;
        int minBalance = 0;

        for (char c : s.toCharArray()) {
            if (c == '[') {
                balance++;
            } else {
                balance--;
            }
            minBalance = Math.min(minBalance, balance);
        }

        // minBalance is negative. Number ofunmatched closing brackets is -minBalance.
        // Each swap fixes 2.
        int unmatched = -minBalance;
        return (unmatched + 1) / 2;
    }
}
