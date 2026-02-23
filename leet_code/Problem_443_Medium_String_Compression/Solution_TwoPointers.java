package leet_code.Problem_443_Medium_String_Compression;

public class Solution_TwoPointers {

    /**
     * Compresses the characters in chars in-place.
     * Strategy: Use a write pointer (res) and a read pointer (i) to count groups.
     * Time: O(n), Space: O(1).
     */
    public int compress(char[] chars) {
        int res = 0; // write pointer
        int i = 0; // read pointer

        while (i < chars.length) {
            char curr = chars[i];
            int count = 0;

            // Count consecutive characters
            while (i < chars.length && chars[i] == curr) {
                i++;
                count++;
            }

            // Write character
            chars[res++] = curr;

            // If count > 1, write the digits of count
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[res++] = c;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();
        char[] chars1 = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        System.out.println("Result 1: " + solution.compress(chars1)); // 6

        char[] chars2 = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
        System.out.println("Result 2: " + solution.compress(chars2)); // 4
    }
}
