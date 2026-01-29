package leetcode.P616_AddBoldTagInString;

class Solution {
    public String addBoldTag(String s, String[] words) {
        int n = s.length();
        boolean[] bold = new boolean[n];

        // Mark all intervals covered by words
        // Đánh dấu tất cả các khoảng được bao phủ bởi các từ
        for (String word : words) {
            int start = s.indexOf(word);
            while (start != -1) {
                // Mark boolean array
                for (int i = start; i < start + word.length(); i++) {
                    bold[i] = true;
                }
                // Find next occurrence starting from start + 1
                // (allowing overlaps like "aaa" with "aa" -> indices 0,1,2 all bold)
                start = s.indexOf(word, start + 1);
            }
        }

        // Build result string
        // Xây dựng chuỗi kết quả
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // Start of a bold segment
            if (bold[i] && (i == 0 || !bold[i - 1])) {
                sb.append("<b>");
            }

            sb.append(s.charAt(i));

            // End of a bold segment
            if (bold[i] && (i == n - 1 || !bold[i + 1])) {
                sb.append("</b>");
            }
        }

        return sb.toString();
    }
}
