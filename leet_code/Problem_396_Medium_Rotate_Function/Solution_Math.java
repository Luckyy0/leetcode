package leet_code.Problem_396_Medium_Rotate_Function;

public class Solution_Math {

    /**
     * Finds the maximum value of the rotation function.
     * Use a mathematical transition formula: F(k) = F(k-1) + sum - n * A[n-k].
     * Time: O(N), Space: O(1).
     * 
     * Tìm giá trị lớn nhất của hàm xoay.
     * Sử dụng công thức toán học: F(k) = F(k-1) + sum - n * A[n-k].
     */
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long F = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            F += (long) i * nums[i];
        }

        long maxF = F;

        // Loop from the last possible rotation
        // Lặp từ lần xoay cuối cùng có thể
        for (int i = n - 1; i > 0; i--) {
            F = F + sum - (long) n * nums[i];
            maxF = Math.max(maxF, F);
        }

        return (int) maxF;
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();

        // Test Case 1: [4,3,2,6] -> 26
        System.out.println("Result 1: " + solution.maxRotateFunction(new int[] { 4, 3, 2, 6 }));

        // Test Case 2: [100] -> 0
        System.out.println("Result 2: " + solution.maxRotateFunction(new int[] { 100 }));
    }
}
