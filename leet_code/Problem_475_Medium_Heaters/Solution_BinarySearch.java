package leet_code.Problem_475_Medium_Heaters;

import java.util.Arrays;

public class Solution_BinarySearch {

    /**
     * Finds the minimum radius to cover all houses.
     * Strategy: Sort heaters. For each house, find closest heater using binary
     * search.
     * Time: O(M log M + N log M), Space: O(1).
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int maxRadius = 0;

        for (int house : houses) {
            // Arrays.binarySearch returns index if found
            // If not found, returns -(insertion point) - 1
            int index = Arrays.binarySearch(heaters, house);

            if (index < 0) {
                index = -(index + 1); // Insertion point
                int dist1 = Integer.MAX_VALUE;
                int dist2 = Integer.MAX_VALUE;

                // Heater on the left
                if (index > 0) {
                    dist1 = house - heaters[index - 1];
                }

                // Heater on the right
                if (index < heaters.length) {
                    dist2 = heaters[index] - house;
                }

                maxRadius = Math.max(maxRadius, Math.min(dist1, dist2));
            }
            // Else house is exactly at heater location, dist is 0, maxRadius doesn't
            // increase
        }

        return maxRadius;
    }

    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();
        int[] houses = { 1, 2, 3, 4 };
        int[] heaters = { 1, 4 };
        System.out.println("Result: " + solution.findRadius(houses, heaters)); // 1
    }
}
