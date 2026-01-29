# Problem Analysis: Delivering Boxes from Storage to Ports

## Problem Description
Truck delivers boxes. `boxes[i] = [port, weight]`.
Limits: `maxBoxes` (count), `maxWeight` (sum of weights).
Trip: Storage -> Port A -> Port B ... -> Storage.
Cost: 1 + (number of different adjacent ports) + 1. (1 to go out, 1 to return, moves between ports if different).
Specifically, trips count: loading at storage is start. Delivering at same port consecutively = 0 extra moves. Changing port = 1 extra. Return = 1.
So cost formula for a batch `j \dots i`:
Start at Storage (Trip count starts at 1).
Move Storage -> `port[j]`.
Move `port[k] -> port[k+1]` (if different, +1 trip).
Return `port[i] -> Storage` (+1 trip).
Actually wait, problem says "number of trips".
Is one large voyage considered 1 trip? No.
Usually "trips" implies storage-to-storage cycles.
But here cost is defined as movement. "Trips" in problem title might be misleading or refer to segments.
Let's check example.
`boxes = [[1,1],[2,1],[1,1]]`. Max 3 boxes.
Trip 1: Storage -> P1 -> P2 -> P1 -> Storage.
Segments: S->P1 (1), P1->P2 (1), P2->P1 (1), P1->S (1). Total 4.
So Cost = $2 + \text{changes}$.
`dp[i]` = min cost to deliver first `i` boxes.
`dp[i] = min(dp[j] + cost(j+1 \dots i))`.
`cost(j+1 \dots i)`:
    - `changeCount` in `j+1 \dots i`.
    - `Total = changeCount + 2`.
Constraints: `i - j <= maxBoxes`, `sumWeight(j+1 \dots i) <= maxWeight`.

## Optimization
-   Let `C[i]` be cumulative changes from start `0 \dots i`.
    - `C[i] = C[i-1] + (p[i] != p[i-1] ? 1 : 0)`.
-   Cost of batch `j+1 \dots i`: `C[i-1] - C[j] + 2`. Note indices.
    - `changes` within `j+1 \dots i` is diff between ports from `j+1` to `i`.
    - `p[k] != p[k-1]`.
    - Let's say `diff[k]` is 1 if `port[k] != port[k-1]`.
    - Sum of `diff` from `j+2` to `i`.
    - Let `prefixDiff[x]` be sum of diffs up to `x`.
    - `internalChanges = prefixDiff[i] - prefixDiff[j+1]`.
    - Total Cost = `2 + internalChanges`.
-   `dp[i] = min_{valid j} (dp[j] + 2 + prefixDiff[i] - prefixDiff[j+1])`.
-   `dp[i] = prefixDiff[i] + 2 + min_{valid j} (dp[j] - prefixDiff[j+1])`.
-   This looks like monotonic queue optimization.
-   However, one subtle issue: Does `dp[j] + cost` imply the truck MUST return? Yes.
-   Issue: If `p[j+1] == p[j]`, does our `diff` logic account for `p[j]` being from previous trip?
    - No, previous trip returned to Storage. The new trip starts from Storage.
    - So `p[j]` (last box of prev) and `p[j+1]` (first of new) are separated by Storage.
    - So independence holds.
-   Wait, what if `p[j+1] == p[j]`? Does it matter?
    - `prefixDiff` array counts changes within the boxes array.
    - `dp` logic assumes fresh start.
    - `prefixDiff` is correct.
-   Sliding Window Minimum:
    -   We need min of `dp[j] - prefixDiff[j+1]`.
    -   Constraints on `j`: `i - maxBoxes <= j < i`. And weight constraint.
    -   We can maintain a Deque of indices `j`.
    -   As we advance `i`:
        -   Remove invalid `j` (box count or weight sum).
        -   Current optimal `j` is front of Deque.
        -   Update `dp[i]`.
        -   Add `i` to Deque maintaining monotonicity of `val(i)`.
    -   However, monotonicity might be tricky because `j` range also shrinks from left (weight/count).
    -   Standard Monotonic Queue works.
    -   BUT `prefixDiff[j+1]`? `prefixDiff` depends on `j+1`.
        -   `val(j) = dp[j] - prefixDiff[j+1]`. This value is constant for a fixed `j`. So MQ works.

## Complexity
-   Time: $O(N)$.
-   Space: $O(N)$.

## Implementation Details
-   `long` for weights.
-   Deque.
-   Prefix sums for weight and diffs.
-   Indices carefully: boxes 0-indexed. `dp` size `N+1`.
-   `diff[k]`: does `port[k-1] != port[k]`.
