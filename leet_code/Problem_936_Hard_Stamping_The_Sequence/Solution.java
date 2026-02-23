package leet_code.Problem_936_Hard_Stamping_The_Sequence;

import java.util.*;

/**
 * Problem 936: Stamping The Sequence
 * https://leetcode.com/problems/stamping-the-sequence/
 */
public class Solution {

    /**
     * Determines the sequence of stamp indices to transform s into target.
     * Strategy: Reverse Thinking + Greedy.
     * 
     * @param stamp  The stamp string.
     * @param target The target string.
     * @return Array of indices to stamp in order.
     * 
     *         Tóm tắt chiến lược:
     *         1. Tư duy ngược: Thay vì cố gắng đóng dấu lên chuỗi `?????` để đạt
     *         được `target`,
     *         ta sẽ thử "gỡ" dấu ra khỏi `target` để biến nó thành `?????`.
     *         2. Nếu một vị trí trong `target` khớp với `stamp` (trong đó `?` là ký
     *         tự đại diện khớp với mọi thứ),
     *         ta có thể coi đó là dấu ĐƯỢC ĐÓNG CUỐI CÙNG tại vị trí đó.
     *         3. Khi "gỡ" dấu, ta biến các ký tự tương ứng trong `target` thành
     *         `?`.
     *         4. Lặp lại quá trình tìm kiếm các vị trí khớp cho đến khi toàn bộ
     *         `target` biến thành `?????`.
     *         5. Thứ tự các chỉ số tìm được chính là thứ tự GỠ dấu (tức là thứ tự
     *         NGƯỢC của việc ĐÓNG dấu).
     *         6. Do đó, kết quả trả về sẽ là danh sách các chỉ số tìm được theo thứ
     *         tự ngược lại.
     */
    public int[] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        int m = s.length;
        int n = t.length;

        List<Integer> reverseOrder = new ArrayList<>();
        boolean[] visited = new boolean[n - m + 1];

        int stars = 0; // Count of '?' in target

        while (stars < n) {
            boolean replacedAtPosition = false;

            // Try to match stamp at every possible position
            for (int i = 0; i <= n - m; i++) {
                if (!visited[i] && canMatch(t, i, s)) {
                    int newStars = replace(t, i, m);
                    if (newStars > 0) {
                        stars += newStars;
                        replacedAtPosition = true;
                        visited[i] = true;
                        reverseOrder.add(i);

                        if (stars == n)
                            break; // Optimization: early exit if fully processed
                    }
                }
            }

            // If we completed a full pass without replacing any characters, we are stuck.
            // This means it's impossible to stamp the target.
            if (!replacedAtPosition) {
                return new int[0];
            }
        }

        // Construct the result array by reversing the collected indices
        int[] result = new int[reverseOrder.size()];
        for (int i = 0; i < reverseOrder.size(); i++) {
            result[i] = reverseOrder.get(reverseOrder.size() - 1 - i);
        }

        return result;
    }

    /**
     * Checks if the stamp can match the target substring starting at pos.
     * '?' in target acts as a wildcard.
     * Returns true if match is possible AND at least one character in target is not
     * '?'
     * (to avoid infinite processing of already-stamped regions).
     */
    private boolean canMatch(char[] t, int pos, char[] s) {
        // Optimizing: If we are matching entirely against '?', we don't need to process
        // this again
        // However, visited array handles skipping processed indices.
        // We just need standard pattern matching logic where t[pos+i] == '?' is
        // allowed.
        for (int i = 0; i < s.length; i++) {
            if (t[pos + i] != '?' && t[pos + i] != s[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Replaces characters in target with '?' for length len starting at pos.
     * Returns the count of NEW characters turned into '?'.
     */
    private int replace(char[] t, int pos, int len) {
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (t[pos + i] != '?') {
                t[pos + i] = '?';
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] res1 = sol.movesToStamp("abc", "ababc");
        System.out.print("Result: ");
        for (int x : res1)
            System.out.print(x + " "); // [0, 2]
        System.out.println();

        int[] res2 = sol.movesToStamp("abca", "aabcaca");
        System.out.print("Result: ");
        for (int x : res2)
            System.out.print(x + " "); // [3, 0, 1]
        System.out.println();
    }
}
