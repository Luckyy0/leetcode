package leet_code.Problem_90_Medium_Subsets_II;

import java.util.*;

public class Solution_Backtracking {

    /**
     * Generates all unique subsets of an array that may contain duplicates.
     * Uses sorting and backtracking to skip duplicate elements.
     * Tạo tất cả các tập con duy nhất của một mảng có thể chứa các phần tử trùng
     * lặp.
     * Sử dụng sắp xếp và quay lui để bỏ qua các phần tử trùng lặp.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort to bring duplicates together
        // Sắp xếp để các phần tử trùng lặp nằm cạnh nhau
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        // Add current combination to result
        // Thêm tổ hợp hiện tại vào kết quả
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates at the same recursion level
            // Bỏ qua các phần tử trùng lặp ở cùng một cấp độ đệ quy
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Include current number
            // Bao gồm số hiện tại
            current.add(nums[i]);
            // Recurse to next index
            // Đệ quy sang chỉ số tiếp theo
            backtrack(result, current, nums, i + 1);
            // Backtrack: remove current number
            // Quay lui: loại bỏ số hiện tại
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1: [1,2,2]
        int[] n1 = { 1, 2, 2 };
        System.out.println("Test Case 1: " + solution.subsetsWithDup(n1));
        // Expected: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]

        // Test Case 2: [0]
        int[] n2 = { 0 };
        System.out.println("Test Case 2: " + solution.subsetsWithDup(n2));
        // Expected: [[], [0]]
    }
}
