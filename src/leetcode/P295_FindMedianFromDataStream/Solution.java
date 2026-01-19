package leetcode.P295_FindMedianFromDataStream;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

    /**
     * Problem 295: Find Median from Data Stream
     * Approach: Two Heaps (MinMax)
     * 
     * Theoretical Basis:
     * - MaxHeap stores lower half.
     * - MinHeap stores upper half.
     * - Balance sizes.
     * 
     * Time Complexity: O(log N) add, O(1) find
     * Space Complexity: O(N)
     */
    public static class MedianFinder {

        private PriorityQueue<Integer> low; // Max Heap
        private PriorityQueue<Integer> high; // Min Heap

        public MedianFinder() {
            low = new PriorityQueue<>(Collections.reverseOrder());
            high = new PriorityQueue<>();
        }

        public void addNum(int num) {
            // Add to low first (MaxHeap)
            low.offer(num);

            // Move largest of low to high to ensure property `max(low) <= min(high)`
            high.offer(low.poll());

            // Balance sizes: Low can be size N or N+1, High size N.
            // If High has more elements than Low, move back.
            if (high.size() > low.size()) {
                low.offer(high.poll());
            }
        }

        public double findMedian() {
            if (low.size() > high.size()) {
                return low.peek();
            } else {
                return (low.peek() + high.peek()) / 2.0;
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();

        // add(1)
        mf.addNum(1);

        // add(2)
        mf.addNum(2);

        // median -> 1.5
        runTest(mf, 1.5);

        // add(3)
        mf.addNum(3);

        // median -> 2.0
        runTest(mf, 2.0);
    }

    private static void runTest(MedianFinder mf, double expected) {
        double result = mf.findMedian();
        System.out.println("Median: " + result + " (Expected: " + expected + ")");

        if (Math.abs(result - expected) < 1e-5) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
