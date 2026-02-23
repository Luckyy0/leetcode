package leet_code.Problem_777_Medium_Swap_Adjacent_in_LR_String;

public class Solution {

    /**
     * Checks if start string can transform to end string.
     * Strategy: Two pointers. Compare non-X characters and their positions.
     * Time: O(N), Space: O(1).
     */
    public boolean canTransform(String start, String end) {
        int n = start.length();
        if (n != end.length()) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (i < n || j < n) {
            // Skip 'X' in start string
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }

            // Skip 'X' in end string
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }

            // If one string exhausted but other isn't (meaning it has non-X chars left)
            // Or both exhausted successfully (i==n && j==n)
            if (i == n || j == n) {
                return i == j;
            }

            // Current non-X characters must match
            if (start.charAt(i) != end.charAt(j)) {
                return false;
            }

            // 'L' can only move left: index in start (i) must be >= index in end (j)
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }

            // 'R' can only move right: index in start (i) must be <= index in end (j)
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = "RXXLRXRXL";
        String e1 = "XRLXXRRLX";
        System.out.println("Result 1: " + sol.canTransform(s1, e1)); // true

        String s2 = "X";
        String e2 = "L";
        System.out.println("Result 2: " + sol.canTransform(s2, e2)); // false
    }
}
