package leetcode.P307_RangeSumQueryMutable;

public class Solution {

    /**
     * Problem 307: Range Sum Query - Mutable
     * Approach: Binary Indexed Tree (Fenwick Tree)
     * 
     * Time Complexity: O(log N) for update and query
     * Space Complexity: O(N)
     */
    public static class NumArray {

        private int[] nums;
        private int[] bit; // Binary Indexed Tree, 1-based
        private int n;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.n = nums.length;
            this.bit = new int[n + 1];

            // Build BIT
            for (int i = 0; i < n; i++) {
                init(i + 1, nums[i]);
            }
        }

        private void init(int i, int val) {
            while (i <= n) {
                bit[i] += val;
                i += i & (-i);
            }
        }

        public void update(int index, int val) {
            int delta = val - nums[index];
            nums[index] = val;
            add(index + 1, delta);
        }

        private void add(int i, int delta) {
            while (i <= n) {
                bit[i] += delta;
                i += i & (-i);
            }
        }

        public int sumRange(int left, int right) {
            return query(right + 1) - query(left);
        }

        private int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += bit[i];
                i -= i & (-i);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5 };
        NumArray obj = new NumArray(nums);

        // sumRange(0, 2) -> 9
        runTest(obj, 0, 2, 9);

        // update(1, 2)
        obj.update(1, 2);
        System.out.println("Update index 1 to 2");

        // sumRange(0, 2) -> 8
        runTest(obj, 0, 2, 8);
    }

    private static void runTest(NumArray na, int l, int r, int expected) {
        int result = na.sumRange(l, r);
        System.out.println("Range [" + l + ", " + r + "] -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
