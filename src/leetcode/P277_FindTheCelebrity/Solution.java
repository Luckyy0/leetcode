package leetcode.P277_FindTheCelebrity;

public class Solution {

    // Mock class to simulate the LeetCode environment
    // In LeetCode, this solution extends 'Relation'
    public static class Relation {
        int[][] graph;

        // Helper to set up the graph for testing
        public void setGraph(int[][] g) {
            this.graph = g;
        }

        public boolean knows(int a, int b) {
            return graph[a][b] == 1;
        }
    }

    // Solution extends Relation
    public static class CelebrityFinder extends Relation {

        /**
         * Problem 277: Find the Celebrity
         * Approach: Two pass elimination
         * 
         * Time Complexity: O(N)
         * Space Complexity: O(1)
         */
        public int findCelebrity(int n) {
            // Step 1: Find a candidate
            int candidate = 0;
            for (int i = 1; i < n; i++) {
                if (knows(candidate, i)) {
                    // If candidate knows i, candidate is not celebrity.
                    // But i potentially is. Switch.
                    candidate = i;
                }
                // If candidate doesn't know i, i cannot be celebrity. Candidate stays.
            }

            // Step 2: Verify candidate
            for (int i = 0; i < n; i++) {
                if (i == candidate)
                    continue;

                // If candidate knows anyone OR someone doesn't know candidate -> Invalid
                if (knows(candidate, i) || !knows(i, candidate)) {
                    return -1;
                }
            }

            return candidate;
        }
    }

    public static void main(String[] args) {
        CelebrityFinder solver = new CelebrityFinder();

        // Graph 1: 1 is celeb
        // [1,1,0] (0 knows 1)
        // [0,1,0] (1 knows nobody else)
        // [1,1,1] (2 knows 1)
        int[][] graph1 = {
                { 1, 1, 0 },
                { 0, 1, 0 },
                { 1, 1, 1 }
        };
        solver.setGraph(graph1);
        runTest(solver, 3, 1);

        // Graph 2: No celeb
        // [1,0,1]
        // [1,1,0]
        // [0,1,1]
        int[][] graph2 = {
                { 1, 0, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };
        solver.setGraph(graph2);
        runTest(solver, 3, -1);
    }

    private static void runTest(CelebrityFinder s, int n, int expected) {
        int result = s.findCelebrity(n);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
