# Problem Analysis: Smallest Missing Genetic Value in Each Subtree

## Problem Description
Tree rooted at 0. `parents` array. `nums` (distinct genetic values, 1-based?).
Values `nums[i]` are distinct integers.
Find smallest missing positive integer in the subtree of each node.
Total nodes $10^5$. Values $10^5$.

## Analysis

1.  **Optimization based on Smallest Missing**:
    -   The missing value for most nodes is 1. because 1 is usually in some subtree.
    -   If 1 is not in subtree of `u`, answer is 1.
    -   If 1 IS in subtree of `u`, answer is $>1$.
    -   Key insight: Since `nums` are distinct, `1` exists at most ONCE.
    -   Let `nodeWith1` be the node where `nums[v] == 1`.
    -   If no node has 1, all answers are 1.
    -   If a node has 1, then only ancestors of `nodeWith1` (including itself) have 1 in their subtree.
    -   For all other nodes (not on path from `nodeWith1` to root), answer is 1.
    -   For nodes on the path from `nodeWith1` to root:
        -   We need to find smallest missing.
        -   We can traverse upwards from `nodeWith1`.
        -   Accumulate set of seen values in the current aggregated subtree.
        -   Maintain a `mex` pointer.
        -   Start at `nodeWith1`. Add nodes in its subtree to Set. Mex starts at 1. While set contains Mex, Mex++.
        -   Move to parent. Add all nodes in parent's subtree EXCEPT the child we just came from (which is already added).
        -   Continue until root.
    -   Complexity:
        -   Each node is visited once in the "add to set" process because we only merge subtrees into the growing component along the path to root.
        -   Other nodes have answer 1 found in $O(1)$.
        -   mex increments at most $N$ times total.
        -   Total $O(N)$.

2.  **Algorithm**:
    -   Identify `idx` of 1. If none, return all 1s.
    -   Init `ans` array with 1s.
    -   `visited` array.
    -   Path from `idx` up to root.
    -   For each node in path:
        -   DFS its subtree (skip visited nodes).
        -   Add values to `seen` boolean array/set.
        -   Update `mex`.
        -   Set `ans[node] = mex`.

## Implementation Details
-   `parents` to build adjacency.
-   `visited` prevents re-processing the main path nodes (children on the path).
