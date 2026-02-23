package leet_code.Problem_532_Medium_K_diff_Pairs_in_an_Array;

import java.util.HashMap;
import java.util.Map;

public class Solution_HashMap {

    /**
     * Counts unique k-diff pairs.
     * Strategy: Use frequency map. Check n+k (if k>0) or count>=2 (if k=0).
     * Time: O(N), Space: O(N).
     */
    public int findPairs(int[] nums, int k) {
        if (k < 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (k == 0) {
                if (freq >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(num + k)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution_HashMap solution = new Solution_HashMap();
        int[] nums = { 3, 1, 4, 1, 5 };
        System.out.println("Result k=2: " + solution.findPairs(nums, 2)); // 2

        int[] nums2 = { 1, 3, 1, 5, 4 };
        System.out.println("Result k=0: " + solution.findPairs(nums2, 0)); // 1
    }
}
