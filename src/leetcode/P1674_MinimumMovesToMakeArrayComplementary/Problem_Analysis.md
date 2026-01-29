# Problem Analysis: Minimum Moves to Make Array Complementary

## Problem Description
You given an integer array `nums` of even length `n` and an integer `limit`.
Elements are in `1 ... limit`.
In one move, replace any element with `1 ... limit`.
Goal: Make `nums[i] + nums[n-1-i]` equal to same value `T` for all `i`.
Return min moves.

## Analysis

1.  **Difference Array (Sweep Line)**:
    -   Consider pairs $(A, B)$. Let $A \le B$.
    -   Possible Sums range from $2$ to $2 \cdot limit$.
    -   Moves needed for sum $S$:
        -   0 moves: $S = A + B$.
        -   1 move: $S \in [1 + \min(A, B), \text{limit} + \max(A, B)]$ AND $S \neq A+B$.
            -   Min possible sum with 1 swap: transform larger ($B \to 1$) $\implies 1 + A$.
            -   Max possible sum with 1 swap: transform smaller ($A \to \text{limit}$) $\implies \text{limit} + B$.
        -   2 moves: $S \in [2, 2 \cdot \text{limit}]$ elsewhere.
    -   We can use range updates:
        -   Init `diff` array size `2*limit + 2`.
        -   ForAll pairs:
            -   Apply +2 cost to range $[2, 2 \cdot \text{limit}]$. `diff[2] += 2`, `diff[2*limit+1] -= 2`.
            -   Apply -1 cost (reduce 2->1) to range $[1 + \min(A, B), \text{limit} + \max(A, B)]$.
            -   Apply -1 cost (reduce 1->0) to point $[A+B]$.
    -   After processing all pairs, compute prefix sum of `diff`.
    -   The prefix sum at `k` gives total moves to make all pairs sum to `k`.
    -   Find min value.

2.  **Complexity**:
    -   Time: $O(N + \text{limit})$.
    -   Space: $O(\text{limit})$.

## Implementation Details
-   `diff` array. Prefix loop.
