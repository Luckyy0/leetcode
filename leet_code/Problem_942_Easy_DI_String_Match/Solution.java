package leet_code.Problem_942_Easy_DI_String_Match;

/**
 * Problem 942: DI String Match
 * https://leetcode.com/problems/di-string-match/
 */
public class Solution {

    /**
     * Reconstructs the permutation based on the ID string.
     * Strategy: Greedy using Two Pointers (low and high).
     * 
     * @param s String of 'I' (increase) and 'D' (decrease).
     * @return A valid permutation of [0, n].
     * 
     *         Tóm tắt chiến lược:
     *         1. Ta cần điền các số từ 0 đến N vào mảng kết quả sao cho thỏa mãn
     *         quan hệ tăng/giảm.
     *         2. Sử dụng 2 con trỏ: `low` bắt đầu từ 0 và `high` bắt đầu từ N.
     *         3. Duyệt qua từng ký tự của chuỗi `s`:
     *         - Nếu gặp 'I' (Increase - Tăng):
     *         - Ta cần giá trị hiện tại nhỏ hơn giá trị tiếp theo.
     *         - Cách tốt nhất là chọn giá trị NHỎ NHẤT hiện có (`low`) cho vị trí
     *         này.
     *         - Vì bất kỳ giá trị nào chọn sau này cũng sẽ lớn hơn `low`, nên điều
     *         kiện tăng được đảm bảo.
     *         - Tăng `low` lên 1.
     *         - Nếu gặp 'D' (Decrease - Giảm):
     *         - Ta cần giá trị hiện tại lớn hơn giá trị tiếp theo.
     *         - Cách tốt nhất là chọn giá trị LỚN NHẤT hiện có (`high`) cho vị trí
     *         này.
     *         - Vì bất kỳ giá trị nào chọn sau này cũng sẽ nhỏ hơn `high`, nên điều
     *         kiện giảm được đảm bảo.
     *         - Giảm `high` đi 1.
     *         4. Sau khi duyệt hết chuỗi `s` (N ký tự), còn lại đúng 1 giá trị
     *         (`low` == `high`). Điền nốt vào cuối mảng.
     */
    public int[] diStringMatch(String s) {
        int n = s.length();
        int low = 0;
        int high = n;
        int[] result = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                // For 'I', pick the smallest available number
                result[i] = low++;
            } else {
                // For 'D', pick the largest available number
                result[i] = high--;
            }
        }

        // Fill the last remaining number
        result[n] = low; // at this point low should be equal to high

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] res1 = sol.diStringMatch("IDID");
        System.out.print("Result: ");
        for (int x : res1)
            System.out.print(x + " "); // Example: 0 4 1 3 2
        System.out.println();

        int[] res2 = sol.diStringMatch("III");
        System.out.print("Result: ");
        for (int x : res2)
            System.out.print(x + " "); // Example: 0 1 2 3
        System.out.println();

        int[] res3 = sol.diStringMatch("DDI");
        System.out.print("Result: ");
        for (int x : res3)
            System.out.print(x + " "); // Example: 3 2 0 1
        System.out.println();
    }
}
