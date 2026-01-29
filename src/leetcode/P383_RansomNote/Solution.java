package leetcode.P383_RansomNote;

public class Solution {

    /**
     * Problem 383: Ransom Note
     * Approach: Frequency Array
     * 
     * Time Complexity: O(M + N)
     * Space Complexity: O(1)
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] count = new int[26];

        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "a", "b" -> false
        runTest(solution, "a", "b", false);

        // "aa", "ab" -> false
        runTest(solution, "aa", "ab", false);

        // "aa", "aab" -> true
        runTest(solution, "aa", "aab", true);
    }

    private static void runTest(Solution s, String r, String m, boolean expected) {
        boolean result = s.canConstruct(r, m);
        System.out.println("Note: " + r + ", Mag: " + m + " -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
