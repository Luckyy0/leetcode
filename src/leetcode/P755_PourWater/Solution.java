package leetcode.P755_PourWater;

class Solution {
    public int[] pourWater(int[] heights, int volume, int k) {
        for (int v = 0; v < volume; v++) {
            int best = k;

            // Try moving left
            // Thử di chuyển sang trái
            for (int i = k - 1; i >= 0; i--) {
                if (heights[i] < heights[best]) {
                    best = i;
                } else if (heights[i] > heights[best]) {
                    break;
                }
            }

            if (best != k) {
                heights[best]++;
                continue;
            }

            // Try moving right
            // Thử di chuyển sang phải
            for (int i = k + 1; i < heights.length; i++) {
                if (heights[i] < heights[best]) {
                    best = i;
                } else if (heights[i] > heights[best]) {
                    break;
                }
            }

            heights[best]++;
        }
        return heights;
    }
}
