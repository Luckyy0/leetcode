package leet_code.Problem_789_Medium_Escape_The_Ghosts;

public class Solution {

    /**
     * Determines if escape is possible.
     * Strategy: Compare Manhattan distances. If a ghost can reach the target faster
     * or equal to you, escape is impossible.
     * Time: O(N), Space: O(1).
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        // Calculate my distance to target from (0,0)
        int myDist = Math.abs(target[0]) + Math.abs(target[1]);

        for (int[] ghost : ghosts) {
            // Calculate ghost distance to target
            int ghostDist = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);

            // If ghost is closer or same distance, they can intercept me at the target
            if (ghostDist <= myDist) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] g1 = { { 1, 0 }, { 0, 3 } };
        int[] t1 = { 0, 1 };
        System.out.println("Result 1: " + sol.escapeGhosts(g1, t1)); // true

        int[][] g2 = { { 1, 0 } };
        int[] t2 = { 2, 0 };
        System.out.println("Result 2: " + sol.escapeGhosts(g2, t2)); // false
    }
}
