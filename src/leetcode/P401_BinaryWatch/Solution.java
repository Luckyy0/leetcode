package leetcode.P401_BinaryWatch;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 401: Binary Watch
     * Approach: Brute Force Iteration with Bit Counting
     * 
     * Time Complexity: O(1) - 12 * 60 iterations
     * Space Complexity: O(1)
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> times = new ArrayList<>();

        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }

        return times;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // turnedOn = 1
        System.out.println("turnedOn = 1: " + solution.readBinaryWatch(1));

        // turnedOn = 9
        System.out.println("turnedOn = 9: " + solution.readBinaryWatch(9));
    }
}
