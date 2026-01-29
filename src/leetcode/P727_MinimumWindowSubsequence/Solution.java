package leetcode.P727_MinimumWindowSubsequence;

class Solution {
    public String minWindow(String s1, String s2) {
        int i1 = 0, i2 = 0;
        int minLen = Integer.MAX_VALUE;
        String res = "";

        while (i1 < s1.length()) {
            if (s1.charAt(i1) == s2.charAt(i2)) {
                i2++;
                // Found all characters of s2 as a subsequence
                if (i2 == s2.length()) {
                    int end = i1;
                    i2--;
                    // Walk backward to minimize the window size
                    // Đi ngược lại để giảm thiểu kích thước cửa sổ
                    while (i2 >= 0) {
                        if (s1.charAt(i1) == s2.charAt(i2)) {
                            i2--;
                        }
                        i1--;
                    }
                    i1++;
                    int start = i1;
                    if (end - start + 1 < minLen) {
                        minLen = end - start + 1;
                        res = s1.substring(start, end + 1);
                    }
                    i2 = 0;
                }
            }
            i1++;
        }

        return res;
    }
}
