# Problem Analysis: Maximum Number of Weeks for Which You Can Work

## Problem Description
Array `milestones`. Project `i` has `milestones[i]` units.
Cannot work on same project two consecutive weeks.
Maximize total weeks.

## Analysis

1.  **Math**:
    -   Let `max` be the project with most milestones.
    -   Let `sum` be total milestones.
    -   Let `rest = sum - max`.
    -   If `max > rest + 1`: We can only work `2 * rest + 1` weeks (interleaving rest projects around max).
    -   Else: We can finish all projects (`sum` weeks). (We can always interleave).
    -   Logic: "Gap filling".

## Implementation Details
-   `long` sum.
