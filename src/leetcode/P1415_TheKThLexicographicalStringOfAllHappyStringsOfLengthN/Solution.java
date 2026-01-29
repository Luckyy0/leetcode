package leetcode.P1415_TheKThLexicographicalStringOfAllHappyStringsOfLengthN;

class Solution {
    public String getHappyString(int n, int k) {
        int total = 3 * (1 << (n - 1));
        if (k > total)
            return "";

        StringBuilder sb = new StringBuilder();
        int blockSize = 1 << (n - 1);

        // Determine first char
        if (k <= blockSize) {
            sb.append('a');
        } else if (k <= 2 * blockSize) {
            sb.append('b');
            k -= blockSize;
        } else {
            sb.append('c');
            k -= 2 * blockSize;
        }

        for (int i = 1; i < n; i++) {
            blockSize /= 2;
            char last = sb.charAt(i - 1);
            char firstChoice = ' ';
            char secondChoice = ' ';

            if (last == 'a') {
                firstChoice = 'b';
                secondChoice = 'c';
            } else if (last == 'b') {
                firstChoice = 'a';
                secondChoice = 'c';
            } else {
                firstChoice = 'a';
                secondChoice = 'b';
            }

            if (k <= blockSize) {
                sb.append(firstChoice);
            } else {
                sb.append(secondChoice);
                k -= blockSize;
            }
        }

        return sb.toString();
    }
}
