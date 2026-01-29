# Problem Analysis: Maximum Distance Between a Pair of Values

## Problem Description
`nums1`, `nums2`. Sorted non-increasing.
Max `j - i` such that `i <= j` and `nums1[i] <= nums2[j]`.

## Analysis

1.  **Two Pointers**:
    -   Since arrays are sorted descending:
    -   We want largest `j`.
    -   Start `i = 0`, `j = 0`.
    -   If `nums1[i] <= nums2[j]`: valid pair. We want to increase `j` to maximize diff?
        -   Actually, we can try to increase `j` as much as possible for current `i`.
        -   Wait, if we increment `j`: `nums2[j]` decreases.
        -   So for a fixed `i`, we want the largest `j` where `nums2[j] >= nums1[i]`.
        -   Since `nums2` is decreasing, the valid `j`s are a prefix `0...k`.
        -   However, condition `j >= i`.
    -   Alternative:
        -   Iterate `i`. Find largest `j >= i` with `nums2[j] >= nums1[i]`.
        -   Since `nums1[i]` decreases as `i` increases? No, `nums1` is sorted non-increasing. So `nums1` decreases.
        -   If `i` increases, `nums1[i]` becomes smaller (or equal).
        -   As `nums1[i]` becomes smaller, it's easier to satisfy `nums1[i] <= nums2[j]`.
        -   Does that mean `j` can increase? Yes.
        -   But wait, `j` must be `j >= i`.
        -   Let's restart logic.
        -   `i` moves 0 to n.
        -   `j` starts at 0.
        -   We want to match `i`. We should move `j` forward as long as `nums1[i] <= nums2[j]`.
        -   But `nums2` decreases. So if `nums1[i] <= nums2[j]`, then for `j+1`, `nums2[j+1]` is smaller. Can we still match?
        -   If we move `j`, `nums2` gets smaller. Eventually `nums2[j] < nums1[i]`.
        -   Wait, thinking about `Two Pointers` direction.
        -   If we increment `j` as long as `nums1[i] <= nums2[j]`, we are looking for the *last* valid `j`.
        -   BUT `nums2` is decreasing. `nums1[i] <= nums2[j]` holds for small `j`. Fails for large `j`.
        -   So for fixed `i`, we want the *largest* `j` (rightmost) satisfying condition.
        -   Since increasing `i` decreases `nums1[i]`, the valid range of `j` *expands* to the right (since smaller `nums1` fits under smaller `nums2`).
        -   So `j` only moves right.
        -   If `nums1[i] > nums2[j]`, `j` is too far right (value too small). We can't use this `j`. But wait, valid `j`s are to the left.
        -   We want `max(j-i)`.
        -   Let's structure loop:
            -   Iterate `i` from 0.
            -   Maintain `j` such that `nums1[i] <= nums2[j]`. We want `j` max.
            -   Wait. If `nums1` decreases, then for `i+1`, valid `j` can be larger.
            -   So `j` increases.
            -   Loop `i`. While `j+1 < n2` and `nums1[i] <= nums2[j+1]`: `j++`.
            -   Update max dist with `j - i` (if `j >= i`).
            -   BUT, does `j` start from scratch? No, monotonic.
            -   Also if `nums1[i] > nums2[j]`, this `j` is invalid for `i`? No, if `nums2` is decreasing, `nums2[j]` is small, so `nums1[i]` being large fails.
            -   Wait.
            -   `nums1[i] <= nums2[j]`.
            -   Start `i=0, j=0`.
            -   If `nums1[i] <= nums2[j]`: valid. Maybe `j` can go further?
                -   `j` explores to the right until bound breaks.
                -   Correct logic: As `i` increases, `nums1[i]` decreases. The constraint `nums1[i] <= nums2[j]` becomes looser.
                -   So valid `j` can only move right.
                -   Inner loop: while `j + 1 < n2` and `nums1[i] <= nums2[j+1]`: `j++`.
                -   BUT wait, what if `nums1[i] > nums2[j]` initially? (Start condition).
                -   We need `j` valid.
                -   Actually, we should iterate `i` and advance `j` carefully.
                -   Wait, if `nums1` is large initially, `j` might need to be small.
                -   Actually simpler: `i` iterates. `j` iterates.
                -   Condition: for `i`, find largest `j`.
                -   Start `i=0, j=0`.
                -   Loop while `i < n1` and `j < n2`:
                    -   If `nums1[i] <= nums2[j]`:
                        -   Potential candidate `j - i`.
                        -   Since `nums1[i]` works with `nums2[j]`, and `nums2` decreases, `nums2[0..j]` also work. We want max `j`. So try `j++`.
                        -   Wait. If `nums1[i] <= nums2[j]`, we increment `j` to find a *larger* index (smaller value) that still works? No, if we increment `j`, value drops. Maybe it stops working.
                        -   If we increment `j`, we check `nums2[j+1]`.
                        -   If it still works, good.
                        -   Wait, `j` moves right. `i` waits.
                    -   Else (`nums1[i] > nums2[j]`):
                        -   Values at `j` (and further right) are too small for `nums1[i]`.
                        -   We must decrease `nums1[i]`? i.e., increment `i`.
                        -   So `i++`.
    -   Correct Logic:
        -   While `i < n1 && j < n2`:
            -   If `nums1[i] <= nums2[j]`:
                -   Valid. Record `j - i`.
                -   Try to extend `j`? `j++`.
            -   Else:
                -   Invalid. Need smaller `nums1`. `i++`.
    -   This works. Does it find max?
        -   If `(i, j)` is optimal.
        -   We reach `i`. `j` will advance until it passes optimal `j`.
        -   Wait. If at `j_opt`, `nums1[i] <= nums2[j_opt]`. `j` becomes `j_opt + 1` (where it fails presumably). Then we fail, `i` increments.
        -   We recorded `j_opt - i`.
        -   If we increment `i`, `nums1[i+1]` is smaller. Maybe `nums2[j+1]` works now?
        -   Yes.
    -   Does it matter if we skip `j`s for `i`?
        -   If `nums1[i] <= nums2[j]`, we inc `j`. We record `j-i`.
        -   But next `j+1` might fail. Then we increment `i`. At `i+1`, valid `j` might be `j+1`. record `j+1 - (i+1)`. (Same diff).
        -   Wait. Is it guaranteed to find MAX distance?
        -   Suppose optimal is `i*, j*`.
        -   If we reach `i*` and `j < j*`: we inc `j` until `j*`. Record. Then `j` goes `j*+1` (fail). Then `i` inc.
        -   If we reach `j*` and `i < i*`: we have `nums1[i] >= nums1[i*]`.
        -   If `nums1[i] <= nums2[j*]`, we inc `j` past `j*`. We got `j* - i`. Since `i < i*`, `j* - i > j* - i*`. Better pair!
        -   So if `nums1[i] <= nums2[j]`, we always potentially find better (smaller `i`, larger `j`).
        -   Correct.

## Implementation Details
-   While loop.
