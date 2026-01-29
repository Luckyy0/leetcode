# Problem Analysis: Maximum Number of Ways to Partition an Array

## Problem Description
Array `nums`. `k`. Change at most one element `nums[i]` to `k`.
Find number of pivots `p` (1 to n-1) such that `sum(left) == sum(right)` is maximized.
`sum(left)` is `nums[0...p-1]`.
Can change 0 or 1 element.

## Analysis

1.  **Prefix Sums and Frequency Maps**:
    -   Total Sum `S`.
    -   Originally (no change), valid pivot `p` if `prefix[p] == S - prefix[p]` => `2 * prefix[p] == S`.
    -   Condition: `prefix[p] == S/2`.
    -   If we change `nums[i]` to `k`, new total sum `S' = S - nums[i] + k`. Diff `d = k - nums[i]`.
    -   New sum `S'`. Need `2 * prefix'[p] == S'`.
    -   For `p <= i` (pivot before/at changed element): `prefix'[p] = prefix[p]`.
        -   Need `2 * prefix[p] == S + d` => `prefix[p] == (S + d) / 2`.
    -   For `p > i` (pivot after changed element): `prefix'[p] = prefix[p] + d`.
        -   Need `2 * (prefix[p] + d) == S + d` => `2 * prefix[p] + 2d == S + d` => `2 * prefix[p] == S - d` => `prefix[p] == (S - d) / 2`.
        
2.  **Algorithm**:
    -   Calculate `TotalSum`.
    -   Store all `prefix[p]` (1 to n-1) in a Frequency Map `countRight`.
    -   Calculate `base` ways (no change).
    -   Iterate `i` (0 to n-1) as the changed element.
        -   Move `prefix[i]` (if i > 0 can be a pivot? No `p` is 1 to n-1) from `countRight` to `countLeft`.
        -   Actually, we process pivots relative to `i`.
        -   Loop `i` from 0 to n-1.
        -   At step `i`, `countLeft` has `prefix[1...i]`, `countRight` has `prefix[i+1...n-1]`.
        -   Wait. `p` ranges from 1 to `n-1`.
        -   Pivot `p` splits `0..p-1` and `p..n-1`.
        -   When `i` is current index (0..n-1):
            -   Pivots `p <= i`: valid if `prefix[p] == (S + d) / 2`. (These are in `countLeft`).
            -   Pivots `p > i`: valid if `prefix[p] == (S - d) / 2`. (These are in `countRight`).
            -   Wait. `p` is index *after* split. e.g. p=1 splits [0] and [1...].
            -   If `p <= i`: split is before `i`. `nums[i]` is in Right part.
            -   So sum(Left) unchanged. sum(Right) changes by d.
            -   `sumL = prefix[p]`. `sumR = (S - prefix[p]) + d`.
            -   `sumL == sumR` => `prefix[p] == S - prefix[p] + d` => `2*prefix[p] == S + d`.
            -   Correct. This matches `p <= i` logic if `i` is in Right part.
            -   Wait. If `p` is split index. `0...p-1`. `i` is index of changed element.
            -   If `i >= p` (element in right part): `prefix[p]` unchanged. Needs `2*prefix[p] == S + d`. Count these `p` in `Left` side of `i`.
            -   If `i < p` (element in left part): `prefix[p]` changed by `d`. Needs `2*prefix[p] == S - d`. Count these `p` in `Right` side of `i`.
            -   Algorithm:
                -   Init `countRight` with all prefixes `p=1` to `n-1`.
                -   Init `countLeft` empty.
                -   Loop `i` from 0 to `n-1`.
                    -   Calc `d = k - nums[i]`. `newS = S + d`.
                    -   If `newS` even:
                        -   Cnt = `countLeft.get(newS/2 + ?)` No.
                        -   Target for Left (`p <= i`): `(S+d)/2`.
                        -   Target for Right (`p > i`): `(S-d)/2`.
                        -   `currWays = countLeft.get((S+d)/2) + countRight.get((S-d)/2)`.
                        -   Update max.
                    -   Update maps: `prefix[i+1]` is a pivot `p=i+1` moving from Right to Left.
                    -   Actually valid pivots are `1...n-1`.
                    -   So at start of loop `i`, `countRight` has `1...n-1`. `countLeft` empty.
                    -   Wait, relationship `p` relative to `i`.
                    -   If we change `nums[i]`:
                        -   For `p` in `1...i`: element `i` is in Right part. Conditions match `p <= i`.
                        -   For `p` in `i+1...n-1`: element `i` is in Left part. Conditions match `p > i`.
                    -   So basically for change at `i`:
                        -   Look up `(S+d)/2` in pivots `1...i`.
                        -   Look up `(S-d)/2` in pivots `i+1...n-1`.
                    -   We need to incrementally maintain counts of pivots available in range `1...i` and `i+1...n-1`.
                    -   `countLeft` stores prefixes for `p <= i`.
                    -   `countRight` stores prefixes for `p > i`.
                    -   Initially `countLeft` empty. `countRight` has all.
                    -   Loop `i` from 0 to `n-1`.
                        -   `p` candidates match `1...i`? No. `p` can be `1...n-1`.
                        -   At start of iteration `i`, we consider changing `nums[i]`.
                        -   Pivots to consider are `1...n-1`.
                        -   Those with `p <= i` are currently in `countLeft`?
                        -   Wait. If `p=i+1`. `p > i`. It's in Right.
                        -   If `p=i`. `p <= i`. It's in Left.
                        -   So yes.
                        -   Do calculate ways.
                        -   Then move `prefix[i+1]` from Right to Left (preparing for next `i+1`).
                        -   (Only if `i+1 < n`).
                        -   Wait. `prefix` array indices. `prefix[x]` is sum `0...x-1`.
                        -   So `prefix[1]` to `prefix[n-1]` are valid pivots.
                        -   In iteration `i`, allowed pivots `p` split into: `1...i` (Left Logic), `i+1...n-1` (Right Logic).
                        -   So move `prefix[i+1]` after checking.

## Implementation Details
-   Prefix Array `long`.
-   Map `Long, Integer`.
