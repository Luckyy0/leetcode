package leet_code.Problem_806_Easy_Number_of_Lines_To_Write_String;

public class Solution {

    /**
     * Calculates the number of lines and the width of the last line.
     * Strategy: Iterate through string and simulate the line-wrapping rules.
     * Time: O(S), Space: O(1).
     */
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int currentWidth = 0;

        for (char c : s.toCharArray()) {
            int w = widths[c - 'a'];

            // Check if current character fits into current line
            if (currentWidth + w > 100) {
                // Not enough space, move to next line
                lines++;
                currentWidth = w;
            } else {
                // Fits, append to current line
                currentWidth += w;
            }
        }

        return new int[] { lines, currentWidth };
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] w1 = new int[26];
        for (int i = 0; i < 26; i++)
            w1[i] = 10;
        int[] res1 = sol.numberOfLines(w1, "abcdefghijklmnopqrstuvwxyz");
        System.out.println("Result 1: [" + res1[0] + ", " + res1[1] + "]"); // [3, 60]

        int[] w2 = new int[26];
        for (int i = 0; i < 26; i++)
            w2[i] = 10;
        w2[0] = 4; // 'a' = 4
        w2[1] = 10; // 'b' = 10
        // ... (example 2 details)
    }
}
