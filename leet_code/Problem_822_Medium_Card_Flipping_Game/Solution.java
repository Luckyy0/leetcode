package leet_code.Problem_822_Medium_Card_Flipping_Game;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Finds the minimum good number.
     * Strategy: Identify numbers that are on both sides of the same card
     * (disqualified).
     * Any other number existing on any card can be flipped to the front while
     * ensuring
     * it doesn't appear on the back of any other card.
     * Time: O(N), Space: O(N).
     */
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> disqualified = new HashSet<>();
        int n = fronts.length;

        // Step 1: Any number that is on both front and back of the same card is
        // unusable
        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) {
                disqualified.add(fronts[i]);
            }
        }

        int minGood = Integer.MAX_VALUE;

        // Step 2: Check all numbers on the cards.
        // If a number is not disqualified, it can be a good number.
        for (int x : fronts) {
            if (!disqualified.contains(x)) {
                minGood = Math.min(minGood, x);
            }
        }
        for (int x : backs) {
            if (!disqualified.contains(x)) {
                minGood = Math.min(minGood, x);
            }
        }

        return minGood == Integer.MAX_VALUE ? 0 : minGood;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] f1 = { 1, 2, 4, 4, 7 }, b1 = { 1, 3, 4, 1, 3 };
        System.out.println("Result 1: " + sol.flipgame(f1, b1)); // 2

        int[] f2 = { 1 }, b2 = { 1 };
        System.out.println("Result 2: " + sol.flipgame(f2, b2)); // 0
    }
}
