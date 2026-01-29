package leetcode.P821_ShortestDistanceToACharacter;

class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] res = new int[n];

        int pos = -10001; // Initialize with a far distance

        // Left to right
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c)
                pos = i;
            res[i] = i - pos;
        }

        // Right to left
        pos = 20002;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c)
                pos = i;
            res[i] = Math.min(res[i], pos - i);
        }

        return res;
    }
}
