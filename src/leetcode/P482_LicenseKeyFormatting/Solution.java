package leetcode.P482_LicenseKeyFormatting;

public class Solution {

    /**
     * Problem 482: License Key Formatting
     * Approach: Right-to-Left processing with StringBuilder
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public String reformatLicenseKey(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != '-') {
                if (count > 0 && count % k == 0) {
                    sb.append('-');
                }
                sb.append(Character.toUpperCase(c));
                count++;
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // "5F3Z-2e-9-w", 4 -> "5F3Z-2E9W"
        System.out.println("Result: " + sol.reformatLicenseKey("5F3Z-2e-9-w", 4));

        // "2-5g-3-J", 2 -> "2-5G-3J"
        System.out.println("Result: " + sol.reformatLicenseKey("2-5g-3-J", 2));
    }
}
