package leetcode.P1186_MaximumSubarraySumWithOneDeletion;

class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return arr[0];

        int prevNoDelete = arr[0];
        int prevOneDelete = 0; // Invalid initially as we can't delete 1 element from 1 element and have
                               // non-empty
        // Actually for i=1, deleted current means prevNoDelete at 0.
        // For i=0, oneDelete is impossible if we interpret "one element left" strictly.
        // Let's iterate from 1.

        // Initialize simple max
        int max = arr[0];

        // prevOneDelete logic: at step 0, deleting 0-th element leaves empty sum 0.
        // But subarray must be non-empty.
        // At i=1:
        // noDelete = max(arr[1], arr[0]+arr[1])
        // oneDelete = max(arr[0] (delete arr[1]), 0 + arr[1] (delete arr[0]?? no,
        // prevOfOneDelete + arr[1]))
        // Better:
        // dp[i][0] = max(arr[i], dp[i-1][0] + arr[i])
        // dp[i][1] = max(dp[i-1][0] (delete i), dp[i-1][1] + arr[i] (keep i, prev
        // deleted))

        int currentNoDelete;
        int currentOneDelete;

        // Proper init
        // Treat i=0 separately
        // Reset prevOneDelete to -inf to avoid using it
        prevOneDelete = -20000; // sufficiently small or Integer.MIN_VALUE/2

        /*
         * Correct loop logic:
         * i=1:
         * noDelete[1] defined.
         * oneDelete[1] = max(noDelete[0], oneDelete[0] + arr[1])
         * Ideally oneDelete[0] is theoretically 0 if we assume empty prefix, but
         * "one element left".
         * Deletion of arr[0] leaves empty. So specific logic.
         * Or just track max.
         */

        prevNoDelete = arr[0];
        prevOneDelete = -1000000000; // Effectively -inf
        max = arr[0];

        for (int i = 1; i < n; i++) {
            currentNoDelete = Math.max(arr[i], prevNoDelete + arr[i]);
            currentOneDelete = Math.max(prevNoDelete, prevOneDelete + arr[i]);

            max = Math.max(max, Math.max(currentNoDelete, currentOneDelete));

            prevNoDelete = currentNoDelete;
            prevOneDelete = currentOneDelete;
        }

        return max;
    }
}
