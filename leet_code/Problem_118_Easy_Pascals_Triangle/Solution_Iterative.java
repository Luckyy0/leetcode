package leet_code.Problem_118_Easy_Pascals_Triangle;

import java.util.*;

public class Solution_Iterative {

    /**
     * Generates the first numRows of Pascal's triangle.
     * Each element is the sum of the two elements directly above it.
     * 
     * Tạo ra numRows hàng đầu tiên của tam giác Pascal.
     * Mỗi phần tử là tổng của hai phần tử ngay bên trên nó.
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows <= 0)
            return triangle;

        // First row is always [1]
        // Hàng đầu tiên luôn là [1]
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // The first element of each row is always 1
            // Phần tử đầu tiên của mỗi hàng luôn là 1
            row.add(1);

            // Each triangle element (except first and last) is equal to
            // the sum of the elements above-and-to-the-left and above-and-to-the-right.
            // Mỗi phần tử tam giác (ngoại trừ đầu và cuối) bằng
            // tổng của các phần tử ở trên bên trái và ở trên bên phải.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last element of each row is always 1
            // Phần tử cuối cùng của mỗi hàng luôn là 1
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        Solution_Iterative solution = new Solution_Iterative();

        // Test Case 1: numRows = 5
        System.out.println("Test Case 1 (5 rows): " + solution.generate(5));
        // Expected: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]

        // Test Case 2: numRows = 1
        System.out.println("Test Case 2 (1 row): " + solution.generate(1));
        // Expected: [[1]]
    }
}
