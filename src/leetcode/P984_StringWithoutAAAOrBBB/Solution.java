package leetcode.P984_StringWithoutAAAOrBBB;

class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        while (a > 0 || b > 0) {
            boolean writeA = false;
            int n = sb.length();
            if (n >= 2 && sb.charAt(n - 1) == sb.charAt(n - 2)) {
                if (sb.charAt(n - 1) == 'b')
                    writeA = true;
            } else {
                if (a >= b)
                    writeA = true;
            }

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
}
