package leetcode.P2079_WateringPlants;

public class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0;
        int currCap = capacity;

        for (int i = 0; i < plants.length; i++) {
            if (currCap >= plants[i]) {
                steps++;
                currCap -= plants[i];
            } else {
                // Return to river and come back
                // Steps: i (from i-1 to -1) + i+1 (from -1 to i)
                // Note: The loop assumes we are at i-1 before this step.
                // Standard step was +1.
                // Refill step replaces standard step with a long detour.
                // Detour: i-1 -> -1 (dist i). -1 -> i (dist i+1). Total 2i + 1.
                steps += 2 * i + 1;
                currCap = capacity - plants[i];
            }
        }

        return steps;
    }
}
