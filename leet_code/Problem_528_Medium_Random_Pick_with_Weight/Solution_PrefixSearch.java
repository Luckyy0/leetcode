package leet_code.Problem_528_Medium_Random_Pick_with_Weight;

import java.util.Random;

public class Solution_PrefixSearch {

    private int[] prefixSums;
    private int totalSum;
    private Random rand;

    /**
     * Initializes with weights.
     * Strategy: Build prefix sum array.
     * Time: O(N).
     */
    public Solution_PrefixSearch(int[] w) {
        prefixSums = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            prefixSums[i] = sum;
        }
        totalSum = sum;
        rand = new Random();
    }

    /**
     * Picks index based on weight.
     * Strategy: Binary Search for random value in [1, totalSum].
     * Time: O(log N).
     */
    public int pickIndex() {
        int target = rand.nextInt(totalSum) + 1;

        // Find smallest index i such that prefixSums[i] >= target
        int left = 0, right = prefixSums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] w = { 1, 3 };
        Solution_PrefixSearch solution = new Solution_PrefixSearch(w);
        // Run multiple times to verify distribution
        int count0 = 0;
        int trials = 1000;
        for (int i = 0; i < trials; i++) {
            if (solution.pickIndex() == 0)
                count0++;
        }
        System.out.println("Picked 0 roughly 25%: " + (double) count0 / trials);
    }
}
