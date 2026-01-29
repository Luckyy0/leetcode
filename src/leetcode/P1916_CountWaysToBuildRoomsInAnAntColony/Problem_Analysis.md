# Problem Analysis: Count Ways to Build Rooms in an Ant Colony

## Problem Description
`prevRoom` array defines a tree rooted at 0.
Build rooms one by one. Can only build `i` if `prevRoom[i]` (parent) is already built.
Count topological sorts (linear extensions) of the tree.
Result mod $10^9 + 7$.

## Analysis

1.  **Combinatorics on Tree**:
    -   For a tree rooted at `u`, suppose subtrees are $v_1, v_2, \dots, v_k$.
    -   Size of subtree $v_i$ is $S(v_i)$.
    -   Total size of $u$'s subtree is $1 + \sum S(v_i)$. let this be $S(u)$.
    -   Topological sorts of a tree is given by the formula: `(S(u) - 1)! / ( \prod (S(v_i)!) ) * \prod (Ways(v_i))`.
    -   Or effectively: Total permutations of all nodes in subtree is $S(u)!$. But parent must be before children.
    -   This is valid, but the recurrence is simpler:
        -   To form the sequence for `u`, `u` must be first.
        -   The remaining $S(u)-1$ positions are filled by interleaving the sequences of subtrees.
        -   Number of ways to interleave sequences of lengths $L_1, L_2, \dots$ is Multinomial Coefficient: $( \sum L_i )! / ( L_1! L_2! \dots )$.
        -   So $Ways(u) = (S(u)-1)! / ( \prod S(v_i)! ) \times \prod Ways(v_i)$.
        -   Wait. Denominator is product of factorials of subtree TOTAL sizes? No.
        -   Multinomial is `Total! / (Size1! * Size2! ...)`.
        -   So $Ways(u) = \frac{(S(u)-1)!}{\prod_{v \in children} S(v)!} \times \prod_{v \in children} Ways(v)$.
    -   This simplifies nicely if we assume $Ways(v)$ recursively expands.
    -   Global formula: $N! / \prod_{i=0}^{N-1} Size(i)$.
    -   Why? Because for every node $i$, it must appear before all its descendants. This constraint divides the total permutations by $Size(i)$. Constraints are independent in a probabilistic sense? Yes (standard Hook length formula for trees).
    -   Formula: $N! \times \prod_{i=0}^{N-1} \frac{1}{Size(i)}$.

2.  **Implementation**:
    -   Calculate subtree sizes `Size(i)` using DFS.
    -   Calculate Factorials and Inverse Factorials (or just inverses).
    -   Result is $N! \times \prod (Size(i)^{-1}) \pmod P$.

## Implementation Details
-   DFS for sizes.
-   Modular Inverse (Fermat's Little Theorem: $a^{P-2} \pmod P$).
-   `long` arithmetic.
