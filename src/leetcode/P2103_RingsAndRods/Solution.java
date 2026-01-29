package leetcode.P2103_RingsAndRods;

public class Solution {
    public int countPoints(String rings) {
        int[] rodStatus = new int[10];

        for (int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            int rod = rings.charAt(i + 1) - '0';

            int bit = 0;
            if (color == 'R')
                bit = 1;
            else if (color == 'G')
                bit = 2;
            else if (color == 'B')
                bit = 4;

            rodStatus[rod] |= bit;
        }

        int count = 0;
        for (int s : rodStatus) {
            if (s == 7)
                count++;
        }
        return count;
    }
}
