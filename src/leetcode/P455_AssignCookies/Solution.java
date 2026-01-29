package leetcode.P455_AssignCookies;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 455: Assign Cookies
     * Approach: Greedy (Two Pointers after Sorting)
     * 
     * Time Complexity: O(G log G + S log S)
     * Space Complexity: O(1)
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int childIdx = 0;
        int cookieIdx = 0;

        while (childIdx < g.length && cookieIdx < s.length) {
            if (s[cookieIdx] >= g[childIdx]) {
                // This cookie can satisfy this child
                childIdx++;
            }
            // Move to the next cookie regardless
            cookieIdx++;
        }

        return childIdx;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // g = [1,2,3], s = [1,1] -> 1
        int[] g1 = { 1, 2, 3 };
        int[] s1 = { 1, 1 };
        runTest(sol, g1, s1, 1);

        // g = [1,2], s = [1,2,3] -> 2
        int[] g2 = { 1, 2 };
        int[] s2 = { 1, 2, 3 };
        runTest(sol, g2, s2, 2);
    }

    private static void runTest(Solution sol, int[] g, int[] s, int expected) {
        int result = sol.findContentChildren(g, s);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
