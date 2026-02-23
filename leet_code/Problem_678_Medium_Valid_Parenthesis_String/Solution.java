package leet_code.Problem_678_Medium_Valid_Parenthesis_String;

public class Solution {

    /**
     * Checks if a parenthesis string with wildcards '*' is valid.
     * Strategy: Greedy range tracking of possible open parenthesis counts.
     * Time: O(N), Space: O(1).
     */
    public boolean checkValidString(String s) {
        // minOpen: minimum possible open parentheses we could have
        // maxOpen: maximum possible open parentheses we could have
        int minOpen = 0;
        int maxOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                // Case: * acts as ')' -> minOpen--
                // Case: * acts as '(' -> maxOpen++
                // Case: * acts as '' -> counts remain within [minOpen-1, maxOpen+1]
                minOpen--;
                maxOpen++;
            }

            // If even with all * acting as '(', we have negative balance, it's invalid.
            if (maxOpen < 0)
                return false;

            // minOpen cannot be negative. If it reaches -1, it means we chose to treat
            // a '(' or '*' as a ')' even when we didn't need to. We reset it to 0.
            if (minOpen < 0)
                minOpen = 0;
        }

        // It's valid if we can potentially reach a balance of 0.
        return minOpen == 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result '()': " + sol.checkValidString("()")); // true
        System.out.println("Result '(*)': " + sol.checkValidString("(*)")); // true
        System.out.println("Result '(*))': " + sol.checkValidString("(*))")); // true
        System.out.println("Result ')(': " + sol.checkValidString(")(")); // false
    }
}
