package leetcode.P659_SplitArrayIntoConsecutiveSubsequences;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();

        // Count frequencies of each number
        // Đếm tần suất của mỗi số
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int x : nums) {
            if (countMap.get(x) == 0)
                continue;

            // Try to append to an existing subsequence ending at x-1
            // Thử thêm vào một dãy con hiện có kết thúc tại x-1
            if (endMap.getOrDefault(x - 1, 0) > 0) {
                countMap.put(x, countMap.get(x) - 1);
                endMap.put(x - 1, endMap.get(x - 1) - 1);
                endMap.put(x, endMap.getOrDefault(x, 0) + 1);
            }
            // Try to start a new subsequence of length 3: [x, x+1, x+2]
            // Thử bắt đầu một dãy con mới có độ dài 3: [x, x+1, x+2]
            else if (countMap.getOrDefault(x + 1, 0) > 0 && countMap.getOrDefault(x + 2, 0) > 0) {
                countMap.put(x, countMap.get(x) - 1);
                countMap.put(x + 1, countMap.get(x + 1) - 1);
                countMap.put(x + 2, countMap.get(x + 2) - 1);
                endMap.put(x + 2, endMap.getOrDefault(x + 2, 0) + 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
