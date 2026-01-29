package leetcode.P519_RandomFlipMatrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {

    private final int m, n, totalCells;
    private int available;
    private Map<Integer, Integer> map;
    private Random random;

    /**
     * Problem 519: Random Flip Matrix
     * Approach: Virtual Fisher-Yates with HashMap
     */
    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        this.totalCells = m * n;
        this.available = totalCells;
        this.map = new HashMap<>();
        this.random = new Random();
    }

    public int[] flip() {
        int r = random.nextInt(available);
        int actual = map.getOrDefault(r, r);

        // Swap with last available
        map.put(r, map.getOrDefault(available - 1, available - 1));
        available--;

        return new int[] { actual / n, actual % n };
    }

    public void reset() {
        map.clear();
        available = totalCells;
    }

    public static void main(String[] args) {
        Solution sol = new Solution(3, 1);

        System.out.println("Flip 1: " + java.util.Arrays.toString(sol.flip()));
        System.out.println("Flip 2: " + java.util.Arrays.toString(sol.flip()));
        sol.reset();
        System.out.println("After reset, Flip 3: " + java.util.Arrays.toString(sol.flip()));
    }
}
