package leetcode.P670_MaximumSwap;

class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] last = new int[10];

        // Store the last occurrence index of each digit
        // Lưu trữ chỉ số xuất hiện cuối cùng của mỗi chữ số
        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            // Check for a larger digit appearing later
            // Kiểm tra xem có chữ số lớn hơn xuất hiện sau không
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {
                    // Swap and return result
                    // Hoán đổi và trả về kết quả
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }
}
