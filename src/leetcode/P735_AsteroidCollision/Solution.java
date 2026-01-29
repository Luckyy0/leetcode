package leetcode.P735_AsteroidCollision;

import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean destroyed = false;

            // Collision occurs if new asteroid is negative and stack top is positive
            // Va chạm xảy ra nếu thiên thạch mới là âm và phần tử đỉnh ngăn xếp là dương
            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                if (stack.peek() < -ast) {
                    stack.pop(); // Stack asteroid destroyed
                    continue;
                } else if (stack.peek() == -ast) {
                    stack.pop(); // Both destroyed
                }
                destroyed = true;
                break;
            }

            if (!destroyed) {
                stack.push(ast);
            }
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--)
            res[i] = stack.pop();
        return res;
    }
}
