package leet_code.Problem_254_Medium_Factor_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution_Backtracking {

    /**
     * Finds all factor combinations.
     * Uses backtracking with duplicate eliminations constraints.
     * Time: O(N^0.5 * Factors), Space: O(log N).
     * 
     * Tìm tất cả các tổ hợp thừa số.
     * Sử dụng quay lui với ràng buộc loại bỏ trùng lặp.
     */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), n, 2);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> currentPath, int n, int start) {
        // We only iterate up to sqrt(n) because for every factor i, n/i is the pair.
        // If we went past sqrt(n), we would just find the n/i which we already
        // processed.
        // Chúng ta chỉ duyệt đến sqrt(n) vì với mỗi thừa số i, n/i là cặp của nó.
        for (int i = start; i * i <= n; i++) {
            if (n % i == 0) {
                // Found a factor i. The pair is n/i.
                // Tìm thấy thừa số i. Cặp là n/i.

                // Option 1: Add [i, n/i] as a solution branch ending here
                // Lựa chọn 1: Thêm [i, n/i] như một nhánh giải pháp kết thúc tại đây
                List<Integer> newPath = new ArrayList<>(currentPath);
                newPath.add(i);
                newPath.add(n / i);
                result.add(newPath);

                // Option 2: Add i to path and recurse on n/i to break it down further
                // Lựa chọn 2: Thêm i vào đường dẫn và đệ quy trên n/i để phân tích thêm
                currentPath.add(i);
                helper(result, currentPath, n / i, i);
                currentPath.remove(currentPath.size() - 1); // Backtrack
            }
        }
    }

    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1: 1 -> []
        System.out.println("Factors 1: " + solution.getFactors(1));

        // Test Case 2: 12 -> [[2, 6], [2, 2, 3], [3, 4]]
        System.out.println("Factors 12: " + solution.getFactors(12));

        // Test Case 3: 37 -> []
        System.out.println("Factors 37: " + solution.getFactors(37));
    }
}
