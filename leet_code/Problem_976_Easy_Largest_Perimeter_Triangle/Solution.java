package leet_code.Problem_976_Easy_Largest_Perimeter_Triangle;

import java.util.Arrays;

/**
 * Problem 976: Largest Perimeter Triangle
 * https://leetcode.com/problems/largest-perimeter-triangle/
 */
public class Solution {

    /**
     * Finds the largest perimeter triangle.
     * Strategy: Greedy approach with sorting.
     * 
     * @param nums Array of integers.
     * @return Largest perimeter or 0.
     * 
     *         Tóm tắt chiến lược:
     *         1. Để tối đa hóa chu vi `A + B + C`, ta muốn sử dụng 3 cạnh dài nhất
     *         có thể.
     *         2. Bất đẳng thức tam giác là `A + B > C` (giả sử C là cạnh dài nhất).
     *         3. Sắp xếp mảng theo thứ tự tăng dần.
     *         4. Duyệt từ cuối mảng (`nums[i]` là cạnh lớn nhất tiềm năng).
     *         Ta kiểm tra xem 2 cạnh liền kề nhỏ hơn (`nums[i-1]` và `nums[i-2]`)
     *         có thỏa mãn điều kiện tam giác với `nums[i]` không.
     *         Nếu `nums[i-2] + nums[i-1] > nums[i]`, thì đây chính là tam giác có
     *         chu vi lớn nhất có thể dùng `nums[i]` làm cạnh lớn nhất.
     *         Bởi vì nếu ta chọn bất kỳ cạnh nào nhỏ hơn `nums[i-2]` để thay thế,
     *         tổng 2 cạnh nhỏ sẽ còn nhỏ hơn nữa và càng không thỏa mãn.
     *         5. Nếu tìm thấy, trả về tổng 3 cạnh ngay lập tức.
     *         6. Nếu duyệt hết mà không thấy, trả về 0.
     */
    public int largestPerimeter(int[] nums) {
        // Sort array in ascending order
        Arrays.sort(nums);

        // Iterate from the largest element downwards
        // Need at least 3 elements
        for (int i = nums.length - 1; i >= 2; i--) {
            // Check triangle inequality for the triplet (nums[i-2], nums[i-1], nums[i])
            // Since array is sorted, we only need to check a + b > c (the longest side)
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] n1 = { 2, 1, 2 };
        System.out.println("Result: " + sol.largestPerimeter(n1)); // 5

        int[] n2 = { 1, 2, 1, 10 };
        System.out.println("Result: " + sol.largestPerimeter(n2)); // 0
    }
}
