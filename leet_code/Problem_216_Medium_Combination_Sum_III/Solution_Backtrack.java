package leet_code.Problem_216_Medium_Combination_Sum_III;

import java.util.ArrayList;
import java.util.List;

public class Solution_Backtrack {

    /**
     * Finds all valid combinations of k numbers that sum up to n using numbers 1-9.
     * Uses Backtracking with Pruning.
     * Time: O(C(9, k)), Space: O(k).
     * 
     * Tìm tất cả các tổ hợp hợp lệ của k số có tổng bằng n sử dụng các số 1-9.
     * Sử dụng Quay lui với Cắt tỉa.
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, k, n);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentComb, int start, int k, int remainSum) {
        // Base case: If we picked k numbers and sum is correct
        // Trường hợp cơ sở: Nếu đã chọn k số và tổng chính xác
        if (currentComb.size() == k) {
            if (remainSum == 0) {
                result.add(new ArrayList<>(currentComb));
            }
            return;
        }

        // Loop through candidate numbers
        // Duyệt qua các ứng viên
        for (int i = start; i <= 9; i++) {
            // Pruning: If remainder is less than current number, impossible to sum up
            // Cắt tỉa: Nếu phần còn lại nhỏ hơn số hiện tại, không thể cộng đủ
            if (remainSum - i < 0) {
                break;
            }

            currentComb.add(i);
            // Recurse with next number (i+1) because duplicates not allowed
            // Đệ quy với số tiếp theo (i+1) vì không cho phép trùng lặp
            backtrack(result, currentComb, i + 1, k, remainSum - i);
            currentComb.remove(currentComb.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        Solution_Backtrack solution = new Solution_Backtrack();

        // Test Case 1: k=3, n=7 -> [[1,2,4]]
        System.out.println("Comb 1: " + solution.combinationSum3(3, 7));

        // Test Case 2: k=3, n=9 -> [[1,2,6], [1,3,5], [2,3,4]]
        System.out.println("Comb 2: " + solution.combinationSum3(3, 9));

        // Test Case 3: k=4, n=1 -> []
        System.out.println("Comb 3: " + solution.combinationSum3(4, 1));
    }
}
