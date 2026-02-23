package leet_code.Problem_499_Hard_The_Maze_III;

import java.util.PriorityQueue;
import java.util.Arrays;

public class Solution_Dijkstra {

    private static class Node implements Comparable<Node> {
        int r, c;
        int dist;
        String path;

        public Node(int r, int c, int dist, String path) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.path = path;
        }

        @Override
        public int compareTo(Node other) {
            if (this.dist != other.dist) {
                return this.dist - other.dist;
            }
            return this.path.compareTo(other.path);
        }
    }

    /**
     * Finds shortest path to hole.
     * Strategy: Dijkstra.
     * Time: O(MN log(MN)), Space: O(MN).
     */
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length;
        int n = maze[0].length;

        int[][] dists = new int[m][n];
        for (int[] row : dists)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(ball[0], ball[1], 0, ""));
        dists[ball[0]][ball[1]] = 0;

        // Directions: d, l, r, u (Lexicographically: d, l, r, u)
        // Wait, output asks for lexicographically smallest path string.
        // It's better to iterate directions in lexicographical order (d, l, r, u)
        // to naturally favor smaller lex paths if distances are equal?
        // Not necessarily sufficient with Dijkstra, comparison handles it.

        int[][] dirs = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
        String[] dirChars = { "d", "l", "r", "u" };

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            // If we found a shorter way to this node already, skip?
            // Actually standard Dijkstra logic: if dist > dists[r][c], skip.
            // But here we also care about Path.
            // Since PQ orders by dist then path, the first time we pop (r, c) is optimal.
            // EXCEPT: we might reach (r,c) with same dist but different path.
            // But PQ gives smallest path second. So yes, first pop is optimal.
            if (curr.dist > dists[curr.r][curr.c])
                continue;
            // Note: If curr.dist == dists[r][c] but curr.path is worse, skip?
            // Since we store path in Node, we can check.
            // Actually, comparing strings stored in a separate array 'paths[][]' is safer?
            // Let's refine:
            // If curr.r == hole, return path immediately?
            if (curr.r == hole[0] && curr.c == hole[1])
                return curr.path;

            for (int i = 0; i < 4; i++) {
                int[] d = dirs[i];
                int nr = curr.r;
                int nc = curr.c;
                int steps = 0;

                // Roll
                while (nr + d[0] >= 0 && nr + d[0] < m &&
                        nc + d[1] >= 0 && nc + d[1] < n &&
                        maze[nr + d[0]][nc + d[1]] == 0) {

                    nr += d[0];
                    nc += d[1];
                    steps++;

                    // Check hole during roll
                    if (nr == hole[0] && nc == hole[1]) {
                        break;
                    }
                }

                int newDist = curr.dist + steps;
                String newPath = curr.path + dirChars[i];

                // Update Logic:
                // If better distance OR (same distance AND better path)
                // BUT we need to store best path in a matrix to check 'same distance' condition
                // on future visits?
                // Actually, standard Dijkstra with 'first pop is best' works if state includes
                // (r, c).
                // But edge weights are dynamic (depends on rolling), edges are between stop
                // points.
                // Stopping points are nodes. (Hole is also a stop point).

                // We map dists associated with the path.
                // We maintain dists matrix purely for pruning.
                // Pruning logic: if newDist < dists[r][c], update & push.
                // If newDist == dists[r][c], we only push if newPath <
                // existing_best_path_to_here?
                // But we don't store path in matrix.
                // Problem: If we reach node X with dist D path "z", and later reach node X with
                // dist D path "a".
                // "a" should be processed.
                // So dists matrix should also imply path comparison? Or we allow loose check.
                // Let's relax pruning:
                // Push if (newDist < dists[nr][nc]) or (newDist == dists[nr][nc])?
                // But infinite loop risk? No, dists only decreases or stays equal. Only finite
                // paths of length D.
                // To be safe, let's allow re-push only if path is better.
                // But we don't know "path at node".
                // Solution: Just rely on PQ. But if graph has cycles? (0 cost cycles
                // impossible).
                // Actually, just standard Dijkstra is fine. "First time reaching hole" is
                // optimal.
                // Wait, multiple paths to Hole with same distance.
                // The PQ ensures (dist, path) order.
                // So the *very first* time we pop the Hole node, it is the globally optimal
                // (shortest dist, then lex-smallest path).

                // Pruning is just optimization.
                // Let's use a conservative pruning: Only push if newDist <= dists[nr][nc].
                // We need to allow equal for lex check.
                // BUT we can update dists[nr][nc] only if strictly smaller?
                // No. If newDist < dists[nr][nc], update dists.
                // If newDist == dists[nr][nc], we still push (might be better path), but don't
                // strictly require updating dists array.
                // To avoid explosion, maybe store `paths[m][n]` too?

                // Refined Strategy:
                // Use `dists[m][n]` and `bestPath[m][n]`.

                if (newDist <= dists[nr][nc]) {
                    // Check if actually better
                    // If smaller dist: YES.
                    // If equal dist: YES if smaller path.
                    // Otherwise NO.

                    // We need to retrieve stored path?
                    // Let's assume we don't store global path map, just simpler logic:
                    // If newDist < dists, update dists. Push.
                    // If newDist == dists, we *might* push.
                    // Actually, simply using `curr.dist > dists[curr.r][curr.c]` check at POP time
                    // is safest combined with strict update.
                    // But strict update blocks equal dists.

                    // Better:
                    // Just use `PriorityQueue` and let it handle order.
                    // When hitting hole, return immediately.
                    // To prune, verify against `dists`.
                    // If newDist < dists[nr][nc]: update dists, push.
                    // If newDist == dists[nr][nc]: push (let PQ sort). (Limit: track visited count?
                    // or just allow).
                    // Actually, if we allow equal, we might have many same-dist entries.
                    // But hole is returned on first pop.
                    // So we update dists to `newDist` always.
                    // If equal, we effectively don't change `dists` value, but we push new path.
                    // Optimization: Use `compareTo` logic against stored path if available.
                }

                // Let's implement storing paths to be strict.
            }
        }

        return "impossible";
    }

    // Implementation with strict arrays
    public String findShortestWayStrict(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dists = new int[m][n];
        for (int[] r : dists)
            Arrays.fill(r, Integer.MAX_VALUE);

        // Needed to pruning equal distance but worse path
        String[][] ways = new String[m][n];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(ball[0], ball[1], 0, ""));
        dists[ball[0]][ball[1]] = 0;
        ways[ball[0]][ball[1]] = "";

        int[][] dirs = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
        String[] dirChars = { "d", "l", "r", "u" };

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            // If this state is worse than what we already recorded, skip
            if (curr.dist > dists[curr.r][curr.c] ||
                    (curr.dist == dists[curr.r][curr.c] && ways[curr.r][curr.c] != null
                            && curr.path.compareTo(ways[curr.r][curr.c]) > 0)) {
                continue;
            }

            if (curr.r == hole[0] && curr.c == hole[1])
                return curr.path;

            for (int i = 0; i < 4; i++) {
                int[] d = dirs[i];
                int nr = curr.r;
                int nc = curr.c;
                int steps = 0;

                while (nr + d[0] >= 0 && nr + d[0] < m &&
                        nc + d[1] >= 0 && nc + d[1] < n &&
                        maze[nr + d[0]][nc + d[1]] == 0) {
                    nr += d[0];
                    nc += d[1];
                    steps++;
                    if (nr == hole[0] && nc == hole[1])
                        break;
                }

                int newDist = curr.dist + steps;
                String newPath = curr.path + dirChars[i];

                if (newDist < dists[nr][nc] ||
                        (newDist == dists[nr][nc] && (ways[nr][nc] == null || newPath.compareTo(ways[nr][nc]) < 0))) {
                    dists[nr][nc] = newDist;
                    ways[nr][nc] = newPath;
                    pq.offer(new Node(nr, nc, newDist, newPath));
                }
            }
        }

        return "impossible";
    }

    public static void main(String[] args) {
        Solution_Dijkstra solution = new Solution_Dijkstra();
        int[][] maze = { { 0, 0, 0, 0, 0 }, { 1, 1, 0, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1 },
                { 0, 1, 0, 0, 0 } };
        int[] ball = { 4, 3 };
        int[] hole = { 0, 1 };
        // Expected: "lul"
        System.out.println("Result: " + solution.findShortestWayStrict(maze, ball, hole));
    }
}
