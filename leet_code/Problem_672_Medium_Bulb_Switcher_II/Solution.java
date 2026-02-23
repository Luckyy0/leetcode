package leet_code.Problem_672_Medium_Bulb_Switcher_II;

public class Solution {

    /**
     * Calculates the number of unique bulb statuses after m operations on n bulbs.
     * Strategy: Case analysis based on n and m, leveraging periodicity and
     * operation redundancy.
     * Time: O(1), Space: O(1).
     */
    public int flipLights(int n, int m) {
        // Case: No operations performed
        if (m == 0)
            return 1;

        // Case: Only one bulb
        // B1, B3, B4 flip it. B2 does nothing. Only 2 states possible: On or Off.
        if (n == 1)
            return 2;

        // Case: Two bulbs
        // m=1: 3 states ([0,0], [0,1], [1,0]) - B4 same as B2 here.
        // m>=2: 4 states ([0,0], [0,1], [1,0], [1,1]).
        if (n == 2) {
            return (m == 1) ? 3 : 4;
        }

        // Case: Three or more bulbs
        // Patterns saturate at n=3 and m=3.
        if (m == 1)
            return 4;
        if (m == 2)
            return 7;
        return 8; // m >= 3
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("n=1, m=1: " + sol.flipLights(1, 1)); // 2
        System.out.println("n=2, m=1: " + sol.flipLights(2, 1)); // 3
        System.out.println("n=3, m=1: " + sol.flipLights(3, 1)); // 4
        System.out.println("n=3, m=2: " + sol.flipLights(3, 2)); // 7
        System.out.println("n=10, m=10: " + sol.flipLights(10, 10)); // 8
    }
}
