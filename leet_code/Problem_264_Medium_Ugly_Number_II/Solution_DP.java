package leet_code.Problem_264_Medium_Ugly_Number_II;

public class Solution_DP {

    /**
     * Finds the nth ugly number.
     * Uses Dynamic Programming with Three Pointers.
     * Time: O(N), Space: O(N).
     * 
     * Tìm số xấu thứ n.
     * Sử dụng Quy hoạch động với Ba con trỏ.
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        int p2 = 0, p3 = 0, p5 = 0;

        for (int i = 1; i < n; i++) {
            int next2 = dp[p2] * 2;
            int next3 = dp[p3] * 3;
            int next5 = dp[p5] * 5;

            int min = Math.min(next2, Math.min(next3, next5));
            dp[i] = min;

            // Increment pointers. Note: use if, not else if, to handle duplicates (e.g. 6 =
            // 2*3 = 3*2)
            // Tăng con trỏ. Lưu ý: dùng if, không dùng else if, để xử lý trùng lặp
            if (min == next2)
                p2++;
            if (min == next3)
                p3++;
            if (min == next5)
                p5++;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: n = 10 -> 12
        System.out.println("Ugly 10: " + solution.nthUglyNumber(10));

        // Test Case 2: n = 1 -> 1
        System.out.println("Ugly 1: " + solution.nthUglyNumber(1));
    }
}
