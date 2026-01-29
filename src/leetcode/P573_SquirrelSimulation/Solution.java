package leetcode.P573_SquirrelSimulation;

class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int totalDist = 0;
        int maxSaving = Integer.MIN_VALUE;

        for (int[] nut : nuts) {
            int distToTree = distance(nut, tree);
            int distToSquirrel = distance(nut, squirrel);

            // Standard trip: Nut -> Tree -> Nut involves 2 * distToTree (conceptually)
            // But problem is collect all nuts to tree.
            // Regular path for a nut: Tree -> Nut -> Tree (2 * dist)
            // Squirrel picks first nut: Squirrel -> Nut -> Tree.
            // Diff = (Tree -> Nut) - (Squirrel -> Nut).
            // We want to maximize this difference (saving).

            totalDist += 2 * distToTree;
            maxSaving = Math.max(maxSaving, distToTree - distToSquirrel);
        }

        return totalDist - maxSaving;
    }

    private int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
