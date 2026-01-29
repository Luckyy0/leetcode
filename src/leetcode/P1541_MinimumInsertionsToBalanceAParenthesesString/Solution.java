package leetcode.P1541_MinimumInsertionsToBalanceAParenthesesString;

class Solution {
    public int minInsertions(String s) {
        int res = 0;
        int rightNeeded = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (rightNeeded % 2 != 0) {
                    res++; // Insert ')'
                    rightNeeded--;
                }
                rightNeeded += 2;
            } else {
                rightNeeded--;
                if (rightNeeded < 0) {
                    res++; // Insert '('
                    rightNeeded += 2;
                }
            }
        }

        return res + rightNeeded;
    }
}
