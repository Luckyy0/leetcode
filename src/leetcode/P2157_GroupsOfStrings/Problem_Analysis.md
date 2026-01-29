# Problem Analysis: Groups of Strings

## Problem Description
Array `words`. Two strings are connected if one can be obtained from the other by:
1.  Adding exactly one letter.
2.  Deleting exactly one letter.
3.  Replacing exactly one letter.
Return `[numGroups, maxSize]`.
Note: All words consist of distinct lowercase letters. Order doesn't matter (implied by set-like operations on letters).
Actually, "Adding... letter" implies we treat them as sets of characters?
"letters ... distinct". So we can represent each word as a Bitmask (26 bits).
Operations effectively:
-   Add: Mask A -> Mask B where B has 1 extra bit. (Hamming dist 1, B > A).
-   Delete: Mask A -> Mask B where B has 1 less bit. (Hamming dist 1, B < A).
-   Replace: Mask A -> Mask B where varying 1 bit out, 1 bit in. (Hamming dist 2? Same popcount).
Connectivity is transitive.

## Analysis

1.  **Union-Find with Bitmasks**:
    -   Represent each word as integer mask.
    -   Store `Map<Mask, Index>` or just handle unique masks (summing counts of duplicates).
    -   For each unique mask `M`:
        -   Generate all neighbors `N` connected to `M`.
        -   If `N` exists in map, `Union(M, N)`.
    -   What are the neighbors?
        1.  **Delete 1 bit**: Iterate all set bits of `M`. Remove one: `M ^ (1<<i)`.
            -   This covers "Delete" operation directly.
            -   This *also* covers "Add" operation (because if we have masks A and B where B = A + char, then A = B - char. When processing B, we generate A. If A exists, we connect).
            -   This *also* helps "Replace". If A and B differ by 1 char replaced, they share a common submask S (A->S and B->S by deletion).
            -   e.g. A has bits {0, 1}, B has {0, 2}. S is {0}.
            -   When processing A {0, 1}, we generate S {0}. Store/Union (A, S).
            -   When processing B {0, 2}, we generate S {0}. Store/Union (B, S).
            -   Thus A and B are connected via S.
            -   **Crucial Point**: Do we need to store S in the map if S is not in `words`?
            -   Yes, S acts as an intermediate node. Or we can just map `S -> ID_of_A` temporarily.
            -   Map `deletedMask -> originalMaskIndex`.
            -   When processing `M`:
                -   Iterate bits to generate `rem = M ^ (1<<i)`.
                -   Check if `rem` exists as a word. If yes, Union.
                -   Check `map` for `rem`. If implies connection to another mask `other`, Union(`M`, `other`).
                -   Update `map[rem] = M` (so future words reducing to `rem` connect to `M`).
    -   Counts:
        -   Handle duplicate words (same mask). They are implicitly same group.
        -   Track size of each group.
    -   Total words $2 \cdot 10^4$. Bits 26.
    -   Complexity: $O(N \cdot 26 \cdot \alpha(N))$. Feasible.

## Implementation Details
-   `parent` array, `size` array.
-   `Map<Integer, Integer> maskToIndex`.
-   Loop unique masks.
