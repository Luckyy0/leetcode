package leet_code.Problem_848_Medium_Shifting_Letters;

/**
 * Problem 848: Shifting Letters
 * https://leetcode.com/problems/shifting-letters/
 */
public class Solution {

    /**
     * Shifts letters in string s based on cumulative shifts array.
     * Strategy: Iterate backwards to calculate the total shift for each character.
     * 
     * @param s      The input string.
     * @param shifts The array of shift counts for prefixes.
     * @return The resulting string.
     * 
     *         Tóm tắt chiến lược:
     *         1. Mỗi ký tự tại chỉ số i sẽ được dịch chuyển bởi shifts[i], và mọi
     *         shifts[j] với j > i (vì shifts[j] áp dụng cho tiền tố i+1 ký tự).
     *         2. Do đó, tổng số lần dịch chuyển cho s[i] là tổng các phần tử trong
     *         mảng 'shifts' từ vị trí i đến hết mảng.
     *         3. Ta duyệt ngược từ cuối mảng về đầu để tính tổng hậu tố (suffix
     *         sum)
     *         một cách hiệu quả trong O(n).
     *         4. Sử dụng biến 'runningShift' để lưu tổng lũy kế (lấy dư cho 26 để
     *         tránh tràn số).
     *         5. Cập nhật từng ký tự bằng cách dịch chuyển nó theo 'runningShift'.
     */
    public String shiftingLetters(String s, int[] shifts) {
        char[] chars = s.toCharArray();
        long runningShift = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            // Update the total shift for characters at index 0 to i
            runningShift = (runningShift + shifts[i]) % 26;

            // Calculate new character
            // (current_pos + shifts) % 26.
            int currentPos = chars[i] - 'a';
            int newPos = (int) ((currentPos + runningShift) % 26);

            chars[i] = (char) ('a' + newPos);
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] sh1 = { 3, 5, 9 };
        System.out.println("Result: " + sol.shiftingLetters("abc", sh1)); // "rpl"

        int[] sh2 = { 1, 2, 3 };
        System.out.println("Result: " + sol.shiftingLetters("aaa", sh2)); // "gfd"
    }
}
