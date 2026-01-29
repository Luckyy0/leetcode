package leetcode.P532_KDiffPairsInArray;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        // Count frequency of each number
        // Đếm tần suất của mỗi số
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for (int key : map.keySet()) {
            if (k == 0) {
                // If k is 0, we need at least 2 occurrences of the same number
                // Nếu k là 0, chúng ta cần ít nhất 2 lần xuất hiện của cùng một số
                if (map.get(key) >= 2) {
                    count++;
                }
            } else {
                // If k > 0, check if key + k exists
                // Nếu k > 0, kiểm tra xem key + k có tồn tại không
                if (map.containsKey(key + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}
