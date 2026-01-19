package leetcode.P047_PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Problem 47: Permutations II
     * Approach: Backtracking with Used Array & Sorting
     * Time Complexity: O(N * N!)
     * Space Complexity: O(N)
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // If used, skip
            if (used[i])
                continue;

            // If duplicate and previous not used (meaning we skipped the first instance of
            // this number)
            // Nếu trùng lặp và số trước đó chưa được sử dụng (nghĩa là chúng ta đã bỏ qua
            // phiên bản đầu tiên của số này)
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            current.add(nums[i]);
            backtrack(result, current, nums, used);

            // Backtrack
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 1, 1, 2 }, 3);
        runTest(solution, new int[] { 1, 2, 3 }, 6);
        runTest(solution, new int[] { 2, 2, 1, 1 }, 6); // 4! / (2!2!) = 24 / 4 = 6
    }

    private static void runTest(Solution s, int[] nums, int expectedCount) {
        System.out.println("Input: " + Arrays.toString(nums));
        List<List<Integer>> result = s.permuteUnique(nums);
        System.out.println("Output count: " + result.size() + " (Expected: " + expectedCount + ")");
        System.out.println("Result: " + result);

        if (result.size() == expectedCount) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
