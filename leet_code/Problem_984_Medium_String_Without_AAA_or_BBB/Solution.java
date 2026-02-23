package leet_code.Problem_984_Medium_String_Without_AAA_or_BBB;

/**
 * Problem 984: String Without AAA or BBB
 * https://leetcode.com/problems/string-without-aaa-or-bbb/
 */
public class Solution {

    /**
     * Constructs a string without "aaa" or "bbb" using given counts of 'a' and 'b'.
     * Strategy: Greedy Construction.
     * 
     * @param a Count of 'a'.
     * @param b Count of 'b'.
     * @return Constructed string.
     * 
     *         Tóm tắt chiến lược:
     *         1. Xây dựng chuỗi từng ký tự một (tham lam). Tại mỗi bước, ta quyết
     *         định viết 'a' hay 'b'.
     *         2. Nếu hai ký tự cuối cùng của chuỗi đang xây dựng đều là 'a', ta BẮT
     *         BUỘC phải viết 'b' để tránh "aaa".
     *         3. Ngược lại, nếu hai ký tự cuối cùng đều là 'b', ta BẮT BUỘC phải
     *         viết 'a' để tránh "bbb".
     *         4. Nếu ta không bị bắt buộc (ví dụ: các ký tự trước đó là "ab" hoặc
     *         chuỗi còn đang trống),
     *         ta tự do chọn ký tự nào có số lượng còn lại NHIỀU HƠN để đảm bảo
     *         không bị cạn kiệt quá sớm, dẫn đến việc bị ép chọn liên tục vào lúc
     *         cuối.
     *         - Nếu `a >= b`, ưu tiên chọn 'a'.
     *         - Nếu `b > a`, ưu tiên chọn 'b'.
     *         5. Giảm `a` hoặc `b` tương ứng sau khi viết.
     */
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();

        while (a > 0 || b > 0) {
            int len = sb.length();
            boolean writeA;

            // Check if we are FORCED to write the opposite character to avoid three in a
            // row
            if (len >= 2 && sb.charAt(len - 1) == sb.charAt(len - 2)) {
                // If last two were 'b', we must write 'a'
                // If last two were 'a', we must write 'b'
                writeA = (sb.charAt(len - 1) == 'b');
            } else {
                // Not forced, so rationally choose the character with more remaining counts
                writeA = (a >= b);
            }

            // Append chosen character and decrement count
            if (writeA) {
                sb.append('a');
                a--;
            } else {
                sb.append('b');
                b--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result (a=1, b=2): " + sol.strWithout3a3b(1, 2)); // expected "abb" or similar
        System.out.println("Result (a=4, b=1): " + sol.strWithout3a3b(4, 1)); // expected "aabaa"
    }
}
