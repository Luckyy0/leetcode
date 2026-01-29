package leetcode.P1880_CheckIfWordEqualsSummationOfTwoWords;

public class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return getVal(firstWord) + getVal(secondWord) == getVal(targetWord);
    }

    private int getVal(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 'a');
        }
        return Integer.parseInt(sb.toString());
    }
}
