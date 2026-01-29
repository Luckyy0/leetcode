package leetcode.P2075_DecodeTheSlantedCiphertext;

public class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int len = encodedText.length();
        int cols = len / rows;
        StringBuilder sb = new StringBuilder();

        // Diagonals start at (0, k)
        for (int k = 0; k < cols; k++) {
            // Iterate diagonal
            for (int r = 0; r < rows; r++) {
                int c = k + r;
                if (c >= cols)
                    break; // Or continue? Diagram shows wrapping? No.
                // Assuming standard diagonal traversal within bounds.

                int idx = r * cols + c;
                if (idx < len) {
                    sb.append(encodedText.charAt(idx));
                }
            }
        }

        // Remove trailing spaces
        int i = sb.length() - 1;
        while (i >= 0 && sb.charAt(i) == ' ') {
            i--;
        }

        return sb.substring(0, i + 1);
    }
}
