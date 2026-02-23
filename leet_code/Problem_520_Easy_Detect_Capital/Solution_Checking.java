package leet_code.Problem_520_Easy_Detect_Capital;

public class Solution_Checking {

    /**
     * Checks correct capital usage.
     * Strategy: Count uppercase letters and verify rules.
     * Time: O(N), Space: O(1).
     */
    public boolean detectCapitalUse(String word) {
        int capitals = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                capitals++;
            }
        }

        int n = word.length();
        // Case 1: All capitals
        if (capitals == n)
            return true;

        // Case 2: All lower
        if (capitals == 0)
            return true;

        // Case 3: Only first capital
        if (capitals == 1 && Character.isUpperCase(word.charAt(0)))
            return true;

        return false;
    }

    public static void main(String[] args) {
        Solution_Checking solution = new Solution_Checking();
        System.out.println("Result USA: " + solution.detectCapitalUse("USA")); // true
        System.out.println("Result FlaG: " + solution.detectCapitalUse("FlaG")); // false
    }
}
