package leetcode.P406_QueueReconstructionByHeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Problem 406: Queue Reconstruction by Height
     * Approach: Greedy (Sort and Insert)
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     */
    public int[][] reconstructQueue(int[][] people) {
        // Sort: height descending, k ascending
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0]; // Height descending
            } else {
                return a[1] - b[1]; // k ascending
            }
        });

        List<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            // Insert person at index defined by their k value
            result.add(person[1], person);
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]] ->
        // [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
        int[][] people1 = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
        int[][] expected1 = { { 5, 0 }, { 7, 0 }, { 5, 2 }, { 6, 1 }, { 4, 4 }, { 7, 1 } };
        runTest(solution, people1, expected1);

        // [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]] ->
        // [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
        int[][] people2 = { { 6, 0 }, { 5, 0 }, { 4, 0 }, { 3, 2 }, { 2, 2 }, { 1, 4 } };
        int[][] expected2 = { { 4, 0 }, { 5, 0 }, { 2, 2 }, { 3, 2 }, { 1, 4 }, { 6, 0 } };
        runTest(solution, people2, expected2);
    }

    private static void runTest(Solution sol, int[][] people, int[][] expected) {
        int[][] result = sol.reconstructQueue(people);
        System.out.println("Result: " + Arrays.deepToString(result));
        System.out.println("Expected: " + Arrays.deepToString(expected));
        if (Arrays.deepEquals(result, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
