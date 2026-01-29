package leetcode.P921_MinimumAddToMakeParenthesesValid;

class Solution {
    public int minAddToMakeValid(String s) {
        int balance = 0;
        int add = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                if (balance > 0)
                    balance--;
                else
                    add++;
            }
        }
        return add + balance;
    }
}
