package leet_code.Problem_553_Medium_Optimal_Division;

public class Solution_Math {

    /**
     * Finds the optimal division to maximize result.
     * Strategy: x1 / (x2 / x3 / ... / xn).
     * Time: O(N), Space: O(N).
     */
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return String.valueOf(nums[0]);
        if (n == 2)
            return nums[0] + "/" + nums[1];

        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append("/(").append(nums[1]);
        for (int i = 2; i < n; i++) {
            sb.append("/").append(nums[i]);
        }
        sb.append(")");

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();
        int[] nums = { 1000, 100, 10, 2 };
        System.out.println("Result: " + solution.optimalDivision(nums)); // 1000/(100/10/2)
    }
}
