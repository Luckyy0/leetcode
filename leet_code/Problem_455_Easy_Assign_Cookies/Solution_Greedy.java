package leet_code.Problem_455_Easy_Assign_Cookies;

import java.util.*;

public class Solution_Greedy {

    /**
     * Maximizes the number of satisfied children.
     * Strategy: Sort both and use two pointers to match smallest cookie to smallest
     * requirement.
     * Time: O(N log N + M log M), Space: O(1).
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // children pointer
        int j = 0; // cookies pointer

        while (i < g.length && j < s.length) {
            // If the current cookie can satisfy the current child
            if (s[j] >= g[i]) {
                i++; // Moved to next child
            }
            j++; // Move to next cookie anyway
        }

        return i;
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();
        int[] g = { 1, 2, 3 }, s = { 1, 1 };
        System.out.println("Result: " + solution.findContentChildren(g, s)); // 1
    }
}
