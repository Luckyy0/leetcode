package leet_code.Problem_937_Medium_Reorder_Data_in_Log_Files;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem 937: Reorder Data in Log Files
 * https://leetcode.com/problems/reorder-data-in-log-files/
 */
public class Solution {

    /**
     * Reorders logs according to the problem rules.
     * Strategy: Custom Comparator + Stable Sort.
     * 
     * @param logs Array of log strings.
     * @return Reordered logs.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sử dụng `Arrays.sort` với một `Comparator` tùy chỉnh.
     *         2. Phân loại mỗi nhật ký:
     *         - Tìm vị trí dấu cách đầu tiên để tách `id` và `content`.
     *         - Kiểm tra ký tự đầu tiên của `content` để xác định là "Letter-log"
     *         hay "Digit-log".
     *         3. Quy tắc so sánh:
     *         - Cả hai đều là Letter-log:
     *         - So sánh `content` trước. Nếu khác nhau, trả về kết quả so sánh.
     *         - Nếu `content` giống nhau, so sánh `id`.
     *         - Một Letter-log và một Digit-log:
     *         - Letter-log luôn nhỏ hơn (đứng trước) Digit-log.
     *         - Cả hai đều là Digit-log:
     *         - Giữ nguyên thứ tự ban đầu. Trả về 0. `Arrays.sort` trong Java là ổn
     *         định (stable), nên thứ tự tương đối sẽ được bảo toàn.
     */
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // Find the index of the first space
                int index1 = s1.indexOf(' ');
                int index2 = s2.indexOf(' ');

                // Content starts after the first space
                // Identifiers end at the first space
                String id1 = s1.substring(0, index1);
                String main1 = s1.substring(index1 + 1);

                String id2 = s2.substring(0, index2);
                String main2 = s2.substring(index2 + 1);

                // Determine type based on first character of content
                boolean isDigit1 = Character.isDigit(main1.charAt(0));
                boolean isDigit2 = Character.isDigit(main2.charAt(0));

                if (!isDigit1 && !isDigit2) {
                    // Both are letter-logs
                    int cmp = main1.compareTo(main2);
                    if (cmp != 0)
                        return cmp;
                    return id1.compareTo(id2);
                }

                // One letter-log and one digit-log
                // Letter-log comes first (is smaller)
                if (!isDigit1 && isDigit2)
                    return -1;
                if (isDigit1 && !isDigit2)
                    return 1;

                // Both are digit-logs -> keep relative order
                return 0;
            }
        });

        return logs;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] logs1 = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
        String[] res1 = sol.reorderLogFiles(logs1);
        System.out.println("Result 1: " + Arrays.toString(res1)); // ["let1 art can","let3 art zero","let2 own kit
                                                                  // dig","dig1 8 1 5 1","dig2 3 6"]

        String[] logs2 = { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo" };
        String[] res2 = sol.reorderLogFiles(logs2);
        System.out.println("Result 2: " + Arrays.toString(res2)); // ["g1 act car","a8 act zoo","ab1 off key dog","a1 9
                                                                  // 2 3 1","zo4 4 7"]
    }
}
