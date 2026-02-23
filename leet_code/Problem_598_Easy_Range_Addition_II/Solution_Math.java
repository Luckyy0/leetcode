package leet_code.Problem_598_Easy_Range_Addition_II;

public class Solution_Math {

    /**
     * Counts the number of maximum integers in the final matrix.
     * Strategy: Find the minimum intersection rectangle of all operations.
     * Time: O(K), Space: O(1).
     */
    public int maxCount(int m, int n, int[][] ops) {
        // The maximum value will be in the top-left region that is covered
        // by the smallest box encountered in all operations.

        int minR = m;
        int minC = n;

        for (int[] op : ops) {
            minR = Math.min(minR, op[0]);
            minC = Math.min(minC, op[1]);
        }

        // Ensure we multiply as integers (returns int as per problem signature)
        return minR * minC;
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();
        int[][] ops = { { 2, 2 }, { 3, 3 } };
        System.out.println("Count of max integers: " + solution.maxCount(3, 3, ops)); // 4
    }
}
