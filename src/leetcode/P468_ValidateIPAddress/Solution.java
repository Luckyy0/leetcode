package leetcode.P468_ValidateIPAddress;

public class Solution {

    /**
     * Problem 468: Validate IP Address
     * Approach: Rule-based Validation
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public String validIPAddress(String queryIP) {
        if (queryIP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(queryIP);
        } else if (queryIP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(queryIP);
        } else {
            return "Neither";
        }
    }

    private String validateIPv4(String ip) {
        String[] parts = ip.split("\\.", -1);
        for (String p : parts) {
            if (p.length() == 0 || p.length() > 3)
                return "Neither";
            if (p.charAt(0) == '0' && p.length() != 1)
                return "Neither";
            for (char c : p.toCharArray()) {
                if (!Character.isDigit(c))
                    return "Neither";
            }
            int val = Integer.parseInt(p);
            if (val < 0 || val > 255)
                return "Neither";
        }
        return "IPv4";
    }

    private String validateIPv6(String ip) {
        String[] parts = ip.split(":", -1);
        for (String p : parts) {
            if (p.length() == 0 || p.length() > 4)
                return "Neither";
            for (char c : p.toLowerCase().toCharArray()) {
                if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f')))
                    return "Neither";
            }
        }
        return "IPv6";
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // "172.16.254.1" -> IPv4
        runTest(sol, "172.16.254.1", "IPv4");

        // "2001:0db8:85a3:0:0:8a2e:0370:7334" -> IPv6
        runTest(sol, "2001:0db8:85a3:0:0:8a2e:0370:7334", "IPv6");

        // "256.256.256.256" -> Neither
        runTest(sol, "256.256.256.256", "Neither");

        // "1.1.1.1." -> Neither
        runTest(sol, "1.1.1.1.", "Neither");
    }

    private static void runTest(Solution sol, String ip, String expected) {
        String result = sol.validIPAddress(ip);
        System.out.println("IP: " + ip + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
