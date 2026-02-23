package leet_code.Problem_441_Easy_Arranging_Coins;

public class Solution_BinarySearch {

    /**
     * Calculates the number of complete rows in a staircase built with n coins.
     * Strategy: Binary Search for the largest k such that k*(k+1)/2 <= n.
     * Time: O(log N), Space: O(1).
     */
    public int arrangeCoins(int n) {
        long low = 0, high = n;
        while (low <= high) {
            long k = low + (high - low) / 2;
            long curr = k * (k + 1) / 2;

            if (curr == n)
                return (int) k;

            if (n < curr) {
                high = k - 1;
            } else {
                low = k + 1;
            }
        }
        return (int) high;
    }

    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();
        System.out.println("Result (n=5): " + solution.arrangeCoins(5)); // 2
        System.out.println("Result (n=8): " + solution.arrangeCoins(8)); // 3
    }
}
