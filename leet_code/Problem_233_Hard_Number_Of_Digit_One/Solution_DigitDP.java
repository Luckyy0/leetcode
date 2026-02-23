package leet_code.Problem_233_Hard_Number_Of_Digit_One;

public class Solution_DigitDP {

    /**
     * Counts the total number of digit 1 in numbers <= n.
     * Uses Mathematical counting position by position.
     * Time: O(log N), Space: O(1).
     * 
     * Đếm tổng số chữ số 1 trong các số <= n.
     * Sử dụng phương pháp đếm toán học theo từng vị trí.
     */
    public int countDigitOne(int n) {
        int count = 0;

        // Iterate through each digit position: 1s, 10s, 100s...
        // Use long for 'i' to prevent overflow when i * 10 > Integer.MAX_VALUE
        // Duyệt qua từng vị trí chữ số: hàng đơn vị, hàng chục, hàng trăm...
        // Sử dụng long cho 'i' để tránh tràn số khi i * 10 > Integer.MAX_VALUE
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;

            // Calculate parts
            long high = n / divider;
            long low = n % i;
            long currentDigit = (n / i) % 10;

            if (currentDigit == 0) {
                // Case 0: Contributed only by higher digits
                // Trường hợp 0: Chỉ đóng góp bởi các chữ số cao
                count += high * i;
            } else if (currentDigit == 1) {
                // Case 1: Higher digits full blocks + part of current block
                // Trường hợp 1: Các khối đầy đủ từ chữ số cao + một phần khối hiện tại
                count += high * i + (low + 1);
            } else {
                // Case > 1: Higher digits full blocks + current block fully included
                // Trường hợp > 1: Các khối đầy đủ từ chữ số cao + khối hiện tại được bao gồm
                // hoàn toàn
                count += (high + 1) * i;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution_DigitDP solution = new Solution_DigitDP();

        // Test Case 1: 13 -> 6
        System.out.println("Count 1s in 13: " + solution.countDigitOne(13));

        // Test Case 2: 0 -> 0
        System.out.println("Count 1s in 0: " + solution.countDigitOne(0));

        // Test Case 3: 100 -> 21
        // 1-9 (1), 10-19 (11), 21..91 (8), 100 (1) = 1 + 11 + 8 + 1 = 21
        System.out.println("Count 1s in 100: " + solution.countDigitOne(100));
    }
}
