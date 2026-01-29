package leetcode.P2038_RemoveColoredPiecesIfBothNeighborsAreTheSameColor;

public class Solution {
    public boolean winnerOfGame(String colors) {
        int countA = 0;
        int countB = 0;

        int n = colors.length();
        for (int i = 1; i < n - 1; i++) {
            char c = colors.charAt(i);
            char prev = colors.charAt(i - 1);
            char next = colors.charAt(i + 1);

            if (c == 'A' && prev == 'A' && next == 'A') {
                countA++;
            } else if (c == 'B' && prev == 'B' && next == 'B') {
                countB++;
            }
        }

        return countA > countB;
    }
}
