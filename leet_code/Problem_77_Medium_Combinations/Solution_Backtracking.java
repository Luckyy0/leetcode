package leet_code.Problem_77_Medium_Combinations;

import java.util.*;

public class Solution_Backtracking {

    /**
     * Generates all combinations of k numbers from 1 to n.
     * Uses backtracking with pruning.
     * Tạo tất cả các tổ hợp gồm k số từ 1 đến n.
     * Sử dụng quay lui với kỹ thuật tỉa nhánh.
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int start, int n, int k) {
        // Base case: combination size reaches k
        // Trường hợp cơ sở: kích thước tổ hợp đạt k
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Optimization: stop if there are not enough elements remaining
        // Tối ưu hóa: dừng lại nếu không còn đủ phần tử còn lại
        // k - current.size() is the number of elements we still need
        int stillNeed = k - current.size();
        for (int i = start; i <= n - stillNeed + 1; i++) {
            // Choose the number
            // Chọn số
            current.add(i);

            // Move to the next number
            // Chuyển sang số tiếp theo
            backtrack(result, current, i + 1, n, k);

            // Backtrack: remove the number
            // Quay lui: loại bỏ số
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1
        System.out.println("Test Case 1 (n=4, k=2): " + solution.combine(4, 2));
        // Expected: [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]

        // Test Case 2
        System.out.println("Test Case 2 (n=1, k=1): " + solution.combine(1, 1));
        // Expected: [[1]]
    }
}
