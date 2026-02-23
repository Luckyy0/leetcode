package leet_code.Problem_660_Hard_Remove_9;

public class Solution_Base9 {

    /**
     * Finds the n-th element in a sequence excluding numbers with digit '9'.
     * Strategy: Decimal to Base 9 conversion.
     * Time: O(log_9 N), Space: O(log_9 N).
     */
    public int newInteger(int n) {
        // StringBuilder to collect remainders
        StringBuilder base9 = new StringBuilder();

        while (n > 0) {
            base9.append(n % 9);
            n /= 9;
        }

        // Reverse because remainders are collected from least to most significant
        return Integer.parseInt(base9.reverse().toString());
    }

    public static void main(String[] args) {
        Solution_Base9 sol = new Solution_Base9();
        System.out.println("9th number: " + sol.newInteger(9)); // 10
        System.out.println("10th number: " + sol.newInteger(10)); // 11
    }
}
