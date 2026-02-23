package leet_code.Problem_135_Hard_Candy;

import java.util.Arrays;

public class Solution_Greedy {

    /**
     * Calculates the minimum number of candies needed to satisfy neighbors.
     * Uses a two-pass greedy approach for O(N) time and O(N) space.
     * 
     * Tính toán số lượng kẹo tối thiểu cần thiết để thỏa mãn các hàng xóm.
     * Sử dụng phương pháp tham lam hai lượt với thời gian O(N) và không gian O(N).
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n <= 1)
            return n;

        int[] candies = new int[n];
        // Rule: Each child must have at least one candy.
        // Quy tắc: Mỗi đứa trẻ phải có ít nhất một viên kẹo.
        Arrays.fill(candies, 1);

        // First Pass: Left to Right
        // Lượt 1: Từ trái sang phải
        // Satisfy the condition: Child with a higher rating gets more than left
        // neighbor.
        // Thỏa mãn điều kiện: Trẻ có xếp hạng cao hơn nhận nhiều hơn hàng xóm bên trái.
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Second Pass: Right to Left
        // Lượt 2: Từ phải sang trái
        // Satisfy the condition: Child with a higher rating gets more than right
        // neighbor.
        // Thỏa mãn điều kiện: Trẻ có xếp hạng cao hơn nhận nhiều hơn hàng xóm bên phải.
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // Must ensure it's greater than right neighbor AND original left-satisfying
                // value.
                // Phải đảm bảo nó lớn hơn hàng xóm bên phải VÀ giá trị đã thỏa mãn bên trái ban
                // đầu.
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Sum up the total candies
        // Cộng tổng số kẹo
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();

        // Test Case 1: [1,0,2] -> 5
        int[] r1 = { 1, 0, 2 };
        System.out.println("Test Case 1 Total: " + solution.candy(r1));
        // Expected: 5

        // Test Case 2: [1,2,2] -> 4
        int[] r2 = { 1, 2, 2 };
        System.out.println("Test Case 2 Total: " + solution.candy(r2));
        // Expected: 4
    }
}
