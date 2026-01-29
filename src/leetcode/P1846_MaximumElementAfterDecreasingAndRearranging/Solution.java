package leetcode.P1846_MaximumElementAfterDecreasingAndRearranging;

import java.util.Arrays;

public class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int prev = 1;
        // arr[0] effectively becomes 1 based on constraint, or we clamp the sequence.
        // Actually, greedy logic: current element can be at most prev + 1.
        // Since sorted[0] >= 1, we start sequence with 1.

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > prev) {
                prev++;
            }
            // else arr[i] <= prev, so max we can reach is arr[i], which is <= prev
            // (actually <= prev implies duplicate or smaller gap).
            // Wait. If arr[i] == prev, then new value is prev. (Gap 0).
            // Logic: new_val[i] = min(arr[i], new_val[i-1] + 1).
            // We only track the running value 'prev'.
            // if arr[i] >= prev + 1, we assume we set it to prev + 1.
            // if arr[i] < prev + 1, we are forced to arr[i].
            // Correct constraint: new[i] <= new[i-1] + 1. Also new[i] <= original[i].
            // To Maximize new[i], we pick min(original[i], new[i-1] + 1).
            // My loop: if arr[i] > prev, prev becomes prev+1 (we clamp down to prev+1).
            // if arr[i] <= prev, prev becomes arr[i]?
            // No, prev tracks the height. We want to climb as fast as possible.
            // Let's refine:
            // current = min(arr[i], prev + 1).
            // prev = current.
        }

        // Wait, loop index:
        // i=0: prev = 1 (since we force start 1).
        // BUT strict logic: arr[0] = 1.
        // If sorted[0] > 1, we reduce to 1.

        // Loop corrected:
        // prev = 1; (for index 0).
        // Loop i=1...
        // prev = min(arr[i], prev + 1).

        return prev;
    }
}
