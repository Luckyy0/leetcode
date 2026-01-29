package leetcode.P1540_CanConvertStringInKMoves;

class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length())
            return false;

        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int diff = (t.charAt(i) - s.charAt(i) + 26) % 26;
            if (diff > 0) {
                counts[diff]++;
            }
        }

        for (int i = 1; i < 26; i++) {
            if (counts[i] > 0) {
                long maxVal = i + 26L * (counts[i] - 1);
                if (maxVal > k)
                    return false;
            }
        }

        return true;
    }
}
