package leet_code.Problem_1_Easy_Two_Sum;

public class Solution_BruteForce {

    /**
     * Solves the Two Sum problem using Brute Force O(N^2).
     * Giải quyết bài toán Hai Số Tổng sử dụng Vét cạn O(N^2).
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        // Iterate through each element as the first number
        // Duyệt qua từng phần tử làm số thứ nhất
        for (int i = 0; i < n; i++) {

            // Iterate through the remaining elements as the second number
            // Duyệt qua các phần tử còn lại làm số thứ hai
            for (int j = i + 1; j < n; j++) {

                // Check if the sum equals the target
                // Kiểm tra xem tổng có bằng target không
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        // Return empty array if no solution is found (though problem guarantees one)
        // Trả về mảng rỗng nếu không tìm thấy giải pháp (dù đề bài đảm bảo có một giải
        // pháp)
        return new int[] {};
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_BruteForce solution = new Solution_BruteForce();

        // Test Case 1
        int[] nums1 = { 2, 7, 11, 15 };
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Test Case 1 (BruteForce): [" + (result1.length > 0 ? result1[0] : "") + ", "
                + (result1.length > 0 ? result1[1] : "") + "]");

        // Test Case 2
        int[] nums2 = { 3, 2, 4 };
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Test Case 2 (BruteForce): [" + (result2.length > 0 ? result2[0] : "") + ", "
                + (result2.length > 0 ? result2[1] : "") + "]");

        // Test Case 3
        int[] nums3 = { 3, 3 };
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Test Case 3 (BruteForce): [" + (result3.length > 0 ? result3[0] : "") + ", "
                + (result3.length > 0 ? result3[1] : "") + "]");
    }
}
