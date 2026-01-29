package leetcode.P2056_NumberOfValidMoveCombinationsOnChessboard;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int[][] rookDirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    int[][] bishopDirs = { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
    int[][] queenDirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

    public int countCombinations(String[] pieces, int[][] positions) {
        int n = pieces.length;
        List<int[]>[] allMoves = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            allMoves[i] = generateMoves(pieces[i], positions[i]);
        }

        return dfs(0, n, allMoves, new ArrayList<>());
    }

    private int dfs(int idx, int n, List<int[]>[] allMoves, List<int[]> currentMoves) {
        if (idx == n) {
            return 1;
        }

        int count = 0;
        for (int[] move : allMoves[idx]) {
            if (isValid(move, currentMoves)) {
                currentMoves.add(move);
                count += dfs(idx + 1, n, allMoves, currentMoves);
                currentMoves.remove(currentMoves.size() - 1);
            }
        }
        return count;
    }

    private boolean isValid(int[] newMove, List<int[]> currentMoves) {
        for (int[] m : currentMoves) {
            if (checkCollision(newMove, m))
                return false;
        }
        return true;
    }

    // Check collision between two moves
    // Move format: {startX, startY, dx, dy, steps}
    private boolean checkCollision(int[] m1, int[] m2) {
        int x1 = m1[0], y1 = m1[1];
        int x2 = m2[0], y2 = m2[1];
        int dx1 = m1[2], dy1 = m1[3];
        int dx2 = m2[2], dy2 = m2[3];
        int s1 = m1[4], s2 = m2[4];

        int t = 1;
        // Check initial position? "Simultaneously move". Start at t=0 are distinc
        // (given).
        // Check for t=1 onwards.
        // Max time needed to check? Max(s1, s2).

        int maxT = Math.max(s1, s2);

        // Sim from t=1 to maxT
        // At t, pos is start + min(t, steps) * d.

        for (int i = 1; i <= 8; i++) { // Max steps on 8x8 is 7. Wait, check up to 8.
            if (i > maxT)
                break;

            int curX1 = x1 + Math.min(i, s1) * dx1;
            int curY1 = y1 + Math.min(i, s1) * dy1;

            int curX2 = x2 + Math.min(i, s2) * dx2;
            int curY2 = y2 + Math.min(i, s2) * dy2;

            if (curX1 == curX2 && curY1 == curY2)
                return true;
        }

        return false;
    }

    private List<int[]> generateMoves(String piece, int[] pos) {
        List<int[]> moves = new ArrayList<>();
        int x = pos[0], y = pos[1];

        // Add Stay move (steps = 0)
        moves.add(new int[] { x, y, 0, 0, 0 });

        int[][] dirs;
        if (piece.equals("rook"))
            dirs = rookDirs;
        else if (piece.equals("bishop"))
            dirs = bishopDirs;
        else
            dirs = queenDirs;

        for (int[] d : dirs) {
            for (int s = 1; s < 8; s++) {
                int nx = x + d[0] * s;
                int ny = y + d[1] * s;
                if (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8) {
                    moves.add(new int[] { x, y, d[0], d[1], s });
                } else {
                    break;
                }
            }
        }
        return moves;
    }
}
