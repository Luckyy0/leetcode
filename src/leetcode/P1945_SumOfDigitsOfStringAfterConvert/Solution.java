package leetcode.P1945_SumOfDigitsOfStringAfterConvert;

public class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }

        String current = sb.toString();

        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (char c : current.toCharArray()) {
                sum += (c - '0');
            }
            current = String.valueOf(sum);
        }

        return Integer.parseInt(current);
    }
}
