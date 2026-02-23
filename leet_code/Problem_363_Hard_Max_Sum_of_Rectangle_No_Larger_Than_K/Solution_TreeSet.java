package leet_code.Problem_363_Hard_Max_Sum_of_Rectangle_No_Larger_Than_K;

import java.util.TreeSet;

public class Solution_TreeSet {

    /**
     * Finds max rectangle sum <= k.
     * Uses Row Compression and TreeSet binary search.
     * Time: O(cols^2 * rows * log(rows)), Space: O(rows).
     * 
     * Tìm tổng hình chữ nhật lớn nhất <= k.
     * Sử dụng Nén Hàng và TreeSet tìm kiếm nhị phân.
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = Integer.MIN_VALUE;

        // Use the smaller dimension for the outer loops to optimize
        // Sử dụng chiều nhỏ hơn cho các vòng lặp bên ngoài để tối ưu hóa
        boolean useRowsAsOuter = cols > rows;
        int outerMax = useRowsAsOuter ? rows : cols;
        int innerMax = useRowsAsOuter ? cols : rows;

        for (int i = 0; i < outerMax; i++) {
            int[] sums = new int[innerMax];
            for (int j = i; j < outerMax; j++) {
                // Compress into 1D array
                for (int m = 0; m < innerMax; m++) {
                    sums[m] += useRowsAsOuter ? matrix[j][m] : matrix[m][j];
                }

                // Find max subarray sum <= k in 1D array
                max = Math.max(max, findMaxSubarraySum(sums, k));
                if (max == k)
                    return k; // optimization
            }
        }

        return max;
    }

    // Find max subarray sum <= k using TreeSet
    private int findMaxSubarraySum(int[] arr, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int curSum = 0;
        int max = Integer.MIN_VALUE;

        for (int x : arr) {
            curSum += x;
            // Need: curSum - prevSum <= k => prevSum >= curSum - k
            Integer prevSum = set.ceiling(curSum - k);
            if (prevSum != null) {
                max = Math.max(max, curSum - prevSum);
            }
            set.add(curSum);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution_TreeSet solution = new Solution_TreeSet();

        // Test Case 1: [[1,0,1], [0,-2,3]], k=2 -> 2
        int[][] m1 = { { 1, 0, 1 }, { 0, -2, 3 } };
        System.out.println("Result 1: " + solution.maxSumSubmatrix(m1, 2));

        // Test Case 2: [[2,2,-1]], k=3 -> 3
        int[][] m2 = { { 2, 2, -1 } };
        System.out.println("Result 2: " + solution.maxSumSubmatrix(m2, 3));
    }
}
