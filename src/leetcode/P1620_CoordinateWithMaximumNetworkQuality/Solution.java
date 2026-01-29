package leetcode.P1620_CoordinateWithMaximumNetworkQuality;

public class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[] bestCoord = new int[] { 0, 0 };
        int maxQuality = 0;

        // Search space is limited by constraints [0, 50]
        for (int x = 0; x <= 50; x++) {
            for (int y = 0; y <= 50; y++) {
                int quality = 0;

                for (int[] t : towers) {
                    int tx = t[0];
                    int ty = t[1];
                    int q = t[2];

                    double d = Math.sqrt((tx - x) * (tx - x) + (ty - y) * (ty - y));

                    if (d <= radius) {
                        quality += (int) Math.floor(q / (1 + d));
                    }
                }

                if (quality > maxQuality) {
                    maxQuality = quality;
                    bestCoord = new int[] { x, y };
                }
            }
        }

        return bestCoord;
    }
}
