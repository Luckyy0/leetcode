package leetcode.P1687_DeliveringBoxesFromStorageToPorts;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        long[] weightPrefix = new long[n + 1];
        int[] diffPrefix = new int[n + 1]; // diffPrefix[i] stores changes up to box i-1
        // Definition: diffPrefix[k] is sum of diffs for boxes 0..k-1
        // Specifically, diff at box x (compare to x-1): if ports differ.
        // Let's align 1-based indexing for prefixes.

        for (int i = 0; i < n; i++) {
            weightPrefix[i + 1] = weightPrefix[i] + boxes[i][1];
            if (i > 0) {
                diffPrefix[i + 1] = diffPrefix[i] + (boxes[i][0] != boxes[i - 1][0] ? 1 : 0);
            }
        }

        int[] dp = new int[n + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);

        // Value function to minimize: dp[j] - diffPrefix[j+1]

        for (int i = 1; i <= n; i++) {
            // Remove invalid j from front
            // Valid j must satisfy: i - j <= maxBoxes => j >= i - maxBoxes
            // And weight constraint
            while (!deque.isEmpty() && (i - deque.peekFirst() > maxBoxes ||
                    weightPrefix[i] - weightPrefix[deque.peekFirst()] > maxWeight)) {
                deque.pollFirst();
            }

            // Should satisfy limits now.
            // Best j is deque.peekFirst()
            int j = deque.peekFirst();

            // Cost calculation:
            // changes in [j+1...i] = diffPrefix[i] - diffPrefix[j+1]
            // Total = dp[j] + 2 + diffPrefix[i] - diffPrefix[j+1]

            dp[i] = diffPrefix[i] + 2 + (dp[j] - diffPrefix[j + 1]);

            // Add current i to deque for future states
            // We want to add 'i' as a potential 'j' for future.
            // Value: dp[i] - diffPrefix[i+1]
            // If i == n, we don't need to add? Actually loop goes to n. Updates dp[n].

            if (i < n) {
                int val = dp[i] - diffPrefix[i + 1];
                while (!deque.isEmpty()) {
                    int last = deque.peekLast();
                    int lastVal = dp[last] - diffPrefix[last + 1];
                    if (lastVal >= val) {
                        deque.pollLast();
                    } else {
                        break;
                    }
                }
                deque.offerLast(i);
            }
        }

        return dp[n];
    }
}
