package leet_code.Problem_78_Medium_Subsets;

import java.util.*;

public class Solution_Cascading {

    /**
     * Generates all possible subsets of a set of unique elements.
     * Uses the cascading approach.
     * Tạo tất cả các tập con có thể có của một tập hợp các phần tử duy nhất.
     * Sử dụng phương pháp xếp tầng.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start with the empty subset
        // Bắt đầu với tập con rỗng
        result.add(new ArrayList<>());

        for (int num : nums) {
            int size = result.size();
            // Add the current number to all existing subsets
            // Thêm số hiện tại vào tất cả các tập con hiện có
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(result.get(i));
                newSubset.add(num);
                result.add(newSubset);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_Cascading solution = new Solution_Cascading();

        // Test Case 1
        int[] n1 = { 1, 2, 3 };
        System.out.println("Test Case 1: " + solution.subsets(n1));
        // Expected: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]

        // Test Case 2
        int[] n2 = { 0 };
        System.out.println("Test Case 2: " + solution.subsets(n2));
        // Expected: [[], [0]]
    }
}
