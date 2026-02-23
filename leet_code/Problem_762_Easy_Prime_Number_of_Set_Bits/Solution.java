package leet_code.Problem_762_Easy_Prime_Number_of_Set_Bits;

public class Solution {

    /**
     * Counts numbers with prime set bits in range.
     * Strategy: Iterate and use Integer.bitCount with a precomputed prime mask.
     * Time: O(N * log(val)), Space: O(1).
     */
    public int countPrimeSetBits(int left, int right) {
        int count = 0;

        // Primes up to 20 (max bits for 10^6 is 20): 2, 3, 5, 7, 11, 13, 17, 19
        // 0b10100010100010101100 = 665772
        // Indices set: 2, 3, 5, 7, 11, 13, 17, 19
        int primeMask = 665772;

        for (int i = left; i <= right; i++) {
            int bits = Integer.bitCount(i);
            // Check membership in prime set using bitmask
            if (((primeMask >> bits) & 1) == 1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.countPrimeSetBits(6, 10)); // 4
        System.out.println("Result 2: " + sol.countPrimeSetBits(10, 15)); // 5
    }
}
