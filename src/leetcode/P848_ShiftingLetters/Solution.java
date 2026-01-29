package leetcode.P848_ShiftingLetters;

class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] chars = s.toCharArray();
        long currentShift = 0;

        for (int i = shifts.length - 1; i >= 0; i--) {
            currentShift = (currentShift + shifts[i]) % 26;
            chars[i] = (char) ((chars[i] - 'a' + currentShift) % 26 + 'a');
        }

        return new String(chars);
    }
}
