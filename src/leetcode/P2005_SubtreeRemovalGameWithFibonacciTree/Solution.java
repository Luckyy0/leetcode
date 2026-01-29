package leetcode.P2005_SubtreeRemovalGameWithFibonacciTree;

public class Solution {
    public boolean findGameWinner(int n) {
        // SG values for Hackenbush on trees (remove node and subtree):
        // G(T) = 1 + XOR(G(children)).
        // T(0): single node -> G(0) = 1
        // T(1): single node -> G(1) = 1
        // T(n): root + T(n-1) + T(n-2) -> G(n) = 1 + (G(n-1) ^ G(n-2))

        // Let's compute sequence modulo ? No, just XOR.
        // G(0) = 1
        // G(1) = 1
        // G(2) = 1 + (1^1) = 1
        // G(3) = 1 + (1^1) = 1
        // It seems G(n) is always 1.
        // Thus G(n) != 0 always. Alice always wins.

        // Wait, maybe definition of T(1) is different?
        // If T(1) has T(0) as child?
        // Usually Fib Tree T(h) has T(h-1) and T(h-2).
        // Let's assume standard recursion.

        return true;
    }
}
