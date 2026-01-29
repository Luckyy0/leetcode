package leetcode.P636_ExclusiveTimeOfFunctions;

import java.util.List;
import java.util.Stack;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int timestamp = Integer.parseInt(parts[2]);

            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    // Update the running time of the previous function on stack
                    // Cập nhật thời gian chạy của hàm trước đó trên ngăn xếp
                    result[stack.peek()] += timestamp - prevTime;
                }
                stack.push(id);
                prevTime = timestamp;
            } else {
                // "end"
                // Pop the current function, add duration (end is inclusive)
                // Pop hàm hiện tại, thêm thời lượng (kết thúc được bao gồm)
                result[stack.pop()] += timestamp - prevTime + 1;
                prevTime = timestamp + 1;
            }
        }

        return result;
    }
}
