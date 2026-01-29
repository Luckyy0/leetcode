package leetcode.P1869_LongerContiguousSegmentsOfOnesThanZeros;

public class Solution {
    public boolean checkZeroOnes(String s) {
        int maxOne = 0, currOne = 0;
        int maxZero = 0, currZero = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                currOne++;
                currZero = 0;
                maxOne = Math.max(maxOne, currOne);
            } else {
                currZero++;
                currOne = 0;
                maxZero = Math.max(maxZero, currZero);
            }
        }

        return maxOne > maxZero;
    }
}
