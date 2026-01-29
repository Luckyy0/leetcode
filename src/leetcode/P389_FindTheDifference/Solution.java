package leetcode.P389_FindTheDifference;

public class Solution {

    /**
     * Problem 389: Find the Difference
     * Approach: XOR
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public char findTheDifference(String s, String t) {
        int xor = 0;

        for (char c : s.toCharArray()) {
            xor ^= c;
        }

        for (char c : t.toCharArray()) {
            xor ^= c;
        }

        return (char) xor;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "abcd", "abcde" -> 'e'
        runTest(solution, "abcd", "abcde", 'e');

        // "", "y" -> 'y'
        runTest(solution, "", "y", 'y');
    }

    private static void runTest(Solution sol, String s, String t, char expected) {
        char result = sol.findTheDifference(s, t);
        System.out.println("s: " + s + ", t: " + t + " -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
