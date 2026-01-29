package leetcode.P1999_SmallestGreaterPalindrome;

public class Solution {
    public String nextPalindrome(String n) {
        // Since problem asks for integer string, likely next palindrome logic.
        // However, P1999 might be "Smallest Greater Palindrome" which is standard.
        // Let's implement generic next palindrome string logic.

        char[] s = n.toCharArray();
        int len = s.length;
        char[] res = new char[len];

        // 1. Try mirroring left half
        int mid = (len + 1) / 2;
        boolean leftSmaller = false;

        // Copy left to right
        for (int i = 0; i < mid; i++) {
            res[i] = s[i];
            res[len - 1 - i] = s[i];
        }

        // Compare res with s
        String candidate = new String(res);
        if (checkGreater(res, s)) {
            return candidate;
        }

        // 2. Increment middle
        // We need to increment the number formed by first 'mid' digits.
        // Carry propagation from middle towards left.

        char[] incremented = res.clone();
        int i = (len - 1) / 2; // Middle index (left-middle for even len)
        while (i >= 0) {
            if (incremented[i] < '9') {
                incremented[i]++;
                break;
            } else {
                incremented[i] = '0';
                i--;
            }
        }

        if (i < 0) {
            // Unsuccessful increment (e.g. 999 -> 000). Need to increase length.
            // Smallest palindrome with len+1 is 10...01
            StringBuilder sb = new StringBuilder();
            sb.append('1');
            for (int k = 0; k < len - 1; k++)
                sb.append('0');
            sb.append('1');
            return sb.toString();
        }

        // Mirror incremented left to right
        for (int k = 0; k < mid; k++) {
            incremented[len - 1 - k] = incremented[k];
        }

        return new String(incremented);
    }

    private boolean checkGreater(char[] a, char[] b) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            if (a[i] > b[i])
                return true;
            if (a[i] < b[i])
                return false;
        }
        return false; // Equal
    }
}
