package leet_code.Problem_739_Medium_Daily_Temperatures;

import java.util.*;

public class Solution {

    /**
     * Calculates days until a warmer temperature for each day.
     * Strategy: Monotonic Decreasing Stack.
     * Time: O(N), Space: O(N).
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        // Use Deque as a faster alternative to Stack
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // While today is warmer than the day at the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            // Store the index of the day
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] temps1 = { 73, 74, 75, 71, 69, 72, 76, 73 };
        System.out.println("Result 1: " + Arrays.toString(sol.dailyTemperatures(temps1)));
        // [1, 1, 4, 2, 1, 1, 0, 0]

        int[] temps2 = { 30, 40, 50, 60 };
        System.out.println("Result 2: " + Arrays.toString(sol.dailyTemperatures(temps2)));
        // [1, 1, 1, 0]
    }
}
