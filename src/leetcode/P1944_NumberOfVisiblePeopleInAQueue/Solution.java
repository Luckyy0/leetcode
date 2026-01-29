package leetcode.P1944_NumberOfVisiblePeopleInAQueue;

import java.util.Stack;

public class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stores heights

        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            while (!stack.isEmpty() && stack.peek() < heights[i]) {
                stack.pop();
                count++;
            }
            // If stack not empty, the current top is the first person taller than or equal
            // to heights[i]
            // This person is also visible
            if (!stack.isEmpty()) {
                count++;
            }

            result[i] = count;
            stack.push(heights[i]);
        }

        return result;
    }
}
