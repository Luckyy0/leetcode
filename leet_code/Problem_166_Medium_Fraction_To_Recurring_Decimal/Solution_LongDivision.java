package leet_code.Problem_166_Medium_Fraction_To_Recurring_Decimal;

import java.util.HashMap;
import java.util.Map;

public class Solution_LongDivision {

    /**
     * Converts a fraction to a recurring decimal string.
     * Uses Long to avoid overflow and a Map to detect repeating remainders.
     * 
     * Chuyển đổi một phân số thành chuỗi thập phân vô hạn tuần hoàn.
     * Sử dụng Long để tránh tràn số và Map để phát hiện số dư lặp lại.
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";

        StringBuilder sb = new StringBuilder();

        // Handle negative sign
        // Xử lý dấu âm
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }

        // Use long to avoid overflow for Integer.MIN_VALUE
        // Sử dụng long để tránh tràn số cho Integer.MIN_VALUE
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Integer part
        // Phần nguyên
        sb.append(num / den);
        long remainder = num % den;
        if (remainder == 0) {
            return sb.toString();
        }

        // Fractional part
        // Phần thập phân
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            // If remainder repeats, we found the recurring cycle
            // Nếu số dư lặp lại, ta đã tìm thấy chu trình tuần hoàn
            if (map.containsKey(remainder)) {
                int index = map.get(remainder);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }

            // Map current remainder to current string position
            // Lưu lại vị trí bắt đầu của số dư này trong chuỗi
            map.put(remainder, sb.length());

            remainder *= 10;
            sb.append(remainder / den);
            remainder %= den;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_LongDivision solution = new Solution_LongDivision();

        // Test Case 1: 1/2 -> "0.5"
        System.out.println("1/2 = " + solution.fractionToDecimal(1, 2));

        // Test Case 2: 2/1 -> "2"
        System.out.println("2/1 = " + solution.fractionToDecimal(2, 1));

        // Test Case 3: 4/333 -> "0.(012)"
        System.out.println("4/333 = " + solution.fractionToDecimal(4, 333));

        // Test Case 4: -50/8 -> "-6.25"
        System.out.println("-50/8 = " + solution.fractionToDecimal(-50, 8));
    }
}
