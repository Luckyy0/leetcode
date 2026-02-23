package leet_code.Problem_238_Medium_Product_Of_Array_Except_Self;

import java.util.Arrays;

public class Solution_LeftRight {

    /**
     * Calculates product of array except self.
     * Uses Two Passes logic to achieve O(N) time and O(1) extra space.
     * 
     * Tính tích của mảng ngoại trừ chính nó.
     * Sử dụng logic Hai lượt quét để đạt thời gian O(N) và không gian phụ O(1).
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Pass 1: Calculate prefix products (left to right)
        // Lượt 1: Tính tích tiền tố (trái sang phải)
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            // answer[i] contains product of nums[0...i-1]
            // answer[i] chứa tích của nums[0...i-1]
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Pass 2: Calculate suffix products (right to left) and multiply
        // Lượt 2: Tính tích hậu tố (phải sang trái) và nhân vào
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            // Multiply the prefix product (already in answer[i]) with suffix product
            // Nhân tích tiền tố (đã có trong answer[i]) với tích hậu tố
            answer[i] = answer[i] * right;

            // Update suffix product for the next iteration
            // Cập nhật tích hậu tố cho lần lặp tiếp theo
            right = right * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_LeftRight solution = new Solution_LeftRight();

        // Test Case 1: [1,2,3,4] -> [24,12,8,6]
        int[] n1 = { 1, 2, 3, 4 };
        System.out.println("Product 1: " + Arrays.toString(solution.productExceptSelf(n1)));

        // Test Case 2: [-1,1,0,-3,3] -> [0,0,9,0,0]
        int[] n2 = { -1, 1, 0, -3, 3 };
        System.out.println("Product 2: " + Arrays.toString(solution.productExceptSelf(n2)));
    }
}
