package leetcode.P2120_ExecutionOfAllSuffixInstructionsStayingInAGrid;

public class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length();
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int r = startPos[0];
            int c = startPos[1];
            int count = 0;

            for (int j = i; j < m; j++) {
                char move = s.charAt(j);
                if (move == 'L')
                    c--;
                else if (move == 'R')
                    c++;
                else if (move == 'U')
                    r--;
                else if (move == 'D')
                    r++;

                if (r < 0 || r >= n || c < 0 || c >= n) {
                    break;
                }
                count++;
            }
            result[i] = count;
        }

        return result;
    }
}
