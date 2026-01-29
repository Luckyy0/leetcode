package leetcode.P909_SnakesAndLadders;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n * n)
                    return steps;

                for (int roll = 1; roll <= 6; roll++) {
                    int next = curr + roll;
                    if (next > n * n)
                        break;

                    int[] rc = getCoords(next, n);
                    int boardVal = board[rc[0]][rc[1]];
                    int actualNext = boardVal == -1 ? next : boardVal;

                    if (!visited[actualNext]) {
                        visited[actualNext] = true;
                        queue.add(actualNext);
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    private int[] getCoords(int label, int n) {
        int r = (label - 1) / n;
        int c = (label - 1) % n;
        if (r % 2 == 1)
            c = n - 1 - c;
        return new int[] { n - 1 - r, c };
    }
}
