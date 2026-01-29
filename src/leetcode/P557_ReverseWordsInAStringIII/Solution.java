package leetcode.P557_ReverseWordsInAStringIII;

class Solution {
    public String reverseWords(String s) {
        char[] ca = s.toCharArray();
        int n = ca.length;
        int i = 0;

        while (i < n) {
            int j = i;
            // Find end of word
            // Tìm kết thúc của từ
            while (j < n && ca[j] != ' ') {
                j++;
            }

            // Reverse current word [i, j - 1]
            // Đảo ngược từ hiện tại
            reverse(ca, i, j - 1);

            // Move to next word
            // Di chuyển đến từ tiếp theo
            i = j + 1;
        }

        return new String(ca);
    }

    private void reverse(char[] ca, int i, int j) {
        while (i < j) {
            char temp = ca[i];
            ca[i++] = ca[j];
            ca[j--] = temp;
        }
    }
}
