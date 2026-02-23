package leet_code.Problem_325_Medium_Maximum_Size_Subarray_Sum_Equals_k;

import java.util.HashMap;
import java.util.Map;

public class Solution_HashMap {

    /**
     * Finds max length of subarray summing to k.
     * Uses HashMap and Prefix Sum.
     * Time: O(N), Space: O(N).
     * 
     * Tìm độ dài lớn nhất của mảng con có tổng bằng k.
     * Sử dụng HashMap và Tổng tiền tố.
     */
    public int maxSubArrayLen(int[] nums, int k) {
        // Map stores (Cumulative Sum -> First Index)
        Map<Long, Integer> map = new HashMap<>(); // Use Long for sum to avoid overflow
        map.put(0L, -1);

        long sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // If sum - k exists in map, it means the subarray from that index+1 to i sums
            // to k
            // Nếu sum - k tồn tại trong map, nghĩa là mảng con từ index+1 đến i có tổng
            // bằng k
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }

            // Only add sum if not present to keep the earliest index (for max length)
            // Chỉ thêm sum nếu chưa tồn tại để giữ chỉ số sớm nhất (cho độ dài tối đa)
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution_HashMap solution = new Solution_HashMap();

        // Test Case 1: [1,-1,5,-2,3], k=3 -> 4
        int[] n1 = { 1, -1, 5, -2, 3 };
        System.out.println("Max Len 1: " + solution.maxSubArrayLen(n1, 3));

        // Test Case 2: [-2,-1,2,1], k=1 -> 2
        int[] n2 = { -2, -1, 2, 1 };
        System.out.println("Max Len 2: " + solution.maxSubArrayLen(n2, 1));
    }
}
