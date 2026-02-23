package leet_code.Problem_575_Easy_Distribute_Candies;

import java.util.HashSet;
import java.util.Set;

public class Solution_HashSet {

    /**
     * Finds the maximum number of different types of candies Alice can eat.
     * Strategy: min(unique_types, n/2).
     * Time: O(N), Space: O(N).
     */
    public int distributeCandies(int[] candyType) {
        // Use a set to count unique candy types
        Set<Integer> uniqueTypes = new HashSet<>();
        for (int type : candyType) {
            uniqueTypes.add(type);
        }

        // The limit is n / 2
        int allowance = candyType.length / 2;

        // Result is the smaller of the two constraints
        return Math.min(uniqueTypes.size(), allowance);
    }

    public static void main(String[] args) {
        Solution_HashSet solution = new Solution_HashSet();
        int[] candies = { 1, 1, 2, 2, 3, 3 };
        System.out.println("Max unique candies: " + solution.distributeCandies(candies)); // 3
    }
}
