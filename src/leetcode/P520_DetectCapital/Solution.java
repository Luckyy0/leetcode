package leetcode.P520_DetectCapital;

public class Solution {

    /**
     * Problem 520: Detect Capital
     * Approach: Count uppercase letters and validate patterns
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public boolean detectCapitalUse(String word) {
        int upperCount = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCount++;
            }
        }

        return upperCount == 0 ||
                upperCount == word.length() ||
                (upperCount == 1 && Character.isUpperCase(word.charAt(0)));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("USA: " + sol.detectCapitalUse("USA") + " (Expected: true)");
        System.out.println("FlaG: " + sol.detectCapitalUse("FlaG") + " (Expected: false)");
        System.out.println("Google: " + sol.detectCapitalUse("Google") + " (Expected: true)");
        System.out.println("leetcode: " + sol.detectCapitalUse("leetcode") + " (Expected: true)");
    }
}
