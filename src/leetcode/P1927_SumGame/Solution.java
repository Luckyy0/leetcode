package leetcode.P1927_SumGame;

public class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sumLeft = 0, sumRight = 0;
        int cntLeft = 0, cntRight = 0;

        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);
            if (c == '?')
                cntLeft++;
            else
                sumLeft += (c - '0');
        }

        for (int i = n / 2; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?')
                cntRight++;
            else
                sumRight += (c - '0');
        }

        int diff = sumLeft - sumRight;
        int q = cntLeft - cntRight;

        // Formula: 2 * diff + 9 * q == 0 means Bob wins
        // If != 0, Alice wins
        return (2 * diff + 9 * q) != 0;
    }
}
