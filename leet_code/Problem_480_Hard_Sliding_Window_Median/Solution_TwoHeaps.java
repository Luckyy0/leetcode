package leet_code.Problem_480_Hard_Sliding_Window_Median;

import java.util.*;

public class Solution_TwoHeaps {

    /**
     * Finds the median of the sliding window.
     * Strategy: Two Heaps (Min/Max) with Lazy Removal using HashMap.
     * Time: O(N log k), Space: O(N) worst case (O(k) typical).
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        // small: Max Heap (holds smaller half, top is largest of smalls)
        PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        // large: Min Heap (holds larger half, top is smallest of larges)
        PriorityQueue<Integer> large = new PriorityQueue<>();

        // Map to store count of numbers to be removed later
        Map<Integer, Integer> delayed = new HashMap<>();

        double[] result = new double[nums.length - k + 1];
        int balance = 0; // balance = small.size() - large.size()

        // Initialize first k elements
        for (int i = 0; i < k; i++) {
            small.add(nums[i]);
        }
        // Move n/2 elements to large using rebalance logic
        // But easier: just add all to small, then move some to larges
        // Correct init logic:
        // 1. Add to small
        // 2. Move small.top to large
        // 3. Rebalance so small has k/2 or k/2+1

        // Reset and re-do cleanly in loop
        small.clear();
        for (int i = 0; i < k; i++) {
            add(small, large, nums[i]);
        }
        result[0] = getMedian(small, large, k);

        for (int i = k; i < nums.length; i++) {
            int outgoing = nums[i - k];
            int incoming = nums[i];

            // Balance update based on where outgoing was roughly
            // We can't know for sure without checking, but we can infer:
            // If outgoing <= small.top, it's currently in small (or should be)
            // Else it's in large.
            int balanceDelta = 0;
            if (outgoing <= small.peek()) {
                balanceDelta -= 1;
            } else {
                balanceDelta += 1;
            }

            // Mark outgoing for lazy removal
            delayed.put(outgoing, delayed.getOrDefault(outgoing, 0) + 1);

            // Basic Add incoming logic
            if (!small.isEmpty() && incoming <= small.peek()) {
                small.add(incoming);
                balanceDelta += 1;
            } else {
                large.add(incoming);
                balanceDelta -= 1;
            }

            // Rebalance heaps based on balanceDelta
            // We interpret balanceDelta as "net change to (small - large)"
            // Actually, let's just track sizes carefully or rely on rebalance() which
            // checks heap sizes()
            // BUT heap.size() is wrong because of delayed elements!
            // So we MUST track effective sizes manually? Or rebalance carefully.

            // Let's refine:
            // 'balance' variable tracks effective size difference (small - large).
            // Initially 0 or 1.

            // If outgoing was in small, small effective size decreases (bal -1)
            // If incoming goes to small, small effective size increases (bal +1)
            // So balanceDelta is indeed correct.

            // However, we need to correct the heaps if balance is off.
            // Target: small has (k+1)/2, large has k/2.
            // Wait, balance logic with lazy removal is tricky.
            // Simplified approach: Always add incoming to small/large.
            // Then manually check lazy removals at top.
            // Then rebalance if effective sizes are off.

            // Let's rewrite loop logic to be safer.
        }

        // Re-implementation with simplified logic inside class
        return new ReImpl().solve(nums, k);
    }

    // Inner class for clean state
    class ReImpl {
        PriorityQueue<Integer> small, large;
        Map<Integer, Integer> delayed;
        int smallSize, largeSize; // Effective sizes

        public double[] solve(int[] nums, int k) {
            small = new PriorityQueue<>(Collections.reverseOrder());
            large = new PriorityQueue<>();
            delayed = new HashMap<>();
            smallSize = 0;
            largeSize = 0;

            double[] res = new double[nums.length - k + 1];

            for (int i = 0; i < k; i++) {
                add(nums[i]);
            }
            res[0] = getMedian(k);

            for (int i = k; i < nums.length; i++) {
                int out = nums[i - k];
                int in = nums[i];

                // Add new
                add(in);

                // Remove old (mark lazy)
                // Determine which heap 'out' belongs to effectively
                // Note: 'out' might not be in small if it's smaller than small.peek()
                // but actually got moved to large? No, heaps maintain order.
                // Property: small.peek <= large.peek? No. small.max <= large.min

                int balance = 0; // -1 if removing from small, +1 if removing from large
                if (out <= small.peek()) {
                    smallSize--;
                    balance--;
                } else {
                    largeSize--;
                    balance++;
                }
                delayed.put(out, delayed.getOrDefault(out, 0) + 1);

                // Clean tops
                prune(small);
                prune(large);

                // Rebalance
                rebalance();

                res[i - k + 1] = getMedian(k);
            }
            return res;
        }

        void add(int num) {
            if (small.isEmpty() || num <= small.peek()) {
                small.add(num);
                smallSize++;
            } else {
                large.add(num);
                largeSize++;
            }
            rebalance();
        }

        void rebalance() {
            // We want smallSize == largeSize OR smallSize == largeSize + 1
            while (smallSize > largeSize + 1) {
                large.add(small.poll());
                smallSize--;
                largeSize++;
                prune(small); // Top changed, might be delayed
            }
            while (largeSize > smallSize) {
                small.add(large.poll());
                largeSize--;
                smallSize++;
                prune(large); // Top changed, might be delayed
            }
        }

        void prune(PriorityQueue<Integer> heap) {
            while (!heap.isEmpty() && delayed.containsKey(heap.peek())) {
                int val = heap.peek();
                int count = delayed.get(val);
                if (count == 1)
                    delayed.remove(val);
                else
                    delayed.put(val, count - 1);
                heap.poll();
            }
        }

        double getMedian(int k) {
            if (k % 2 == 1)
                return (double) small.peek();
            else
                return ((long) small.peek() + (long) large.peek()) / 2.0;
        }
    }

    // Helper for initial population (simplified, not used by ReImpl)
    void add(PriorityQueue<Integer> small, PriorityQueue<Integer> large, int num) {
        small.add(num);
        large.add(small.poll());
        if (small.size() < large.size()) {
            small.add(large.poll());
        }
    }

    double getMedian(PriorityQueue<Integer> small, PriorityQueue<Integer> large, int k) {
        if (k % 2 == 1)
            return small.peek();
        else
            return ((long) small.peek() + (long) large.peek()) / 2.0;
    }

    public static void main(String[] args) {
        Solution_TwoHeaps solution = new Solution_TwoHeaps();
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        double[] res = solution.medianSlidingWindow(nums, 3);
        System.out.println("Result: " + Arrays.toString(res));
    }
}
