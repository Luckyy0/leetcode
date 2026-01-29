package leetcode.P1576_ReplaceAllsToAvoidConsecutiveRepeatingCharacters;

public class Solution {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int i = 0; i < n; i++) {
            if (chars[i] == '?') {
                for (char c = 'a'; c <= 'z'; c++) {
                    boolean conflict = false;
                    // Check left neighbor
                    if (i > 0 && chars[i - 1] == c) {
                        conflict = true;
                    }
                    // Check right neighbor
                    if (i < n - 1 && chars[i + 1] == c) {
                        conflict = true;
                    }

                    if (!conflict) {
                        chars[i] = c;
                        break;
                    }
                }
            }
        }

        return new String(chars);
    }
}
