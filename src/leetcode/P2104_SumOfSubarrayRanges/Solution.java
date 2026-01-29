package leetcode.P2104_SumOfSubarrayRanges;

import java.util.Stack;

public class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        // Sum of Maxima
        long sumMax = 0;
        Stack<Integer> s = new Stack<>();
        int[] prevGreater = new int[n];
        int[] nextGreater = new int[n];

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && nums[s.peek()] <= nums[i])
                s.pop();
            prevGreater[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        s.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && nums[s.peek()] < nums[i])
                s.pop(); // Strict inequality implies duplicates counted by leftmost
            nextGreater[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        for (int i = 0; i < n; i++) {
            sumMax += (long) nums[i] * (i - prevGreater[i]) * (nextGreater[i] - i);
        }

        // Sum of Minima
        long sumMin = 0;
        s.clear();
        int[] prevLess = new int[n];
        int[] nextLess = new int[n];

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && nums[s.peek()] >= nums[i])
                s.pop();
            prevLess[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        s.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && nums[s.peek()] > nums[i])
                s.pop();
            nextLess[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        for (int i = 0; i < n; i++) {
            sumMin += (long) nums[i] * (i - prevLess[i]) * (nextLess[i] - i);
        }

        return sumMax - sumMin;
    }
}
