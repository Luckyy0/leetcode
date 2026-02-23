package leet_code.Problem_573_Medium_Squirrel_Simulation;

public class Solution_Greedy {

    /**
     * Calculates the minimum distance the squirrel needs to travel.
     * Strategy: Total Round Trips - Max Savings from the first trip.
     * Time: O(N), Space: O(1).
     */
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int totalDistance = 0;
        int maxSavings = Integer.MIN_VALUE;

        for (int[] nut : nuts) {
            int distToTree = getDistance(nut, tree);
            int distToSquirrel = getDistance(nut, squirrel);

            // Total round trips if squirrel starts from tree for every nut
            totalDistance += 2 * distToTree;

            // Savings if this nut is the first one
            // Normal: 2 * distToTree
            // First: distToSquirrel + distToTree
            // Difference (Saving): distToTree - distToSquirrel
            int saving = distToTree - distToSquirrel;
            maxSavings = Math.max(maxSavings, saving);
        }

        return totalDistance - maxSavings;
    }

    private int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();
        int[] tree = { 2, 2 };
        int[] squirrel = { 4, 4 };
        int[][] nuts = { { 3, 0 }, { 2, 5 } };
        System.out.println("Min Distance: " + solution.minDistance(5, 7, tree, squirrel, nuts)); // 12
    }
}
