package leetcode.P507_PerfectNumber;

public class Solution {

    /**
     * Problem 507: Perfect Number
     * Approach: O(sqrt(N)) divisor summation
     * 
     * Time Complexity: O(sqrt(N))
     * Space Complexity: O(1)
     */
    public boolean checkPerfectNumber(int num) {
        if (num <= 1)
            return false;

        int sum = 1; // 1 is always a proper divisor
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }

        return sum == num;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 28 -> true (1 + 2 + 4 + 7 + 14 = 28)
        System.out.println("Result 28: " + sol.checkPerfectNumber(28));

        // 6 -> true (1 + 2 + 3 = 6)
        System.out.println("Result 6: " + sol.checkPerfectNumber(6));

        // 7 -> false
        System.out.println("Result 7: " + sol.checkPerfectNumber(7));
    }
}
