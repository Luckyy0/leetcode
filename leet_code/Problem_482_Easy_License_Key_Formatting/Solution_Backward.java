package leet_code.Problem_482_Easy_License_Key_Formatting;

public class Solution_Backward {

    /**
     * Refomats the license key.
     * Strategy: Iterate backwards, ignore dashes, convert case, insert dash every k
     * chars.
     * Time: O(N), Space: O(N) for result.
     */
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '-')
                continue;

            // Insert dash if we completed a group of k previously
            if (count > 0 && count % k == 0) {
                sb.append('-');
            }

            sb.append(Character.toUpperCase(c));
            count++;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution_Backward solution = new Solution_Backward();
        System.out.println("Result 1: " + solution.licenseKeyFormatting("5F3Z-2e-9-w", 4)); // "5F3Z-2E9W"
        System.out.println("Result 2: " + solution.licenseKeyFormatting("2-5g-3-J", 2)); // "2-5G-3J"
    }
}
