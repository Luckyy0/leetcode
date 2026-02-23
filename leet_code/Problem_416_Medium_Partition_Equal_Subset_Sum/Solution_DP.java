package leet_code.Problem_416_Medium_Partition_Equal_Subset_Sum;

public class Solution_DP {

    /**
     * Checks if array can be partitioned into two equal sum subsets.
     * Use 0/1 Knapsack DP (Subset Sum).
     * Time: O(N * Sum), Space: O(Sum).
     * 
     * Kiểm tra xem mảng có thể chia thành hai tập con có tổng bằng nhau không.
     * Sử dụng quy hoạch động Cái túi 0/1 (Tổng tập hợp con).
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        // Sum must be even to be partitioned equally
        // Tổng phải là số chẵn mới có thể chia đều
        if (sum % 2 != 0)
            return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            // Update from right to left to avoid using same element twice
            // Cập nhật từ phải sang trái để tránh dùng cùng một phần tử hai lần
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
            // Early exit if target is reached
            if (dp[target])
                return true;
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: [1, 5, 11, 5] -> true
        System.out.println("Result [1,5,11,5]: " + solution.canPartition(new int[] { 1, 5, 11, 5 }));

        // Test Case 2: [1, 2, 3, 5] -> false
        System.out.println("Result [1,2,3,5]: " + solution.canPartition(new int[] { 1, 2, 3, 5 }));
    }
}
