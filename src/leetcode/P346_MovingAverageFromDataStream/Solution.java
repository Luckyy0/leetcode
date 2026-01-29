package leetcode.P346_MovingAverageFromDataStream;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * Problem 346: Moving Average from Data Stream
     * Approach: Queue
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(N)
     */
    public static class MovingAverage {
        private Queue<Integer> queue;
        private double sum;
        private int size;

        public MovingAverage(int size) {
            this.queue = new LinkedList<>();
            this.sum = 0;
            this.size = size;
        }

        public double next(int val) {
            sum += val;
            queue.offer(val);

            if (queue.size() > size) {
                sum -= queue.poll();
            }

            return sum / queue.size();
        }
    }

    public static void main(String[] args) {
        // [1], [10], [3], [5] size 3
        MovingAverage ma = new MovingAverage(3);

        runTest(ma, 1, 1.0);
        runTest(ma, 10, 5.5); // (1+10)/2
        runTest(ma, 3, 4.666666666666667); // (1+10+3)/3 = 14/3
        runTest(ma, 5, 6.0); // (10+3+5)/3 = 18/3
    }

    private static void runTest(MovingAverage ma, int val, double expected) {
        double result = ma.next(val);
        System.out.println("Input: " + val + " -> Result: " + result + " (Expected: " + expected + ")");
        if (Math.abs(result - expected) < 1e-5) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
