package leet_code.Problem_900_Medium_RLE_Iterator;

import java.util.*;

/**
 * Problem 900: RLE Iterator
 * https://leetcode.com/problems/rle-iterator/
 */
public class RLEIterator {

    // Store the encoding array
    int[] encoding;
    // Current index in the encoding array
    int idx;

    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
        this.idx = 0;
    }

    /**
     * Consumes n elements and returns the last consumed element.
     * Strategy: Iterate through encoding chunks.
     */
    public int next(int n) {
        while (idx < encoding.length) {
            // If the current run has fewer elements than needed (n > count)
            if (n > encoding[idx]) {
                n -= encoding[idx]; // Consume all elements in this run
                idx += 2; // Move to the next run
            } else {
                // If the current run has enough elements (n <= count)
                encoding[idx] -= n; // Update the count in the current run
                return encoding[idx + 1]; // Return the value of this run
            }
        }

        // If we exhaust the array and still need elements
        return -1;
    }

    public static void main(String[] args) {
        // encoding = [3, 8, 0, 9, 2, 5]
        // Decoded: [8, 8, 8, 5, 5] (The 0, 9 part means 0 nines, so skipped)
        RLEIterator iter = new RLEIterator(new int[] { 3, 8, 0, 9, 2, 5 });

        System.out.println("Next 2: " + iter.next(2)); // returns 8 (consumes two 8s, one 8 left)
        System.out.println("Next 1: " + iter.next(1)); // returns 8 (consumes one 8, zero 8s left)
        System.out.println("Next 1: " + iter.next(1)); // returns 5 (skips 0,9; consumes one 5, one 5 left)
        System.out.println("Next 2: " + iter.next(2)); // returns -1 (consumes one 5, needs one more but array ends)
    }
}
