package leetcode.P1776_CarFleetII;

import java.util.Stack;

public class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] answer = new double[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            answer[i] = -1.0;
            int p1 = cars[i][0];
            int s1 = cars[i][1];

            while (!stack.isEmpty()) {
                int j = stack.peek();
                int p2 = cars[j][0];
                int s2 = cars[j][1];

                // If current car is slower or equal speed, it can't catch car j
                // Or any car ahead of j (since j acts as a blocker/fast mover).
                // Actually if s1 <= s2, we can't catch j.
                // Can we catch k (after j)? No, j is between i and k.
                if (s1 <= s2) {
                    stack.pop();
                    continue;
                }

                // Potential collision time with j
                double time = (double) (p2 - p1) / (s1 - s2);

                // If j collides with its next car BEFORE i catches j, then j is not the target
                // "fleet leader" i hits effectively.
                // We should look beyond j.
                if (answer[j] > 0 && time > answer[j]) {
                    stack.pop();
                    continue;
                }

                // Found valid collision
                answer[i] = time;
                break;
            }

            stack.push(i);
        }

        return answer;
    }
}
