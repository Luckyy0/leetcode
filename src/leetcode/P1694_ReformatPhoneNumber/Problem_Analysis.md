# Problem Analysis: Reformat Phone Number

## Problem Description
Remove spaces/dashes.
Group digits:
-   Len > 4: group of 3.
-   Len == 4: two groups of 2.
-   Len == 3: one group of 3.
-   Len == 2: one group of 2.

## Analysis

1.  **Iterative**:
    -   Filter digits.
    -   Loop until `len <= 4`.
    -   Take 3, append '-'. Reduce.
    -   Handle remainder.

## Implementation Details
-   `StringBuilder`.
