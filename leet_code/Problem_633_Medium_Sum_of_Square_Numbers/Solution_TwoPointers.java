package leet_code.Problem_633_Medium_Sum_of_Square_Numbers;

public class Solution_TwoPointers {

    /**
     * Decides whether there are two integers a and b such that a^2 + b^2 = c.
     * Strategy: Two pointers from 0 to sqrt(c).
     * Time: O(sqrt(c)), Space: O(1).
     */
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);

        while (left <= right) {
            long currentSum = left * left + right * right;

            if (currentSum == c) {
                return true;
            } else if (currentSum < c) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_TwoPointers sol = new Solution_TwoPointers();
        System.out.println("Result for 5: " + sol.judgeSquareSum(5)); // true
        System.out.println("Result for 3: " + sol.judgeSquareSum(3)); // false
    }
}
