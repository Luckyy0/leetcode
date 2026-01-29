package leetcode.P1024_VideoStitching;

class Solution {
    public int videoStitching(int[][] clips, int time) {
        int[] maxReach = new int[time + 1];
        for (int[] c : clips) {
            if (c[0] < time) {
                maxReach[c[0]] = Math.max(maxReach[c[0]], Math.min(time, c[1]));
            }
        }

        int count = 0;
        int curEnd = 0, farthest = 0;

        for (int i = 0; i < time; i++) {
            farthest = Math.max(farthest, maxReach[i]);

            if (i == curEnd) {
                count++;
                curEnd = farthest;
                if (curEnd >= time)
                    return count;
            }
            // Cannot reach next point
            if (i >= farthest)
                return -1;
        }

        return -1;
    }
}
