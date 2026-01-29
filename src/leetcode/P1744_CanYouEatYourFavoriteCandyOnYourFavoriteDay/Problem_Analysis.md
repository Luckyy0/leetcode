# Problem Analysis: Can You Eat Your Favorite Candy on Your Favorite Day?

## Problem Description
`candiesCount[i]` is count of type `i`. Types are ordered 0, 1, ...
Queries `[type, day, cap]`.
Can you eat a candy of `type` on `day` (0-indexed) given daily eating capacity `cap`?
Rules:
-   Must finish type `i-1` before eating type `i`.
-   Must eat at least 1 candy per day.
-   Cannot eat more than `cap` candies per day.

## Analysis

1.  **Prefix Sums**:
    -   `prefix[i]`: total candies of types `0` to `i`.
    -   To eat type `type`, we must have eaten at least `prefix[type-1]` candies (previous types).
    -   And we can't have eaten more than `prefix[type]` candies before reaching our target inside `type`.
    -   On `day`:
        -   Min candies eaten so far (day 0 to day): `day + 1` (1 per day).
        -   Max candies eaten so far (day 0 to day): `(day + 1) * cap`.
    -   To successfully eat type `type` on `day`, there must be an overlap between `[minEaten, maxEaten]` and the range `(prefix[type-1], prefix[type]]`.
    -   Range of candies of `type`: `starts at prefix[type-1] + 1`, ends at `prefix[type]`.
    -   Condition:
        -   `maxEaten >= starts` (We can reach the first candy of this type).
        -   `minEaten <= ends` (We haven't been forced to eat ALL candies of this type before today).

2.  **Implementation**:
    -   Careful with `long` for sums and days.
    -   `prefix[-1] = 0`.

3.  **Complexity**:
    -   Time: $O(N + Q)$.
    -   Space: $O(N)$.

## Implementation Details
-   `long[] prefix`.
