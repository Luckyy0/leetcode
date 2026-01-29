package leetcode.P2193_MinimumNumberOfMovesToMakePalindrome;

public class Solution {
    public int minMovesToMakePalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int l = 0, r = n - 1;
        int steps = 0;

        while (l < r) {
            // Find rightmost occurrence of chars[l]
            int k = r;
            while (k > l && chars[k] != chars[l]) {
                k--;
            }

            if (k == l) {
                // Determine center char case
                // Swap it with neighbor to move it towards center
                // Effectively, we just swap it right once and try again
                swap(chars, l, l + 1);
                steps++;
                // Do not shrink window, retry looking for pair at l
            } else {
                // Found pair at k. Move it to r.
                // Bubble from k to r
                while (k < r) {
                    swap(chars, k, k + 1);
                    steps++;
                    k++;
                }
                l++;
                r--;
            }
        }
        return steps;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
