package leet_code.Problem_735_Medium_Asteroid_Collision;

import java.util.*;

public class Solution {

    /**
     * Simulates asteroid collisions based on sizes and directions.
     * Strategy: Use a Stack to process sequential collisions.
     * Time: O(N), Space: O(N).
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            // Collision occurs only if current is going left (<0)
            // and top of stack is going right (>0)
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                if (stack.peek() < -a) {
                    stack.pop(); // Top asteroid is smaller, it explodes
                    continue; // Current asteroid continues and might hit the next one
                } else if (stack.peek() == -a) {
                    stack.pop(); // Both are same size, both explode
                    destroyed = true;
                    break;
                } else {
                    // Top asteroid is larger, current asteroid explodes
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(a);
            }
        }

        // Convert stack back to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.asteroidCollision(new int[] { 5, 10, -5 }))); // [5, 10]
        System.out.println(Arrays.toString(sol.asteroidCollision(new int[] { 8, -8 }))); // []
        System.out.println(Arrays.toString(sol.asteroidCollision(new int[] { 10, 2, -5 }))); // [10]
    }
}
