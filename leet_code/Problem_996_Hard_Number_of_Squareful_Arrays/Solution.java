package leet_code.Problem_996_Hard_Number_of_Squareful_Arrays;

import java.util.Arrays;

/**
 * Problem 996: Number of Squareful Arrays
 * https://leetcode.com/problems/number-of-squareful-arrays/
 */
public class Solution {

    private int count = 0;

    /**
     * Calculates the number of permutations that are squareful.
     * Strategy: Backtracking with Duplicate Pruning.
     * 
     * @param nums Array of integers.
     * @return Number of squareful permutations.
     * 
     *         Tóm tắt chiến lược:
     *         1. Số lượng phần tử rất nhỏ (<= 12), cho thấy giải pháp là Quay lui
     *         (Backtracking) để duyệt qua tất cả các hoán vị (O(N!)).
     *         2. Vấn đề chính: Sinh ra các hoán vị bị trùng lặp do mảng đầu vào có
     *         thể có các giá trị giống nhau (ví dụ [2, 2, 2]).
     *         3. Giải pháp cắt tỉa hoán vị trùng:
     *         - Sắp xếp mảng `nums` từ bé đến lớn.
     *         - Dùng mảng `used[]` để đánh dấu những phần tử đã được dùng trong
     *         nhánh đệ quy hiện tại.
     *         - Nếu phần tử hiện tại giống phần tử ngay trước nó (`nums[i] ==
     *         nums[i-1]`),
     *         và phần tử trước nó KHÔNG được sử dụng (`!used[i-1]`) ở cùng một cấp
     *         độ đệ quy,
     *         ta bỏ qua (`continue`). Điều này chặn việc sinh hoán vị lặp.
     *         4. Cắt tỉa điều kiện Squareful:
     *         - Khi xây dựng hoán vị, ta chỉ chọn một số tiếp theo NẾU TỔNG của nó
     *         với số cuối cùng đã chọn trước đó (`lastNum`) là một số chính phương.
     *         5. Khi hoán vị đạt đủ tổ chiều dài của mảng (`pCount ==
     *         nums.length`), ta tăng biến đếm `count`.
     */
    public int numSquarefulPerms(int[] nums) {
        count = 0;

        // Sort the array to easily handle duplicates
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];

        // Start backtracking.
        // pCount is the current length of the permutation we've built.
        // lastNum is the last element we added to the permutation.
        backtrack(nums, used, 0, -1);

        return count;
    }

    private void backtrack(int[] nums, boolean[] used, int pCount, int lastNum) {
        // Base case: we have formed a valid permutation of length N
        if (pCount == nums.length) {
            count++;
            return;
        }

        // Try adding each element to the permutation
        for (int i = 0; i < nums.length; i++) {
            // If already used in current permutation, skip
            if (used[i]) {
                continue;
            }

            // Skip duplicates: if this number is the same as the previous one,
            // and the previous one was NOT used, it means we already explored
            // all permutations starting with this number in this position.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // If it's not the first element, check if the sum is a perfect square
            if (pCount > 0 && !isSquare(lastNum + nums[i])) {
                continue;
            }

            // Choose the current number
            used[i] = true;
            // Explore the next level
            backtrack(nums, used, pCount + 1, nums[i]);
            // Un-choose (backtrack)
            used[i] = false;
        }
    }

    /**
     * Helper to check if a number is a perfect square.
     */
    private boolean isSquare(int val) {
        int root = (int) Math.sqrt(val);
        return root * root == val;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = { 1, 17, 8 };
        System.out.println("Result 1: " + sol.numSquarefulPerms(nums1)); // 2

        int[] nums2 = { 2, 2, 2 };
        System.out.println("Result 2: " + sol.numSquarefulPerms(nums2)); // 1
    }
}
