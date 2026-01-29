package leetcode.P1147_LongestChunkedPalindromeDecomposition;

class Solution {
    public int longestDecomposition(String text) {
        int n = text.length();
        int res = 0;
        int l = 0, r = n;

        while (l < r) {
            boolean found = false;
            // Try smallest length first
            for (int k = 1; k <= (r - l) / 2; k++) {
                if (text.substring(l, l + k).equals(text.substring(r - k, r))) {
                    res += 2;
                    l += k;
                    r -= k;
                    found = true;
                    break;
                }
            }
            if (!found) {
                res++;
                break;
            }
        }

        return res;
    }
}
