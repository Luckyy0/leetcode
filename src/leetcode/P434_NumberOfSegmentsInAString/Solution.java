package leetcode.P434_NumberOfSegmentsInAString;

public class Solution {

    /**
     * Problem 434: Number of Segments in a String
     * Approach: Boundary Counting
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // "Hello, my name is John" -> 5
        runTest(sol, "Hello, my name is John", 5);

        // "Hello" -> 1
        runTest(sol, "Hello", 1);

        // " " -> 0
        runTest(sol, "                ", 0);

        // "" -> 0
        runTest(sol, "", 0);
    }

    private static void runTest(Solution sol, String s, int expected) {
        int result = sol.countSegments(s);
        System.out.println("String: \"" + s + "\" -> Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
