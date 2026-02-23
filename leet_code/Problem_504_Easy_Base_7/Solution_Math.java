package leet_code.Problem_504_Easy_Base_7;

public class Solution_Math {

    /**
     * Converts integer to base 7 string.
     * Strategy: Repeated modulo and division.
     * Time: O(log_7 num), Space: O(log_7 num).
     */
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        boolean negative = num < 0;

        // Use absolute value. Beware of Integer.MIN_VALUE abs overflow?
        // Integer.MIN_VALUE is -2^31. Abs is 2^31 (overflow int).
        // Standard Math.abs(Integer.MIN_VALUE) returns MIN_VALUE (negative).
        // Loop condition `while(num != 0)` handles negatives too if using `%`
        // correctly?
        // Java: -7 % 7 = 0. -8 % 7 = -1.
        // Safer to work with positive, but cast to long? Or just handle sign.
        // Let's just handle sign manually and use positive logic, treating MIN_VALUE
        // specially or just use while(num != 0) carefully.

        // Simpler: num < 0 ? "-" + helper(-num) : helper(num).
        // But -MIN_VALUE overflows.
        // Let's iterate `num` directly.
        // k = num % 7. If num < 0, k is negative e.g. -1.
        // Append abs(k).

        // Or simply:
        /*
         * int x = Math.abs(num); // Fails for MIN_VALUE
         */

        // Correct approach without Long:
        // Use `while (num != 0)`
        // `int rem = num % 7`
        // `num /= 7`
        // Append `Math.abs(rem)`
        // If initial num was negative, prepend "-".

        boolean isNeg = num < 0;

        while (num != 0) {
            sb.append(Math.abs(num % 7));
            num /= 7;
        }

        if (isNeg) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();
        System.out.println("Result 100: " + solution.convertToBase7(100)); // "202"
        System.out.println("Result -7: " + solution.convertToBase7(-7)); // "-10"
    }
}
