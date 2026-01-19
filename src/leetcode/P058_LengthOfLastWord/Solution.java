package leetcode.P058_LengthOfLastWord;

public class Solution {

    /**
     * Problem 58: Length of Last Word
     * Approach: Backwards Scan
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count characters of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "Hello World", 5);
        runTest(solution, "   fly me   to   the moon  ", 4);
        runTest(solution, "luffy is still joyboy", 6);
    }

    private static void runTest(Solution s, String str, int expected) {
        System.out.println("Input: \"" + str + "\"");
        int result = s.lengthOfLastWord(str);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
