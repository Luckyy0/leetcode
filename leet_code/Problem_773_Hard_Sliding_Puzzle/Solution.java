package leet_code.Problem_773_Hard_Sliding_Puzzle;

import java.util.*;

public class Solution {

    /**
     * Solves the sliding puzzle.
     * Strategy: BFS on string representation of board state.
     * Time: O(6! * 6), Space: O(6! * 6).
     */
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder startSb = new StringBuilder();
        for (int[] row : board) {
            for (int val : row) {
                startSb.append(val);
            }
        }
        String start = startSb.toString();

        // Directions for 0 to move to neighbors in a flattened 2x3 grid
        // Indices:
        // 0 1 2
        // 3 4 5
        int[][] dirs = {
                { 1, 3 }, // 0
                { 0, 2, 4 }, // 1
                { 1, 5 }, // 2
                { 0, 4 }, // 3
                { 1, 3, 5 }, // 4
                { 2, 4 } // 5
        };

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(start);
        visited.add(start);

        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(target)) {
                    return moves;
                }

                int zeroIdx = curr.indexOf('0');
                for (int nextIdx : dirs[zeroIdx]) {
                    String nextState = swap(curr, zeroIdx, nextIdx);
                    if (visited.add(nextState)) {
                        q.offer(nextState);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    // Helper to swap characters in string
    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] b1 = { { 1, 2, 3 }, { 4, 0, 5 } };
        System.out.println("Result 1: " + sol.slidingPuzzle(b1)); // 1

        int[][] b2 = { { 1, 2, 3 }, { 5, 4, 0 } };
        System.out.println("Result 2: " + sol.slidingPuzzle(b2)); // -1

        int[][] b3 = { { 4, 1, 2 }, { 5, 0, 3 } };
        System.out.println("Result 3: " + sol.slidingPuzzle(b3)); // 5
    }
}
