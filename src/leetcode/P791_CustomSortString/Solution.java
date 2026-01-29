package leetcode.P791_CustomSortString;

class Solution {
    public String customSortString(String order, String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        // Append characters in the specified order
        // Thêm các ký tự theo thứ tự đã chỉ định
        for (char o : order.toCharArray()) {
            while (counts[o - 'a'] > 0) {
                sb.append(o);
                counts[o - 'a']--;
            }
        }

        // Append characters not in order
        // Thêm các ký tự không có trong order
        for (int i = 0; i < 26; i++) {
            while (counts[i] > 0) {
                sb.append((char) (i + 'a'));
                counts[i]--;
            }
        }

        return sb.toString();
    }
}
