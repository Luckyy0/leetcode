package leetcode.P560_SubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // Base case: sum 0 exists once (before any elements)
        // Trường hợp cơ sở: tổng 0 tồn tại một lần (trước khi có bất kỳ phần tử nào)
        map.put(0, 1);

        for (int num : nums) {
            sum += num;

            // Check if (sum - k) exists in map
            // Kiểm tra xem (sum - k) có tồn tại trong map không
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Add current sum to map
            // Thêm tổng hiện tại vào map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
