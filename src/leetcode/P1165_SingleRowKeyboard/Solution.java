package leetcode.P1165_SingleRowKeyboard;

class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] pos = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            pos[keyboard.charAt(i) - 'a'] = i;
        }

        int time = 0;
        int current = 0;
        for (char c : word.toCharArray()) {
            int next = pos[c - 'a'];
            time += Math.abs(current - next);
            current = next;
        }
        return time;
    }
}
