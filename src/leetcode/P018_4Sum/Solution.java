package leetcode.P018_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Problem 18: 4Sum
     * Approach: Generalized k-Sum
     * Time Complexity: O(n^3)
     * Space Complexity: O(n) (recursion)
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    private List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        // Basic checks
        if (start == nums.length) {
            return res;
        }

        // Average value check to prune recursion
        // Kiểm tra giá trị trung bình để cắt bớt đệ quy
        long average_val = target / k;
        if (nums[start] > average_val || nums[nums.length - 1] < average_val) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i - 1] != nums[i]) {
                List<List<Integer>> subSets = kSum(nums, target - nums[i], i + 1, k - 1);
                for (List<Integer> subSet : subSets) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.addAll(subSet);
                    res.add(list);
                }
            }
        }

        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;

        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                lo++;
            } else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                hi--;
            } else {
                res.add(Arrays.asList(nums[lo], nums[hi]));
                lo++;
                hi--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 1, 0, -1, 0, -2, 2 }, 0, "[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]");
        runTest(solution, new int[] { 2, 2, 2, 2, 2 }, 8, "[[2, 2, 2, 2]]");
        runTest(solution, new int[] { 1000000000, 1000000000, 1000000000, 1000000000 }, -294967296, "[]"); // Overflow
                                                                                                           // test
                                                                                                           // (actual
                                                                                                           // sum
                                                                                                           // 4*10^9)
    }

    private static void runTest(Solution s, int[] input, int target, String expected) {
        System.out.println("Input: " + Arrays.toString(input) + ", target = " + target);
        List<List<Integer>> result = s.fourSum(input, target);
        System.out.println("Output: " + result);
        System.out.println("Expected (approx): " + expected);
        System.out.println("-----------------");
    }
}
