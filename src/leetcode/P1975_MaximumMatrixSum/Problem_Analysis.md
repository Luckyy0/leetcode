# Problem Analysis: Maximum Matrix Sum

## Problem Description
`matrix` (n x n).
Operation: Check any two adjacent cells, multiply both by -1.
Can perform any number of times.
Maximize sum of matrix elements.

## Analysis

1.  **Parity of Negatives**:
    -   Operation flips two signs. Does NOT change parity of count of negative numbers?
    -   If we flip two negative -> two positive. (Neg count - 2).
    -   If we flip one neg, one pos -> one pos, one neg. (Neg count same).
    -   If we flip two pos -> two neg. (Neg count + 2).
    -   Conclusion: We can change signs of any PAIR of numbers.
    -   We can move "negative signs" around the grid arbitrarily (since connected).
    -   If total count of negative numbers is EVEN, we can eliminate ALL negative signs.
        -   Sum = Sum of absolute values.
    -   If total count of negative numbers is ODD, we must have exactly ONE negative number remaining.
        -   To maximize sum, we should make the smallest absolute value negative.
        -   Sum = Sum(abs) - 2 * min(abs). (Subtract it twice because we added it in sum(abs) but need to subtract).

## Implementation Details
-   Sum absolute values.
-   Count negatives.
-   Track min absolute value.
