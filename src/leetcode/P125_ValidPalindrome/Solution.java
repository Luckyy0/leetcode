package leetcode.P125_ValidPalindrome;

public class Solution {

    /**
     * Problem 125: Valid Palindrome
     * Approach: Two Pointers
     * 
     * Theoretical Basis:
     * - Palindrome reads same forward and backward
     * - Only consider alphanumeric characters, ignore case
     * - Two pointers from both ends, skip non-alphanumeric
     * - Compare characters in lowercase
     * 
     * Time Complexity: O(N) - each character visited at most once
     * Space Complexity: O(1) - only pointers used
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: "A man, a plan, a canal: Panama" -> true
        runTest(solution, "A man, a plan, a canal: Panama", true);

        // Test 2: "race a car" -> false
        runTest(solution, "race a car", false);

        // Test 3: " " -> true
        runTest(solution, " ", true);

        // Test 4: "0P" -> false
        runTest(solution, "0P", false);
    }

    private static void runTest(Solution s, String str, boolean expected) {
        boolean result = s.isPalindrome(str);
        System.out.println("Input: \"" + str + "\"");
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
