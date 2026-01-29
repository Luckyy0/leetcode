package leetcode.P350_IntersectionOfTwoArraysII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * Problem 350: Intersection of Two Arrays II
     * Approach: HashMap
     * 
     * Time Complexity: O(N + M)
     * Space Complexity: O(min(N, M))
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // Optimization: Use smaller array for map to save space
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> resultList = new ArrayList<>();
        for (int n : nums2) {
            int count = map.getOrDefault(n, 0);
            if (count > 0) {
                resultList.add(n);
                map.put(n, count - 1);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,2,2,1], [2,2] -> [2,2]
        runTest(solution, new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 });

        // [4,9,5], [9,4,9,8,4] -> [4,9] or [9,4]
        runTest(solution, new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 });
    }

    private static void runTest(Solution s, int[] n1, int[] n2) {
        int[] result = s.intersect(n1, n2);
        System.out.println("Result: " + Arrays.toString(result));
        System.out.println("-----------------");
    }
}
