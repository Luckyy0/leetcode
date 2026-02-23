package leet_code.Problem_119_Easy_Pascals_Triangle_II;

import java.util.*;

public class Solution_Math {

    /**
     * Returns the rowIndex-th row of Pascal's triangle.
     * Uses the binomial coefficient formula: C(n, k) = C(n, k-1) * (n-k+1) / k
     * to achieve O(n) time and O(n) space.
     * 
     * Trả về hàng thứ rowIndex của tam giác Pascal.
     * Sử dụng công thức hệ số nhị thức: C(n, k) = C(n, k-1) * (n-k+1) / k
     * để đạt được thời gian O(n) và không gian O(n).
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        // The first element is always 1
        // Phần tử đầu tiên luôn là 1
        long current = 1;
        row.add((int) current);

        for (int k = 1; k <= rowIndex; k++) {
            // Using formula C(n, k) = C(n, k-1) * (n-k+1) / k
            // where n = rowIndex
            // Here we use 'long' for 'current' to avoid overflow during intermediate
            // calculation
            // Ở đây chúng ta sử dụng kiểu 'long' cho 'current' để tránh tràn số trong quá
            // trình tính toán trung gian
            current = current * (rowIndex - k + 1) / k;
            row.add((int) current);
        }

        return row;
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();

        // Test Case 1: rowIndex = 3
        System.out.println("Test Case 1 (Row 3): " + solution.getRow(3));
        // Expected: [1, 3, 3, 1]

        // Test Case 2: rowIndex = 0
        System.out.println("Test Case 2 (Row 0): " + solution.getRow(0));
        // Expected: [1]

        // Test Case 3: rowIndex = 1
        System.out.println("Test Case 3 (Row 1): " + solution.getRow(1));
        // Expected: [1, 1]
    }
}
