package leet_code.Problem_461_Easy_Hamming_Distance;

public class Solution_Bitwise {

    /**
     * Calculates the Hamming distance between two integers.
     * Strategy: x ^ y results in bits being 1 only where x and y differ.
     * Time: O(1), Space: O(1).
     */
    public int hammingDistance(int x, int y) {
        // Integer.bitCount uses an efficient population count algorithm
        return Integer.bitCount(x ^ y);
    }

    /**
     * Alternative manual bit counting (Kernighan's Algorithm).
     */
    public int hammingDistanceManual(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            xor &= (xor - 1); // Clears the least significant set bit
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution_Bitwise solution = new Solution_Bitwise();
        System.out.println("Result (1, 4): " + solution.hammingDistance(1, 4)); // 2
    }
}
