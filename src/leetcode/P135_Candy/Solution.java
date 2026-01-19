package leetcode.P135_Candy;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 135: Candy
     * Approach: Two-Pass Greedy
     * 
     * Theoretical Basis:
     * - Every child gets at least 1 candy.
     * - Left-to-right pass: satisfy left neighbor conditions.
     * - Right-to-left pass: satisfy right neighbor conditions without violating
     * left conditions.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n <= 1)
            return n;

        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // 1. Left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // 2. Right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Sum total
        int total = 0;
        for (int c : candies) {
            total += c;
        }

        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] ratings1 = { 1, 0, 2 };
        System.out.println("Test 1: " + solution.candy(ratings1)); // Expected: 5

        // Test Case 2
        int[] ratings2 = { 1, 2, 2 };
        System.out.println("Test 2: " + solution.candy(ratings2)); // Expected: 4
    }
}
