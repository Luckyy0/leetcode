package leet_code.Problem_12_Medium_Integer_To_Roman;

public class Solution_Greedy {

    /**
     * Converts an integer to a Roman numeral.
     * Uses Greedy approach with predefined mappings.
     * Chuyển đổi một số nguyên thành số La Mã.
     * Sử dụng phương pháp Tham lam với các ánh xạ định trước.
     */
    public String intToRoman(int num) {
        // Arrays of values and their corresponding Roman symbols (including subtractive
        // pairs)
        // Mảng các giá trị và ký hiệu La Mã tương ứng (bao gồm cả các cặp phép trừ)
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder sb = new StringBuilder();

        // Loop through each value from largest to smallest
        // Duyệt qua từng giá trị từ lớn nhất đến nhỏ nhất
        for (int i = 0; i < values.length; i++) {
            // While the current number is greater than or equal to the value
            // Trong khi số hiện tại lớn hơn hoặc bằng giá trị
            while (num >= values[i]) {
                // Determine how many times this symbol fits (optimization: could use division,
                // but subtraction is clearer for loop)
                // Actually simple subtraction loop is standard for this problem as max repeat
                // is 3
                // Xác định số lần ký hiệu này phù hợp (tối ưu: có thể dùng phép chia, nhưng
                // phép trừ rõ ràng hơn cho vòng lặp)
                // Thực tế vòng lặp trừ đơn giản là chuẩn cho bài này vì lặp lại tối đa là 3
                num -= values[i];
                sb.append(symbols[i]);
            }
        }

        return sb.toString();
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();

        // Test Case 1
        int n1 = 3;
        System.out.println("Test Case 1: " + solution.intToRoman(n1));
        // Expected: "III"

        // Test Case 2
        int n2 = 4;
        System.out.println("Test Case 2: " + solution.intToRoman(n2));
        // Expected: "IV"

        // Test Case 3
        int n3 = 58;
        System.out.println("Test Case 3: " + solution.intToRoman(n3));
        // Expected: "LVIII"

        // Test Case 4
        int n4 = 1994;
        System.out.println("Test Case 4: " + solution.intToRoman(n4));
        // Expected: "MCMXCIV"
    }
}
