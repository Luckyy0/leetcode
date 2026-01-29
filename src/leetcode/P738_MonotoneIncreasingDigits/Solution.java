package leetcode.P738_MonotoneIncreasingDigits;

class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int marker = digits.length;

        // Scan right to left for violations
        // Quét từ phải sang trái để tìm vi phạm
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i - 1] > digits[i]) {
                digits[i - 1]--;
                marker = i;
            }
        }

        // Fill all digits from marker to end with 9
        // Điền tất cả các chữ số từ vị trí đánh dấu đến hết với số 9
        for (int i = marker; i < digits.length; i++) {
            digits[i] = '9';
        }

        return Integer.parseInt(new String(digits));
    }
}
