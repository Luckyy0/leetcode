# Problem Analysis: Ways to Make a Fair Array

## Problem Description
An array is fair if the sum of odd-indexed values equals the sum of even-indexed values.
Return the number of indices `i` such that removing `nums[i]` makes the array fair.
When `nums[i]` is removed, indices of subsequent elements shift left.

## Analysis

1.  **Logic**:
    -   Let `totalEven` and `totalOdd` be sums of even/odd indices initially.
    -   Precompute these. Or maintain prefix sums.
    -   Iterate `i`:
        -   Elements before `i`: Parity unchanged. `prefixEven`, `prefixOdd`.
        -   Elements after `i`: Parity flipped.
        -   `suffixEven` becomes contributions to Odd sum relative to new array.
        -   `suffixOdd` becomes contributions to Even sum.
        -   New Even Sum = `prefixEven + suffixOdd`.
        -   New Odd Sum = `prefixOdd + suffixEven`.
        -   Check equality.
    -   Update prefixes as we iterate.

2.  **Algorithm**:
    -   Compute `totalOdd`, `totalEven`.
    -   `currOdd = 0`, `currEven = 0`.
    -   Loop `i`.
    -   Update `suffixOdd = totalOdd - currOdd - (isOdd?nums[i]:0)`.
    -   Update `suffixEven` similarly.
    -   Check condition.
    -   Update `currOdd/Even` with `nums[i]`.

3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(1)$.

## Implementation Details
-   Careful with index parity.
