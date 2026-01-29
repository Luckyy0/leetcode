package leetcode.P2031_CountSubarraysWithMoreOnesThanZeros;

public class Solution {
    int MOD = 1_000_000_007;
    int[] bit;
    int size;

    public int subarraysWithMoreZerosThanOnes(int[] nums) {
        // nums contains 0 and 1.
        // Wait, title "Count Subarrays With More Ones Than Zeros".
        // Problem usually check P2031. Yes.
        // Transform 0 -> -1.

        int n = nums.length;
        // Prefix sums range from -n to n.
        // Offset n to make 0-based index. Size 2*n + 1.
        size = 2 * n + 2;
        bit = new int[size];

        int count = 0;
        int sum = 0;

        // Base case: prefix[0] starts at index -1 equivalent (sum 0).
        // bit stores frequencies of prefix sums.
        // Initially "prefix[-1]" = 0. Add to BIT.
        update(0 + n, 1);

        for (int x : nums) {
            sum += (x == 1 ? 1 : -1);

            // We need count of prefix[i] such that sum > prefix[i]
            // i.e. query(sum - 1 + n) ??
            // range of values strictly less than sum.
            // BIT query(k) returns sum frequencies from 0 to k.
            // Values < sum => indices < sum + n.
            // query(sum + n - 1).

            int c = query(sum + n - 1);
            count = (count + c) % MOD;

            update(sum + n, 1);
        }

        return count;
    }

    private void update(int idx, int val) {
        idx++; // 1-based
        while (idx < size) {
            bit[idx] += val;
            idx += idx & -idx;
        }
    }

    private int query(int idx) {
        idx++; // 1-based
        int res = 0;
        while (idx > 0) {
            res += bit[idx];
            idx -= idx & -idx;
        }
        return res;
    }
}
