package leet_code.Problem_152_Medium_Maximum_Product_Subarray;

public class Solution_DP {

    /**
     * Finds the contiguous subarray with the largest product.
     * Uses Dynamic Programming with O(N) time and O(1) space.
     * 
     * Tìm dãy con liên tiếp có tích lớn nhất.
     * Sử dụng Quy hoạch động với thời gian O(N) và không gian O(1).
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int globalMax = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // If the number is negative, max and min will swap after multiplication
            // Nếu là số âm, max và min sẽ hoán đổi vị trí sau khi nhân
            if (num < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            // At each step, we decide whether to start a new subarray at num
            // or continue the existing product sequence
            // Tại mỗi bước, ta quyết định bắt đầu dãy con mới tại num
            // hoặc tiếp tục chuỗi tích hiện có
            currentMax = Math.max(num, currentMax * num);
            currentMin = Math.min(num, currentMin * num);

            globalMax = Math.max(globalMax, currentMax);
        }

        return globalMax;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: [2,3,-2,4] -> 6
        int[] n1 = { 2, 3, -2, 4 };
        System.out.println("Test Case 1: " + solution.maxProduct(n1));

        // Test Case 2: [-2,0,-1] -> 0
        int[] n2 = { -2, 0, -1 };
        System.out.println("Test Case 2: " + solution.maxProduct(n2));

        // Test Case 3: [-2, 3, -4] -> 24
        int[] n3 = { -2, 3, -4 };
        System.out.println("Test Case 3: " + solution.maxProduct(n3));
    }
}
