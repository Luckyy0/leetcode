package leet_code.Problem_470_Medium_Implement_Rand10_Using_Rand7;

// Valid "SolBase" class structure as required by LeetCode context, 
// though we simulate rand7() here for local testing.
class SolBase {
    public int rand7() {
        // Simulation of uniform random 1-7
        return (int) (Math.random() * 7) + 1;
    }
}

public class Solution_RejectionSampling extends SolBase {

    /**
     * Generates a uniform random integer in [1, 10] using rand7().
     * Strategy: Generate [1, 49] using 2 calls. Limit to [1, 40] for uniformity.
     * Time: O(1) expected (approx 2.45 calls).
     */
    public int rand10() {
        int row, col, idx;

        do {
            row = rand7();
            col = rand7();
            // Convert 2D 7x7 coordinate to 1D index [1, 49]
            idx = (row - 1) * 7 + col;
        } while (idx > 40); // Reject 41-49

        // Map [1, 40] to [1, 10]
        return (idx - 1) % 10 + 1;
    }

    public static void main(String[] args) {
        Solution_RejectionSampling solution = new Solution_RejectionSampling();

        // Basic probability test
        int[] counts = new int[11];
        int trials = 100000;
        for (int i = 0; i < trials; i++) {
            counts[solution.rand10()]++;
        }

        System.out.println("Frequency distribution (should be roughly equal):");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + ": " + counts[i]);
        }
    }
}
