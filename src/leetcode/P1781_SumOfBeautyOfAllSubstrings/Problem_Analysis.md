# Problem Analysis: Sum of Beauty of All Substrings

## Problem Description
Beauty of substring: `freq(most_frequent) - freq(least_frequent)`.
Sum of beauty of all substrings.

## Analysis

1.  **Iterate Substrings**:
    -   $N \le 500$. $O(N^2 \cdot 26)$ is acceptable.
    -   Outer loop `i` from 0 to N-1.
    -   Inner loop `j` from `i` to N-1.
    -   Maintain frequency array for substring `s[i..j]`.
    -   Update counts as `j` moves.
    -   Calculate beauty for each `(i, j)` and sum.
    -   Beauty calc: iterate 26 chars to find min (non-zero) and max.

2.  **Complexity**:
    -   Time: $500^2 \times 26 \approx 6.5 \cdot 10^6$. Very fast.
    -   Space: $O(1)$ (freq array).

## Implementation Details
-   `counts[26]`.
