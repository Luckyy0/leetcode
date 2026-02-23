package leet_code.Problem_709_Easy_To_Lower_Case;

public class Solution {

    /**
     * Converts a string to lower case by manipulating ASCII values.
     * Time: O(N), Space: O(N).
     */
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            // Check if char is uppercase
            if (c >= 'A' && c <= 'Z') {
                // Add 32 to convert to lowercase
                sb.append((char) (c + 32));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.toLowerCase("Hello")); // hello
        System.out.println(sol.toLowerCase("LOVELY")); // lovely
    }
}
