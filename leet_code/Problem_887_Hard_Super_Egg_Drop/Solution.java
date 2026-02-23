package leet_code.Problem_887_Hard_Super_Egg_Drop;

/**
 * Problem 887: Super Egg Drop
 * https://leetcode.com/problems/super-egg-drop/
 */
public class Solution {

    /**
     * Finds the minimum worst-case drops for K eggs and N floors.
     * Strategy: Inverted DP - maximize floors checkable with M moves.
     * 
     * @param k Number of eggs.
     * @param n Number of floors.
     * @return Minimum moves.
     * 
     *         Tóm tắt chiến lược:
     *         1. Đảo ngược vấn đề: Thay vì tìm số bước tối thiểu cho N tầng, hãy
     *         tìm
     *         số tầng tối đa có thể kiểm tra được với M bước và K quả trứng.
     *         2. Gọi dp[i] là số tầng tối đa kiểm tra được với 'm' bước (hiện tại)
     *         và 'i' quả trứng.
     *         3. Khi thực hiện thêm 1 bước (từ m-1 lên m):
     *         - Nếu quả trứng vỡ: ta đã kiểm tra được dp[i-1] tầng (với m-1 bước,
     *         i-1 trứng).
     *         - Nếu quả trứng không vỡ: ta đã kiểm tra được dp[i] tầng (với m-1
     *         bước, i trứng).
     *         - Cộng thêm 1 tầng hiện tại chúng ta đang thử.
     *         -> dp[i] (mới) = dp[i-1] (cũ) + dp[i] (cũ) + 1.
     *         4. Lặp lại việc tăng số bước 'm' cho đến khi dp[k] >= n.
     */
    public int superEggDrop(int k, int n) {
        // dp[i] stores max floors checkable with current moves and i eggs
        int[] dp = new int[k + 1];
        int m = 0;

        while (dp[k] < n) {
            m++;
            // Update dp array backwards to use values from previous step (m-1)
            for (int i = k; i >= 1; i--) {
                dp[i] = dp[i] + dp[i - 1] + 1;
            }
        }

        return m;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.superEggDrop(1, 2)); // 2
        System.out.println("Result: " + sol.superEggDrop(2, 6)); // 3
        System.out.println("Result: " + sol.superEggDrop(3, 14)); // 4
    }
}
