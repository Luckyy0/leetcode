package leetcode.P205_IsomorphicStrings;

public class Solution {

    /**
     * Problem 205: Isomorphic Strings
     * Approach: Index Mapping with Two Arrays
     * 
     * Theoretical Basis:
     * - Store the last seen position of each character in both strings.
     * - If the positions don't match for the current index, the structure is
     * different.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1) (ASCII size 256)
     */
    public boolean isIsomorphic(String s, String t) {
        int[] indexS = new int[256];
        int[] indexT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check if last seen indices match
            // We use i + 1 because default value is 0 (not seen yet)
            if (indexS[charS] != indexT[charT]) {
                return false;
            }

            indexS[charS] = i + 1;
            indexT[charT] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // egg, add -> true
        runTest(solution, "egg", "add", true);

        // foo, bar -> false
        runTest(solution, "foo", "bar", false);

        // paper, title -> true
        runTest(solution, "paper", "title", true);

        // ab, aa -> false
        runTest(solution, "ab", "aa", false);
    }

    private static void runTest(Solution s, String str1, String str2, boolean expected) {
        boolean result = s.isIsomorphic(str1, str2);
        System.out.println(
                "Input: " + str1 + ", " + str2 + " -> Isomorphic? " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
