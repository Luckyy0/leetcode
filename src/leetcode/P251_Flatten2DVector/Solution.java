package leetcode.P251_Flatten2DVector;

public class Solution {

    /**
     * Problem 251: Flatten 2D Vector
     * Approach: Two Pointers (row, col)
     * 
     * Theoretical Basis:
     * - Lazy evaluation: Only find the next element when asked.
     * - Handle empty inner arrays gracefully by skipping.
     * 
     * Time Complexity: O(1) amortized
     * Space Complexity: O(1) extra space
     */
    static class Vector2D {

        private int[][] vector;
        private int row;
        private int col;

        public Vector2D(int[][] vec) {
            this.vector = vec;
            this.row = 0;
            this.col = 0;
        }

        public int next() {
            // Ensure we are pointing to a valid element
            // Caller guarantees valid next() if hasNext() is true,
            // but robust design calls hasNext logic implicitly.
            if (!hasNext())
                throw new java.util.NoSuchElementException();

            return vector[row][col++];
        }

        public boolean hasNext() {
            // Advance row while looking for a non-exhausted inner array
            while (row < vector.length && col == vector[row].length) {
                row++;
                col = 0;
            }

            return row < vector.length;
        }
    }

    public static void main(String[] args) {
        // [[1, 2], [3], [4]]
        int[][] input1 = { { 1, 2 }, { 3 }, { 4 } };
        Vector2D v1 = new Vector2D(input1);

        System.out.println("v1.next(): " + v1.next()); // 1
        System.out.println("v1.next(): " + v1.next()); // 2
        System.out.println("v1.next(): " + v1.next()); // 3
        System.out.println("v1.hasNext(): " + v1.hasNext()); // true
        System.out.println("v1.hasNext(): " + v1.hasNext()); // true
        System.out.println("v1.next(): " + v1.next()); // 4
        System.out.println("v1.hasNext(): " + v1.hasNext()); // false

        System.out.println("-----------------");

        // [[], [3]] - Handle empty row
        int[][] input2 = { {}, { 3 } };
        Vector2D v2 = new Vector2D(input2);
        System.out.println("v2.hasNext(): " + v2.hasNext()); // true (skips empty row 0)
        System.out.println("v2.next(): " + v2.next()); // 3
        System.out.println("v2.hasNext(): " + v2.hasNext()); // false
    }
}
