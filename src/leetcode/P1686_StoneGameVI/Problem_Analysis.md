# Problem Analysis: Stone Game VI

## Problem Description
Alice and Bob take turns removing stones. `aliceValues` and `bobValues` given.
If Alice takes stone `i`, she gets `aliceValues[i]`. If Bob takes it later? No, stones removed.
If Bob takes stone `i`, he gets `bobValues[i]`.
Game result = AliceScore - BobScore. maximize for Alice, minimize for Bob.
Return 1 if Alice wins, -1 if Bob wins, 0 if draw.

## Analysis

1.  **Greedy Strategy**:
    -   Consider a stone `i`.
    -   If Alice takes it, net diff increases by `A[i]`.
    -   If Bob takes it, net diff decreases by `B[i]` (effectively Bob gains `B[i]`, Alice gains 0).
    -   The swing between Alice taking and Bob taking is `A[i] - (-B[i]) = A[i] + B[i]`.
    -   Both players should prioritize stones with the highest `A[i] + B[i]`.
    -   Why? Because taking `i` prevents the opponent from inflicting a `-B[i]` (for Alice) or `-A[i]` (for Bob) swing relative to the item being taken.
    
2.  **Algorithm**:
    -   Create array of indices.
    -   Sort indices by `aliceValues[i] + bobValues[i]` descending.
    -   Iterate:
        -   Turn 0, 2, 4... (Alice): `score += aliceValues[idx]`.
        -   Turn 1, 3, 5... (Bob): `score -= bobValues[idx]`.
    -   Check score sign.

3.  **Complexity**:
    -   Time: $O(N \log N)$.
    -   Space: $O(N)$.

## Implementation Details
-   2D array or Integer array with custom comparator.
