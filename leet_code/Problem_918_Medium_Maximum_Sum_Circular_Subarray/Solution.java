package leet_code.Problem_918_Medium_Maximum_Sum_Circular_Subarray;

/**
 * Problem 918: Maximum Sum Circular Subarray
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 */
public class Solution {

    /**
     * Finds the maximum sum of a circular subarray.
     * Strategy: Kadane's Algorithm for both Max and Min.
     * 
     * @param nums Circular integer array.
     * @return Maximum possible sum.
     * 
     *         Tóm tắt chiến lược:
     *         1. Một mảng con vòng tròn có thể nằm trọn trong mảng (như mảng
     *         thường)
     *         hoặc vắt qua biên (gồm phần cuối và phần đầu).
     *         2. Trường hợp 1: Sử dụng thuật toán Kadane để tìm tổng mảng con lớn
     *         nhất (maxSum).
     *         3. Trường hợp 2: Tổng mảng con bao quanh = Tổng toàn mảng - Tổng mảng
     *         con nhỏ nhất ở giữa.
     *         Sử dụng Kadane đảo ngược (tìm min) để tìm tổng mảng con nhỏ nhất
     *         (minSum).
     *         4. Kết quả là max(maxSum, totalSum - minSum).
     *         5. Trường hợp đặc biệt: Nếu tất cả các số đều âm, maxSum sẽ là số lớn
     *         nhất (tức là số âm nhỏ nhất),
     *         trong khi (totalSum - minSum) sẽ là 0 (vì minSum = totalSum).
     *         Trong trường hợp này, ta phải trả về maxSum.
     */
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = nums[0];
        int currMax = 0;
        int minSum = nums[0];
        int currMin = 0;

        for (int num : nums) {
            // Kadane's for Max Subarray Sum
            currMax = Math.max(currMax + num, num);
            maxSum = Math.max(maxSum, currMax);

            // Kadane's for Min Subarray Sum
            currMin = Math.min(currMin + num, num);
            minSum = Math.min(minSum, currMin);

            totalSum += num;
        }

        // If all numbers are negative, maxSum is the maximum single element (negative).
        // In this case, circular sum logic (totalSum - minSum) would give 0 (empty
        // sub-array),
        // which is invalid as we need a non-empty subarray.
        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.maxSubarraySumCircular(new int[] { 1, -2, 3, -2 })); // 3
        System.out.println("Result: " + sol.maxSubarraySumCircular(new int[] { 5, -3, 5 })); // 10
        System.out.println("Result: " + sol.maxSubarraySumCircular(new int[] { -3, -2, -3 })); // -2
    }
}
