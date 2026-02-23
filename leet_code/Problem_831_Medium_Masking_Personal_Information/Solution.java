package leet_code.Problem_831_Medium_Masking_Personal_Information;

public class Solution {

    /**
     * Masks personal information (Email or Phone).
     * Strategy: Detect type using '@', then apply specific formatting.
     * Time: O(L), Space: O(L).
     */
    public String maskPII(String s) {
        // Detect if it's an email
        if (s.contains("@")) {
            return maskEmail(s);
        } else {
            return maskPhone(s);
        }
    }

    private String maskEmail(String s) {
        s = s.toLowerCase();
        int atIndex = s.indexOf('@');
        StringBuilder sb = new StringBuilder();
        // Mask the name: first_char + "*****" + last_char
        sb.append(s.charAt(0))
                .append("*****")
                .append(s.charAt(atIndex - 1))
                .append(s.substring(atIndex));
        return sb.toString();
    }

    private String maskPhone(String s) {
        // Keep only the digits
        StringBuilder digits = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            }
        }

        int n = digits.length();
        String lastFour = digits.substring(n - 4);
        String local = "***-***-" + lastFour;

        // n is between 10 and 13
        if (n == 10) {
            return local;
        }

        // Internation code handling
        StringBuilder country = new StringBuilder("+");
        for (int i = 0; i < n - 10; i++) {
            country.append("*");
        }
        return country.append("-").append(local).toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.maskPII("LeetCode@LeetCode.com"));
        System.out.println("Result 2: " + sol.maskPII("86-(10)12345678"));
        System.out.println("Result 3: " + sol.maskPII("1(234)567-890"));
    }
}
