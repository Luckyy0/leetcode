package leet_code.Problem_567_Medium_Permutation_in_String;

public class Solution_SlidingWindow {

    /**
     * Checks if s2 contains a permutation of s1.
     * Strategy: Fixed-size sliding window with frequency array.
     * Time: O(L1 + L2), Space: O(1).
     */
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 > n2)
            return false;

        int[] counts = new int[26];

        // Initial setup for s1 (subtract) and first window of s2 (add)
        for (int i = 0; i < n1; i++) {
            counts[s1.charAt(i) - 'a']--;
            counts[s2.charAt(i) - 'a']++;
        }

        if (isAllZero(counts))
            return true;

        // Slide the window across s2
        for (int i = n1; i < n2; i++) {
            // Add incoming character
            counts[s2.charAt(i) - 'a']++;
            // Remove outgoing character
            counts[s2.charAt(i - n1) - 'a']--;

            if (isAllZero(counts))
                return true;
        }

        return false;
    }

    private boolean isAllZero(int[] counts) {
        for (int c : counts) {
            if (c != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_SlidingWindow solution = new Solution_SlidingWindow();
        System.out.println("Result 1: " + solution.checkInclusion("ab", "eidbaooo")); // true
        System.out.println("Result 2: " + solution.checkInclusion("ab", "eidboaoo")); // false
    }
}
