package leet_code.Problem_459_Easy_Repeated_Substring_Pattern;

public class Solution_StringTrick {

    /**
     * Checks if s is a repetition of a substring.
     * Strategy: Doubling trick. (s+s) contains s if s is periodic.
     * Time: O(N), Space: O(N).
     */
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0)
            return false;

        // Double the string
        String doubled = s + s;

        // Remove first and last characters and check if s is still present
        // If s is periodic, rotating it will eventually return back to itself
        // before a full N-step rotation.
        return doubled.substring(1, doubled.length() - 1).contains(s);
    }

    public static void main(String[] args) {
        Solution_StringTrick solution = new Solution_StringTrick();
        System.out.println("Result (abab): " + solution.repeatedSubstringPattern("abab")); // true
        System.out.println("Result (aba): " + solution.repeatedSubstringPattern("aba")); // false
    }
}
