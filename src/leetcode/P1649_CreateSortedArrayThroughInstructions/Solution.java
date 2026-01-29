package leetcode.P1649_CreateSortedArrayThroughInstructions;

public class Solution {
    private int[] bit;
    private int maxVal = 100001;

    public int createSortedArray(int[] instructions) {
        bit = new int[maxVal + 1];
        long cost = 0;
        int mod = 1_000_000_007;

        for (int i = 0; i < instructions.length; i++) {
            int x = instructions[i];
            int less = query(x - 1);
            int lessEqual = query(x);
            int greater = i - lessEqual;

            cost = (cost + Math.min(less, greater)) % mod;
            update(x, 1);
        }

        return (int) cost;
    }

    // Updates value at index i by delta
    private void update(int i, int delta) {
        while (i <= maxVal) {
            bit[i] += delta;
            i += i & (-i);
        }
    }

    // Returns sum from 1 to i
    private int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= i & (-i);
        }
        return sum;
    }
}
