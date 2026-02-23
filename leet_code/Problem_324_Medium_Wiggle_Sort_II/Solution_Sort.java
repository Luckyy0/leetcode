package leet_code.Problem_324_Medium_Wiggle_Sort_II;

import java.util.Arrays;

public class Solution_Sort {

    /**
     * Reorders array to wiggle sort.
     * Uses Sort and Interleave (Reverse fill).
     * Time: O(N log N), Space: O(N).
     * 
     * Sắp xếp lại mảng theo kiểu lắc lư.
     * Sử dụng Sắp xếp và Xen kẽ (Điền ngược).
     */
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        // Use two pointers starting from end of each half
        // Sử dụng hai con trỏ bắt đầu từ cuối mỗi nửa
        // Small half: 0 to (n-1)/2
        // Large half: (n-1)/2 + 1 to n-1
        int mid = (n - 1) / 2;
        int right = n - 1;

        // Fill result
        // Even indices get values from Small half (descending)
        // Odd indices get values from Large half (descending)
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = sorted[mid--];
            } else {
                nums[i] = sorted[right--];
            }
        }
    }

    public static void main(String[] args) {
        Solution_Sort solution = new Solution_Sort();

        // Test Case 1: [1,5,1,1,6,4] -> [1,6,1,5,1,4]
        int[] n1 = { 1, 5, 1, 1, 6, 4 };
        solution.wiggleSort(n1);
        System.out.print("Result 1: ");
        for (int x : n1)
            System.out.print(x + " ");
        System.out.println();

        // Test Case 2: [1,3,2,2,3,1] -> [2,3,1,3,1,2]
        int[] n2 = { 1, 3, 2, 2, 3, 1 };
        solution.wiggleSort(n2);
        System.out.print("Result 2: ");
        for (int x : n2)
            System.out.print(x + " ");
        System.out.println();
    }
}
