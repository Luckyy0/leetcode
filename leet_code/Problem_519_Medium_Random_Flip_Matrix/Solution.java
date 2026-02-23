package leet_code.Problem_519_Medium_Random_Flip_Matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {

    private Map<Integer, Integer> map;
    private int rows, cols, total;
    private Random rand;

    /**
     * Initializes with dimensions.
     * Strategy: Virtual mapping using HashMap.
     */
    public Solution(int m, int n) {
        this.rows = m;
        this.cols = n;
        this.map = new HashMap<>();
        this.rand = new Random();
        this.total = m * n;
    }

    /**
     * Flips a random 0 to 1.
     * Strategy: Pick random index in [0, total-1].
     * Map it to actual value. Swap chosen index with 'tail' of available range.
     * Time: O(1).
     */
    public int[] flip() {
        int r = rand.nextInt(total);

        // Logical index x maps to actual index val
        // If x is not in map, actual index is x
        int actual = map.getOrDefault(r, r);

        // We are "removing" actual from available pool.
        // We do this by mapping 'r' to the value currently at 'total - 1'
        // Effectively moving the 'tail' into the gap created by removing 'r'.
        total--;
        int tail = map.getOrDefault(total, total);
        map.put(r, tail);

        return new int[] { actual / cols, actual % cols };
    }

    /**
     * Resets matrix.
     * Strategy: Clear map, reset total count.
     * Time: O(1) (Amortized clear is quick, or new HashMap).
     */
    public void reset() {
        map.clear();
        total = rows * cols;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(3, 1);
        int[] res1 = solution.flip();
        System.out.println("First flip: [" + res1[0] + ", " + res1[1] + "]");

        solution.reset();
        int[] res2 = solution.flip();
        System.out.println("After reset flip: [" + res2[0] + ", " + res2[1] + "]");
    }
}
