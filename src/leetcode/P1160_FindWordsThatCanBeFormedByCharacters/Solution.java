package leetcode.P1160_FindWordsThatCanBeFormedByCharacters;

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] avail = new int[26];
        for (char c : chars.toCharArray())
            avail[c - 'a']++;

        int res = 0;
        for (String w : words) {
            int[] wc = new int[26];
            boolean good = true;
            for (char c : w.toCharArray()) {
                wc[c - 'a']++;
                if (wc[c - 'a'] > avail[c - 'a']) {
                    good = false;
                    break;
                }
            }
            if (good)
                res += w.length();
        }
        return res;
    }
}
