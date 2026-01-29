package leetcode.P686_RepeatedStringMatch;

class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int count = 1;

        // Repeat until length is enough to cover b
        // Lặp lại cho đến khi độ dài đủ để bao phủ b
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        if (sb.indexOf(b) != -1)
            return count;

        // Append one more time just in case b is split across boundaries
        // Thêm một lần nữa đề phòng trường hợp b bị chia cắt qua các ranh giới
        if (sb.append(a).indexOf(b) != -1)
            return count + 1;

        return -1;
    }
}
