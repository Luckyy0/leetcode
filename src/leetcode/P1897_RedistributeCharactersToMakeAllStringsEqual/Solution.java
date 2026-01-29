package leetcode.P1897_RedistributeCharactersToMakeAllStringsEqual;

public class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        int[] count = new int[26];
        for (String w : words) {
            for (char c : w.toCharArray()) {
                count[c - 'a']++;
            }
        }

        for (int c : count) {
            if (c % n != 0)
                return false;
        }
        return true;
    }
}
