package leetcode.P504_Base7;

public class Solution {

    /**
     * Problem 504: Base 7
     * Approach: Successive Division by 7
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(log N)
     */
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";

        boolean negative = num < 0;
        num = Math.abs(num);

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }

        if (negative)
            sb.append("-");

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 100 -> "202"
        System.out.println("Result 1: " + sol.convertToBase7(100) + " (Expected: 202)");

        // -7 -> "-10"
        System.out.println("Result 2: " + sol.convertToBase7(-7) + " (Expected: -10)");
    }
}
