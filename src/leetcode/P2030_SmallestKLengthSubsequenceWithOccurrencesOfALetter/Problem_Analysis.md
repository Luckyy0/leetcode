# Problem Analysis: Smallest K-Length Subsequence With Occurrences of a Letter

## Problem Description
String `s`, length `n`.
Find subsequence of length `k`.
Must contain specific char `letter` at least `repetition` times.
Minimize lexicographically.

## Analysis

1.  **Monotonic Stack with Constraints**:
    -   Standard lexicographical smallest subsequence: Monotonic stack.
    -   Constraints:
        -   Length exactly `k`.
        -   Count of `letter` $\ge$ `repetition`.
    -   Total available `letter` = `count_in_s`.
    -   When popping element from stack:
        -   Can pop if we have enough elements remaining to fill `k`.
        -   Can pop `letter` ONLY if we have enough `letter`s remaining to meet `repetition`.
    -   When pushing:
        -   Push if stack size < `k`.
        -   BUT need to reserve space for required `letter`s.
        -   If `repetition` needed > `k - stack.size()`, we MUST push `letter`. (Actually handle implicitly by popping logic).
    
2.  **Implementation**:
    -   `suffix_letter_count` array.
    -   Stack (StringBuilder).
    -   Iterate `i` from 0 to n-1.
    -   While stack not empty and `stack.top > s[i]`:
        -   Check if safe to pop:
            -   `stack.size() + (n - i - 1) >= k` (enough length).
            -   If `stack.top == letter`: check `current_letters_in_stack - 1 + suffix_letters >= repetition`.
            -   If safe: pop.
    -   Push `s[i]`:
        -   If `stack.size() < k`.
        -   Check if we are forced to skip? No logic handles popping. Now handle pushing.
        -   Is it always optimal to push if space?
        -   Problem: We might fill stack with non-letters, and run out of space for required letters.
        -   Condition to push:
            -   If `s[i] == letter`: push (if `stack.size() < k`).
            -   If `s[i] != letter`: push ONLY if `k - stack.size() > needed_letters`.
                -   `needed = max(0, repetition - current_letters_in_stack)`.
                -   If `k - size > needed`, we have spare slots for non-letters.
    -   Result is stack content.

## Implementation Details
-   `StringBuilder`.
-   Suffix counts.
