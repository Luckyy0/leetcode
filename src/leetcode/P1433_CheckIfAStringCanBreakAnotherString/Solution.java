package leetcode.P1433_CheckIfAStringCanBreakAnotherString;

import java.util.Arrays;

class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        boolean oneBreaksTwo = true;
        boolean twoBreaksOne = true;

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] < c2[i])
                oneBreaksTwo = false;
            if (c2[i] < c1[i])
                twoBreaksOne = false;
        }

        return oneBreaksTwo || twoBreaksOne;
    }
}
