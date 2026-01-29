package leetcode.P2179_CountGoodTripletsInAnArray;

public class Solution {
    class FenwickTree {
        int[] tree;
        int n;

        public FenwickTree(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        public void update(int i, int delta) {
            i++; // 1-based
            while (i <= n) {
                tree[i] += delta;
                i += i & (-i);
            }
        }

        public int query(int i) {
            i++;
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & (-i);
            }
            return sum;
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos = new int[n];
        for (int i = 0; i < n; i++)
            pos[nums2[i]] = i;

        // Transform nums1 to relative positions in nums2
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = pos[nums1[i]];

        FenwickTree bit = new FenwickTree(n);
        long[] lessBefore = new long[n];

        for (int i = 0; i < n; i++) {
            lessBefore[i] = bit.query(arr[i] - 1);
            bit.update(arr[i], 1);
        }

        // Calculate greaterAfter
        // Total elements > arr[i] is (n - 1 - arr[i])
        // Elements > arr[i] BEFORE i is (i - lessBefore[i])
        // Elements > arr[i] AFTER i = Total > - GreaterBefore

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long totalGreater = n - 1 - arr[i];
            long greaterBefore = i - lessBefore[i];
            long greaterAfter = totalGreater - greaterBefore;

            ans += lessBefore[i] * greaterAfter;
        }

        return ans;
    }
}
