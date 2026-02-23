package leet_code.Problem_779_Medium_K_th_Symbol_in_Grammar;

public class Solution {

    /**
     * Finds the K-th symbol in N-th row.
     * Strategy: Recursion based on parent-child relationship (or bit count trick).
     * Time: O(N) for recursion, O(1) for bit count.
     * Space: O(N) recursion stack.
     */
    public int kthGrammar(int n, int k) {
        // Base case: Row 1 is always '0'
        if (n == 1) {
            return 0;
        }

        // Calculate the length of the previous row: 2^(n-2)
        // Or simply the midpoint of current row: 2^(n-2)
        int mid = 1 << (n - 2);

        if (k <= mid) {
            // First half of current row is identical to previous row
            return kthGrammar(n - 1, k);
        } else {
            // Second half is bitwise complement of previous row corresponding index
            // Map k to index in first half: k - mid
            return 1 - kthGrammar(n - 1, k - mid);
        }
    }

    // Alternative O(1) Solution:
    public int kthGrammarBit(int n, int k) {
        return Integer.bitCount(k - 1) & 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.kthGrammar(1, 1)); // 0
        System.out.println("Result 2: " + sol.kthGrammar(2, 1)); // 0
        System.out.println("Result 3: " + sol.kthGrammar(2, 2)); // 1
    }
}
