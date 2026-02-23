package leet_code.Problem_468_Medium_Validate_IP_Address;

public class Solution_Parsing {

    /**
     * Validates if a string is a valid IPv4 or IPv6 address.
     * Strategy: Split string by delimiters and validate each chunk.
     * Time: O(N), Space: O(N).
     */
    public String validIPAddress(String queryIP) {
        if (queryIP == null)
            return "Neither";

        // Use -1 limit to keep trailing empty strings like "1.1.1.1."
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
        if (parts.length != 4)
            return "Neither";

        for (String part : parts) {
            // Check length: 1 to 3
            if (part.length() == 0 || part.length() > 3)
                return "Neither";

            // Check leading zero: length > 1 and starts with '0'
            if (part.length() > 1 && part.charAt(0) == '0')
                return "Neither";

            // Check digits and numeric range
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c))
                    return "Neither";
            }

            try {
                int val = Integer.parseInt(part);
                if (val < 0 || val > 255)
                    return "Neither";
            } catch (NumberFormatException e) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    private String validateIPv6(String ip) {
        String[] parts = ip.split(":", -1);
        if (parts.length != 8)
            return "Neither";

        for (String part : parts) {
            // Check length: 1 to 4
            if (part.length() == 0 || part.length() > 4)
                return "Neither";

            // Check hex digits
            for (char c : part.toCharArray()) {
                boolean isDigit = Character.isDigit(c);
                boolean isHexUpper = (c >= 'A' && c <= 'F');
                boolean isHexLower = (c >= 'a' && c <= 'f');
                if (!(isDigit || isHexUpper || isHexLower))
                    return "Neither";
            }
        }
        return "IPv6";
    }

    public static void main(String[] args) {
        Solution_Parsing solution = new Solution_Parsing();
        System.out.println("Result 1: " + solution.validIPAddress("172.16.254.1")); // IPv4
        System.out.println("Result 2: " + solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334")); // IPv6
        System.out.println("Result 3: " + solution.validIPAddress("256.256.256.256")); // Neither
    }
}
