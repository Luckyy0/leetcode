# Problem Analysis: Smallest Greater Palindrome

## Problem Description
Given a string `n` of digits.
Find the **smallest palindrome** integer that is strictly greater than `n`.
If no such palindrome exists with same number of digits, return smallest with `n.length + 1` digits (which is `10...01`).
Actually if result doesn't fit in standard integers? LeetCode usually assumes string input/output handles large numbers.
Wait, specific problem constraints for P1999?
"Smallest Greater Palindrome" usually implies general palindrome logic.
But check if P1999 is standard or specific (e.g. constraints on length).
Assuming standard "Next Palindrome" problem logic.

## Analysis

1.  **Next Palindrome Algorithm**:
    -   Case 1: Same number of digits.
        -   Take left half of `n`.
        -   Create palindrome `P` by mirroring left half.
        -   If `P > n`, return `P`.
        -   If `P <= n`:
            -   Increment the left half (add 1).
            -   Create new palindrome `P'`.
            -   Return `P'`.
            -   (Note: Incrementing might increase digits. E.g. 99 -> 100).
    -   Case 2: Incrementing left half causes length increase (e.g. `99` -> `101`).
    -   Edge Case: All 9s. `999` -> `1001`.

2.  **Implementation**:
    -   Parse string.
    -   Helper `makePalindrome`.

## Implementation Details
-   `String`. `long` if fits.
-   Handling increment logic on string.
