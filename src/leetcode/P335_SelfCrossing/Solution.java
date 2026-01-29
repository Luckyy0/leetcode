package leetcode.P335_SelfCrossing;

public class Solution {

    /**
     * Problem 335: Self Crossing
     * Approach: Geometry (Check 3 crossing patterns)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;
        if (n <= 3)
            return false;

        for (int i = 3; i < n; i++) {
            // Case 1: Fourth line crosses first line or subsequent cases involving 4 lines
            // spiral
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                return true;
            }

            // Case 2: Fifth line meets/crosses first line (border touch)
            if (i >= 4) {
                if (distance[i - 1] == distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2]) {
                    return true;
                }
            }

            // Case 3: Sixth line crosses first line (spiral transition)
            if (i >= 5) {
                if (distance[i - 1] <= distance[i - 3] &&
                        distance[i - 1] + distance[i - 5] >= distance[i - 3] &&
                        distance[i - 2] > distance[i - 4] &&
                        distance[i] + distance[i - 4] >= distance[i - 2]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [2,1,1,2] -> true
        runTest(solution, new int[] { 2, 1, 1, 2 }, true);

        // [1,2,3,4] -> false
        runTest(solution, new int[] { 1, 2, 3, 4 }, false);

        // [1,1,1,1] -> true
        runTest(solution, new int[] { 1, 1, 1, 1 }, true);
    }

    private static void runTest(Solution s, int[] distance, boolean expected) {
        boolean result = s.isSelfCrossing(distance);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
