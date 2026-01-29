package leetcode.P1427_PerformStringShifts;

class Solution {
    public String stringShift(String s, int[][] shift) {
        int len = s.length();
        int totalShift = 0;

        for (int[] move : shift) {
            if (move[0] == 0) {
                totalShift -= move[1];
            } else {
                totalShift += move[1];
            }
        }

        totalShift %= len;
        if (totalShift < 0)
            totalShift += len;

        return s.substring(len - totalShift) + s.substring(0, len - totalShift);
    }
}
