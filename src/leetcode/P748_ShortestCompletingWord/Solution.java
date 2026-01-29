package leetcode.P748_ShortestCompletingWord;

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] target = getCounts(licensePlate);
        String res = null;

        for (String word : words) {
            if (isCompleting(target, getCounts(word))) {
                if (res == null || word.length() < res.length()) {
                    res = word;
                }
            }
        }
        return res;
    }

    private int[] getCounts(String name) {
        int[] counts = new int[26];
        for (char c : name.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                counts[c - 'a']++;
            }
        }
        return counts;
    }

    private boolean isCompleting(int[] target, int[] current) {
        for (int i = 0; i < 26; i++) {
            if (current[i] < target[i])
                return false;
        }
        return true;
    }
}
