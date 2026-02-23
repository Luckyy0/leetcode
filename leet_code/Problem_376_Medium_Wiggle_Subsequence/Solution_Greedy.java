package leet_code.Problem_376_Medium_Wiggle_Subsequence;

public class Solution_Greedy {

    /**
     * Finds the longest wiggle subsequence.
     * Uses Peak and Valley counting (Greedy/DP).
     * Time: O(N), Space: O(1).
     * 
     * Tìm chuỗi con hình sin dài nhất.
     * Sử dụng phương pháp đếm Đỉnh và Đáy (Tham lam/DP).
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        int up = 1;
        int down = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }

        return Math.max(up, down);
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();

        // Test Case 1: [1,7,4,9,2,5] -> 6
        System.out.println("Result 1: " + solution.wiggleMaxLength(new int[] { 1, 7, 4, 9, 2, 5 }));

        // Test Case 2: [1,17,5,10,13,15,10,5,16,8] -> 7
        System.out.println("Result 2: " + solution.wiggleMaxLength(new int[] { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }));
    }
}
