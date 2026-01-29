package leetcode.P1744_CanYouEatYourFavoriteCandyOnYourFavoriteDay;

public class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + candiesCount[i];
        }

        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            int day = queries[i][1];
            int cap = queries[i][2];

            // Range of candies indices (1-based count in prefix)
            // Type i spans from prefix[i] + 1 to prefix[i+1]

            long minEatenByDay = day + 1; // 1 per day
            long maxEatenByDay = (long) (day + 1) * cap;

            long typeStart = prefix[type] + 1;
            long typeEnd = prefix[type + 1];

            // Overlap check
            // We can reach typeStart if maxEatenByDay >= typeStart
            // We are not forced to finish typeEnd if minEatenByDay <= typeEnd

            result[i] = (maxEatenByDay >= typeStart && minEatenByDay <= typeEnd);
        }

        return result;
    }
}
