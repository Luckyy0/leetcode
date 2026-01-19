package leetcode.P278_FirstBadVersion;

public class Solution {

    // Mock VersionControl class
    public static class VersionControl {
        private int firstBadVersion;

        public void setFirstBadVersion(int ver) {
            this.firstBadVersion = ver;
        }

        public boolean isBadVersion(int version) {
            return version >= firstBadVersion;
        }
    }

    public static class FirstBadVersion extends VersionControl {

        /**
         * Problem 278: First Bad Version
         * Approach: Binary Search
         * 
         * Theoretical Basis:
         * - Find first 'true' in a sorted boolean array [False, ..., True, ...].
         * 
         * Time Complexity: O(log N)
         * Space Complexity: O(1)
         */
        public int firstBadVersion(int n) {
            int low = 1;
            int high = n;

            while (low < high) {
                // Avoid overflow
                int mid = low + (high - low) / 2;

                if (isBadVersion(mid)) {
                    // Current is bad. Could be the first one, or first is to the left.
                    high = mid;
                } else {
                    // Current is good. First bad must be to the right.
                    low = mid + 1;
                }
            }

            return low;
        }
    }

    public static void main(String[] args) {
        FirstBadVersion solver = new FirstBadVersion();

        // n=5, bad=4
        solver.setFirstBadVersion(4);
        runTest(solver, 5, 4);

        // n=1, bad=1
        solver.setFirstBadVersion(1);
        runTest(solver, 1, 1);

        // n=10, bad=1
        solver.setFirstBadVersion(1);
        runTest(solver, 10, 1);
    }

    private static void runTest(FirstBadVersion s, int n, int expected) {
        int result = s.firstBadVersion(n);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
