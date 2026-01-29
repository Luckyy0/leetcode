package leetcode.P349_IntersectionOfTwoArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Problem 349: Intersection of Two Arrays
     * Approach: HashSet
     * 
     * Time Complexity: O(N + M)
     * Space Complexity: O(N + M)
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }

        Set<Integer> intersect = new HashSet<>();
        for (int n : nums2) {
            if (set1.contains(n)) {
                intersect.add(n);
            }
        }

        int[] result = new int[intersect.size()];
        int i = 0;
        for (int n : intersect) {
            result[i++] = n;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,2,2,1], [2,2] -> [2]
        runTest(solution, new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 });

        // [4,9,5], [9,4,9,8,4] -> [9,4] or [4,9]
        runTest(solution, new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 });
    }

    private static void runTest(Solution s, int[] n1, int[] n2) {
        int[] result = s.intersection(n1, n2);
        System.out.println("Result: " + Arrays.toString(result));
        System.out.println("-----------------");
    }
}
