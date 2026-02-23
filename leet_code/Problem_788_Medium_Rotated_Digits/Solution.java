package leet_code.Problem_788_Medium_Rotated_Digits;

public class Solution {

    /**
     * Counts Good numbers up to N.
     * Strategy: Check every number individually. Digits 3,4,7 invalid. 2,5,6,9
     * cause change.
     * Time: O(N log N), Space: O(1).
     */
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isValid(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isValid(int x) {
        boolean validFound = false;

        while (x > 0) {
            int d = x % 10;
            if (d == 3 || d == 4 || d == 7) {
                return false; // Contains invalid digit
            }
            if (d == 2 || d == 5 || d == 6 || d == 9) {
                validFound = true; // Contains digit that rotates to something different
            }
            x /= 10;
        }

        // Must contain at least one changing digit (2, 5, 6, 9)
        // AND no invalid digits (3, 4, 7) - (handled by return false above)
        return validFound;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.rotatedDigits(10)); // 4
        System.out.println("Result 2: " + sol.rotatedDigits(1)); // 0
        System.out.println("Result 3: " + sol.rotatedDigits(2)); // 1
    }
}
