package leetcode.P470_ImplementRand10UsingRand7;

import java.util.Random;

public class Solution {

    private Random random = new Random();

    // Mock rand7()
    public int rand7() {
        return random.nextInt(7) + 1;
    }

    /**
     * Problem 470: Implement Rand10() Using Rand7()
     * Approach: Rejection Sampling
     * 
     * Time Complexity: Expected O(1)
     * Space Complexity: O(1)
     */
    public int rand10() {
        while (true) {
            int row = rand7();
            int col = rand7();
            int idx = (row - 1) * 7 + col; // 1 to 49

            if (idx <= 40) {
                return (idx - 1) % 10 + 1;
            }
            // Reject and try again
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Print 20 samples
        System.out.print("Samples: ");
        for (int i = 0; i < 20; i++) {
            System.out.print(sol.rand10() + " ");
        }
        System.out.println();
    }
}
