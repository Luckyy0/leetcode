# Problem Analysis: Minimum Length of String After Deleting Similar Ends

## Problem Description
Remove matching prefix and suffix chars. Repeat.

## Analysis

1.  **Two Pointers**:
    -   `l = 0`, `r = n-1`.
    -   While `l < r` and `s[l] == s[r]`:
        -   `char c = s[l]`.
        -   While `l <= r` and `s[l] == c`, `l++`.
        -   While `r >= l` and `s[r] == c`, `r--`.
    -   Result `r - l + 1`.

2.  **Implementation**:
    -   Loop.

## Implementation Details
-   Handle `l > r` (length 0).
