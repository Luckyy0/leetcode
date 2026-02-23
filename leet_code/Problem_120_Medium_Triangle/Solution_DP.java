package leet_code.Problem_120_Medium_Triangle;

import java.util.*;

public class Solution_DP {

    /**
     * Calculates the minimum path sum from top to bottom.
     * Uses bottom-up Dynamic Programming with O(N) space complexity.
     * 
     * Tính toán tổng đường đi tối thiểu từ đỉnh xuống đáy.
     * Sử dụng Quy hoạch động từ dưới lên với độ phức tạp không gian O(N).
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Initialize dp array with the last row
        // Khởi tạo mảng dp với hàng cuối cùng
        int[] dp = new int[n];
        List<Integer> lastRow = triangle.get(n - 1);
        for (int i = 0; i < n; i++) {
            dp[i] = lastRow.get(i);
        }

        // Iterate from the second to last row up to the top
        // Lặp từ hàng áp chót lên đến đỉnh
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> currentRow = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                // The minimum sum at current cell is its value
                // plus the minimum of the two reachable cells below it.
                // Tổng tối thiểu tại ô hiện tại là giá trị của nó
                // cộng với giá trị nhỏ nhất của hai ô có thể tiếp cận bên dưới.
                dp[j] = currentRow.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: [[2],[3,4],[6,5,7],[4,1,8,3]]
        List<List<Integer>> t1 = new ArrayList<>();
        t1.add(Arrays.asList(2));
        t1.add(Arrays.asList(3, 4));
        t1.add(Arrays.asList(6, 5, 7));
        t1.add(Arrays.asList(4, 1, 8, 3));
        System.out.println("Test Case 1: " + solution.minimumTotal(t1));
        // Expected: 11

        // Test Case 2: [[-10]]
        List<List<Integer>> t2 = new ArrayList<>();
        t2.add(Arrays.asList(-10));
        System.out.println("Test Case 2: " + solution.minimumTotal(t2));
        // Expected: -10
    }
}
