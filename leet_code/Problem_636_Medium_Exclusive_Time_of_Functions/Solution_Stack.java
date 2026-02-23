package leet_code.Problem_636_Medium_Exclusive_Time_of_Functions;

import java.util.*;

public class Solution_Stack {

    /**
     * Calculates exclusive time for each function.
     * Strategy: Use a Stack to track active functions; update time on every event.
     * Time: O(L), Space: O(N + L).
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int lastTimestamp = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int timestamp = Integer.parseInt(parts[2]);

            if (type.equals("start")) {
                // If there's a running function, add time to it
                if (!stack.isEmpty()) {
                    res[stack.peek()] += (timestamp - lastTimestamp);
                }
                stack.push(id);
                lastTimestamp = timestamp;
            } else {
                // For "end", duration is inclusive of the current timestamp
                res[stack.peek()] += (timestamp - lastTimestamp + 1);
                stack.pop();
                lastTimestamp = timestamp + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_Stack sol = new Solution_Stack();
        int n = 2;
        List<String> logs = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");
        int[] res = sol.exclusiveTime(n, logs);
        System.out.println("Result: " + Arrays.toString(res)); // [3, 4]
    }
}
