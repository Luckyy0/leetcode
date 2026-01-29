# Problem Analysis: Maximum Alternating Subarray Sum

## Problem Description
Array `nums`. Alternating subarray sum: $x_1 - x_2 + x_3 - x_4 \dots$.
Max sum.

## Analysis

1.  **Dynamic Programming (Kadane's Variant)**:
    -   `dp0[i]`: Max alternating sum ending at `i` (where `nums[i]` is added: $+x_1 \dots + nums[i]$).
    -   `dp1[i]`: Max alternating sum ending at `i` (where `nums[i]` is subtracted: $+x_1 \dots - nums[i]$).
    -   Transitions:
        -   `dp0[i]`: Either `nums[i]` starts new subarray, or continues from `dp1[i-1]`.
            -   `dp0[i] = max(nums[i], dp1[i-1] + nums[i])`. (Note `dp1` ended with subtraction, so adding `nums[i]` is valid next $+$.)
        -   `dp1[i]`: Must continue from `dp0[i-1]`. `nums[i]` cannot start subarray (starts with +).
            -   `dp1[i] = dp0[i-1] - nums[i]`.
    -   Result `max(dp0)`. (Ending with - is possible? Yes. Subarray sum can end with either).
    -   Wait. Subarray sum formula $x_1 - x_2 + x_3 - x_4$.
    -   If length 1: $x_1$. (Ends with +).
    -   If length 2: $x_1 - x_2$. (Ends with -).
    -   So yes, can end with + (Odd length) or - (Even length).

## Implementation Details
-   `long` DP variables.
-   Loop.
