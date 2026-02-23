package leet_code.Problem_600_Hard_Non_negative_Integers_without_Consecutive_Ones;

public class Solution_DP {

    /**
     * Finds count of integers <= n without consecutive ones in binary.
     * Strategy: Precompute Fibonacci sequence and use bitwise Digit DP.
     * Time: O(log N), Space: O(1).
     */
    public int findIntegers(int n) {
        // f[k] = number of binary strings of length k with no '11'
        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < 32; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        int result = 0;
        int prevBit = 0;

        // Scan from the 31st bit down to 0
        for (int k = 30; k >= 0; k--) {
            // Check if k-th bit is set
            if ((n & (1 << k)) != 0) {
                // If bit is set, any number with 0 at this bit and
                // valid combinations for lower bits is <= n.
                result += f[k];

                // If we found '11' in n's prefix, no further valid numbers exist <= n
                if (prevBit == 1) {
                    return result;
                }
                prevBit = 1;
            } else {
                prevBit = 0;
            }
        }

        // Include n itself if it doesn't have '11'
        return result + 1;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();
        System.out.println("n=5: " + solution.findIntegers(5)); // 5
        System.out.println("n=1: " + solution.findIntegers(1)); // 2
        System.out.println("n=2: " + solution.findIntegers(2)); // 3
    }
}
