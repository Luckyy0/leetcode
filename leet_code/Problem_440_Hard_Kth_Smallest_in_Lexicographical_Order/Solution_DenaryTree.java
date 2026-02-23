package leet_code.Problem_440_Hard_Kth_Smallest_in_Lexicographical_Order;

public class Solution_DenaryTree {

    /**
     * Finds the kth lexicographically smallest integer in range [1, n].
     * Strategy: Prune a denary tree by counting nodes in subtrees.
     * Time: O((log n)^2), Space: O(1).
     */
    public int findKthNumber(int n, int k) {
        long curr = 1;
        k--; // Start from 1, so we need k-1 more steps

        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                // kth exists in next sibling subtree
                curr++;
                k -= steps;
            } else {
                // kth exists in current prefix subtree
                curr *= 10;
                k--;
            }
        }

        return (int) curr;
    }

    // Counts how many integers in [1, n] start with prefix 'curr'
    private long countSteps(int n, long n1, long n2) {
        long steps = 0;
        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }

    public static void main(String[] args) {
        Solution_DenaryTree solution = new Solution_DenaryTree();
        System.out.println("Result (n=13, k=2): " + solution.findKthNumber(13, 2)); // 10
        System.out.println("Result (n=1, k=1): " + solution.findKthNumber(1, 1)); // 1
    }
}
