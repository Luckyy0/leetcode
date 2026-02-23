package leet_code.Problem_929_Easy_Unique_Email_Addresses;

import java.util.*;

/**
 * Problem 929: Unique Email Addresses
 * https://leetcode.com/problems/unique-email-addresses/
 */
public class Solution {

    /**
     * Counts the number of unique email addresses after normalization.
     * Strategy: String Processing + HashSet.
     * 
     * @param emails Array of email strings.
     * @return Number of unique effective emails.
     * 
     *         Tóm tắt chiến lược:
     *         1. Mỗi email bao gồm `localName` và `domainName` phân cách bởi '@'.
     *         2. Xử lý `localName`:
     *         - Nếu có dấu '+', bỏ qua tất cả ký tự từ dấu '+' trở đi.
     *         - Loại bỏ tất cả dấu '.' trong phần còn lại.
     *         3. `domainName` giữ nguyên.
     *         4. Ghép `normalizedLocal` + '@' + `domainName` để tạo thành email
     *         chuẩn hóa.
     *         5. Lưu email chuẩn hóa vào HashSet để đếm số lượng email duy nhất.
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            // Split into local and domain parts
            int atIndex = email.indexOf('@');
            String local = email.substring(0, atIndex);
            String domain = email.substring(atIndex); // includes '@'

            // Rule 1: Ignore everything after the first '+'
            int plusIndex = local.indexOf('+');
            if (plusIndex != -1) {
                local = local.substring(0, plusIndex);
            }

            // Rule 2: Remove all '.' from local name
            // Note: In Java, replaceAll takes regex, replace takes literal string/char
            // replace(".", "") removes all dots.
            local = local.replace(".", "");

            // Combine and add to set
            uniqueEmails.add(local + domain);
        }

        return uniqueEmails.size();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] emails1 = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com" };
        System.out.println("Result: " + sol.numUniqueEmails(emails1)); // 2

        String[] emails2 = { "a@leetcode.com", "b@leetcode.com", "c@leetcode.com" };
        System.out.println("Result: " + sol.numUniqueEmails(emails2)); // 3
    }
}
