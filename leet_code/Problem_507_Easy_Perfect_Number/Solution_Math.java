package leet_code.Problem_507_Easy_Perfect_Number;

public class Solution_Math {

    /**
     * Checks if number is perfect.
     * Strategy: Iterate divisors up to sqrt(num).
     * Time: O(sqrt(N)), Space: O(1).
     */
    public boolean checkPerfectNumber(int num) {
        if (num <= 1)
            return false;

        int sum = 1; // 1 is always a proper divisor for num > 1

        // Loop from 2 to sqrt(num)
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
        Solution_Math solution = new Solution_Math();
        System.out.println("Result 28: " + solution.checkPerfectNumber(28)); // true
        System.out.println("Result 7: " + solution.checkPerfectNumber(7)); // false
    }
}
