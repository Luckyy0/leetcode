package leetcode.P2055_PlatesBetweenCandles;

public class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] prefixPlates = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*')
                count++;
            prefixPlates[i] = count;
        }

        int[] nextCandle = new int[n];
        int candle = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|')
                candle = i;
            nextCandle[i] = candle;
        }

        int[] prevCandle = new int[n];
        candle = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|')
                candle = i;
            prevCandle[i] = candle;
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int cL = nextCandle[l];
            int cR = prevCandle[r];

            if (cL != -1 && cR != -1 && cL < cR) {
                res[i] = prefixPlates[cR] - prefixPlates[cL];
            } else {
                res[i] = 0;
            }
        }

        return res;
    }
}
