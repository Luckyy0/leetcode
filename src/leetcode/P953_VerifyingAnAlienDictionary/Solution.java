package leetcode.P953_VerifyingAnAlienDictionary;

class Solution {
    int[] rank = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < 26; i++)
            rank[order.charAt(i) - 'a'] = i;

        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1]))
                return false;
        }
        return true;
    }

    private boolean isSorted(String w1, String w2) {
        int n = Math.min(w1.length(), w2.length());
        for (int i = 0; i < n; i++) {
            int c1 = w1.charAt(i) - 'a';
            int c2 = w2.charAt(i) - 'a';
            if (rank[c1] < rank[c2])
                return true;
            if (rank[c1] > rank[c2])
                return false;
        }
        return w1.length() <= w2.length();
    }
}
