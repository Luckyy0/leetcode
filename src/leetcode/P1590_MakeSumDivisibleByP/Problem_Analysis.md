# Problem Analysis: Make Sum Divisible by P

## Problem Description
Given an array of positive integers `nums`, remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by `p`. It is not allowed to remove the whole array.
Return the length of the shortest subarray. If impossible, return -1.

## Analysis

1.  **Math Formulation**:
    -   Let Total Sum be $S$.
    -   We want $(S - \text{subarraySum}) \% p == 0$.
    -   This implies $S \% p == \text{subarraySum} \% p$.
    -   Let `target = S % p`. If `target == 0`, return 0.
    -   We need to find a subarray `nums[j...i]` such that `sum(j...i) % p == target`.

2.  **Range Sum with Modulo**:
    -   Subarray Sum `sum(j...i) = prefix[i] - prefix[j-1]`.
    -   We need `(prefix[i] - prefix[j-1]) % p == target`.
    -   `prefix[i] % p - prefix[j-1] % p == target` (modulo arithmetic applies).
    -   Actually `(prefix[i] - prefix[j-1]) % p = target` means:
        -   `prefix[i] = k*p + r1`
        -   `prefix[j-1] = k'*p + r2`
        -   `(r1 - r2) % p = target`.
        -   `r2 = (r1 - target + p) % p`.
    -   So for current `prefix[i]`, we need to find a previous index `prev` such that `prefix[prev] % p == (prefix[i] % p - target + p) % p`.

3.  **Algorithm**:
    -   Compute `totalSum % p` => `target`.
    -   Use a dictionary `lastPos` mapping `remainder -> index`.
    -   Initialize `lastPos[0] = -1` (handling prefix starting from 0).
    -   Run accumulating sum `curr`. `currRem = curr % p`.
    -   Calculate `needed = (currRem - target + p) % p`.
    -   If `needed` exists in `lastPos`, `len = i - lastPos[needed]`.
    -   Update `minLen`.
    -   Update `lastPos[currRem] = i`.
    -   Check bound: if `minLen == n`, return -1.

4.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(N)$ (Or O(P) since remainders are < P? No, min(N, P)).

## Implementation Details
-   Use `HashMap`.
-   Handle sums with `long` just in case, though modulo logic avoids overflow if done step-by-step.
