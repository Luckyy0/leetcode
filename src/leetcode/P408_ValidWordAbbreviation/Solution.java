package leetcode.P408_ValidWordAbbreviation;

public class Solution {

    /**
     * Problem 408: Valid Word Abbreviation
     * Approach: Two Pointers
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        int n = word.length(), m = abbr.length();

        while (i < n && j < m) {
            char c = abbr.charAt(j);

            if (Character.isDigit(c)) {
                if (c == '0')
                    return false; // Leading zero not allowed

                int num = 0;
                while (j < m && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += num;
            } else {
                if (word.charAt(i) != c) {
                    return false;
                }
                i++;
                j++;
            }
        }

        return i == n && j == m;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "substitution", "s10n" -> true
        runTest(solution, "substitution", "s10n", true);

        // "substitution", "s010n" -> false
        runTest(solution, "substitution", "s010n", false);

        // "a", "01" -> false
        runTest(solution, "a", "01", false);

        // "apple", "a2e" -> false (apple is length 5, a2e suggests length 4? No, a + 2
        // + e = 4. word is length 5)
        // Wait, a2e: a (1) + 2 + e (1) = 4 chars. Word apple is 5.
        // If i=1 (p), abbr[1]=2. num=2. i becomes 1+2=3 (e). then abbr[2]=e. match.
        // word[3]=l, abbr[2]=e. NO.
        runTest(solution, "apple", "a2e", false);

        // "internationalization", "i12iz4n" -> true
        runTest(solution, "internationalization", "i12iz4n", true);
    }

    private static void runTest(Solution sol, String word, String abbr, boolean expected) {
        boolean result = sol.validWordAbbreviation(word, abbr);
        System.out.println(
                "Word: " + word + ", Abbr: " + abbr + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
