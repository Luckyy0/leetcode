package leetcode.P315_CountOfSmallerNumbersAfterSelf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Problem 315: Count of Smaller Numbers After Self
     * Approach: Binary Indexed Tree (Fenwick Tree) with Offset
     * 
     * Time Complexity: O(N log M) where M is value range (20000)
     * Space Complexity: O(N + M)
     */
    public List<Integer> countSmaller(int[] nums) {
        int offset = 10001; // makes range [1, 20002]
        int size = 20002;
        int[] bit = new int[size + 1];

        Integer[] result = new Integer[nums.length];

        // Iterate backwards
        for (int i = nums.length - 1; i >= 0; i--) {
            int rank = nums[i] + offset;
            result[i] = query(bit, rank - 1);
            update(bit, rank, 1);
        }

        return Arrays.asList(result);
    }

    private void update(int[] bit, int i, int delta) {
        while (i < bit.length) {
            bit[i] += delta;
            i += i & (-i);
        }
    }

    private int query(int[] bit, int i) {
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= i & (-i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [5,2,6,1] -> [2,1,1,0]
        runTest(solution, new int[] { 5, 2, 6, 1 }, Arrays.asList(2, 1, 1, 0));

        // [-1] -> [0]
        runTest(solution, new int[] { -1 }, Arrays.asList(0));
    }

    private static void runTest(Solution s, int[] nums, List<Integer> expected) {
        List<Integer> result = s.countSmaller(nums);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
