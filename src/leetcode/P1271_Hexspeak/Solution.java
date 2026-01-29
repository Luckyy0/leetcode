package leetcode.P1271_Hexspeak;

class Solution {
    public String toHexspeak(String num) {
        long val = Long.parseLong(num);
        String hex = Long.toHexString(val).toUpperCase();

        StringBuilder sb = new StringBuilder();
        for (char c : hex.toCharArray()) {
            if (c == '0')
                sb.append('O');
            else if (c == '1')
                sb.append('I');
            else if (c >= 'A' && c <= 'F')
                sb.append(c);
            else
                return "ERROR";
        }

        return sb.toString();
    }
}
