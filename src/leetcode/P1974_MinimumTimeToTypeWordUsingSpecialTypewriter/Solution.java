package leetcode.P1974_MinimumTimeToTypeWordUsingSpecialTypewriter;

public class Solution {
    public int minTimeToType(String word) {
        int time = 0;
        char curr = 'a';

        for (char c : word.toCharArray()) {
            int diff = Math.abs(c - curr);
            int move = Math.min(diff, 26 - diff);
            time += move + 1; // move + type
            curr = c;
        }

        return time;
    }
}
