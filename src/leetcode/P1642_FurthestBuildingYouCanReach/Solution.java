package leetcode.P1642_FurthestBuildingYouCanReach;

import java.util.PriorityQueue;

public class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> ladderAllocations = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];

            if (diff > 0) {
                ladderAllocations.offer(diff);

                if (ladderAllocations.size() > ladders) {
                    // Pull out the smallest jump and pay with bricks
                    int bricksNeeded = ladderAllocations.poll();
                    bricks -= bricksNeeded;

                    if (bricks < 0) {
                        return i;
                    }
                }
            }
        }

        return heights.length - 1;
    }
}
