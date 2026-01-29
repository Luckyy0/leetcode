package leetcode.P443_StringCompression;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 443: String Compression
     * Approach: Two Pointers (In-place)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int compress(char[] chars) {
        int write = 0;
        int read = 0;

        while (read < chars.length) {
            char currChar = chars[read];
            int count = 0;

            // Count occurrences
            while (read < chars.length && chars[read] == currChar) {
                read++;
                count++;
            }

            // Write character
            chars[write++] = currChar;

            // Write count if > 1
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char digit : countStr.toCharArray()) {
                    chars[write++] = digit;
                }
            }
        }

        return write;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // ["a","a","b","b","c","c","c"] -> 6 (["a","2","b","2","c","3"])
        char[] chars1 = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        runTest(sol, chars1, 6, new char[] { 'a', '2', 'b', '2', 'c', '3' });

        // ["a"] -> 1 (["a"])
        char[] chars2 = { 'a' };
        runTest(sol, chars2, 1, new char[] { 'a' });

        // ["a","b","b","b","b","b","b","b","b","b","b","b","b"] -> 4
        // (["a","b","1","2"])
        char[] chars3 = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
        runTest(sol, chars3, 4, new char[] { 'a', 'b', '1', '2' });
    }

    private static void runTest(Solution sol, char[] chars, int expectedLen, char[] expectedChars) {
        int originalLen = chars.length;
        int resultLen = sol.compress(chars);
        System.out.println("Result length: " + resultLen + " (Expected: " + expectedLen + ")");

        boolean charsMatch = true;
        for (int i = 0; i < expectedLen; i++) {
            if (chars[i] != expectedChars[i]) {
                charsMatch = false;
                break;
            }
        }

        if (resultLen == expectedLen && charsMatch) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Actual Chars: " + Arrays.toString(Arrays.copyOf(chars, resultLen)));
            System.out.println("Expected Chars: " + Arrays.toString(expectedChars));
        }
        System.out.println("-----------------");
    }
}
