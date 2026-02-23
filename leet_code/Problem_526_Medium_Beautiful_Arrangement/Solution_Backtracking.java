package leet_code.Problem_526_Medium_Beautiful_Arrangement;

public class Solution_Backtracking {

    private int count = 0;

    /**
     * Counts beautiful arrangements.
     * Strategy: Backtracking with boolean visited array.
     * Time: O(Valid Permutations), Space: O(N).
     */
    public int countArrangement(int n) {
        count = 0;
        boolean[] visited = new boolean[n + 1];
        backtrack(n, 1, visited);
        return count;
    }

    private void backtrack(int n, int index, boolean[] visited) {
        if (index > n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % index == 0 || index % i == 0)) {
                visited[i] = true;
                backtrack(n, index + 1, visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();
        System.out.println("Result 2: " + solution.countArrangement(2)); // 2
        System.out.println("Result 3: " + solution.countArrangement(3)); // 3
    }
}
