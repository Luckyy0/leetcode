# Problem Analysis: Minimum Number of People to Teach

## Problem Description
`n` languages. `languages` (user -> languages). `friendships`.
Find minimum users to teach ONE language so all friendships can communicate.
Two users can communicate if they share common language.
If not, teach.

## Analysis

1.  **Identify Unhappy**:
    -   Iterate `friendships`. Check intersection of languages.
    -   If empty intersection, add `u` and `v` to `unhappyUsers` Set.
    
2.  **Evaluate Languages**:
    -   If `unhappyUsers` is empty, return 0.
    -   For each language `k` from 1 to `n`:
        -   Count how many users in `unhappyUsers` do NOT have `k` in their `languages`.
        -   This count is `cost` (people to teach).
        -   Minimize `cost`.
    
3.  **Complexity**:
    -   Time: $O(F \cdot L + N \cdot U)$. F friendships, L max langs per user, U unhappy users.
    -   Space: $O(M \cdot L)$.

## Implementation Details
-   Convert user languages to `HashSet` or `boolean[]` for fast lookup.
