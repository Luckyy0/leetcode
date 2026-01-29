# Problem Analysis: Maximum Product of the Length of Two Palindromic Subsequences

## Problem Description
String `s`. Find two **disjoint** palindromic subsequences. Maximize product of lengths.
$N \le 12$. Small!

## Analysis

1.  **Bitmask / Bruteforce**:
    -   $N=12 \implies 2^{12} = 4096$ masks.
    -   For each mask, check if it forms a palindrome.
    -   Store `maxLength[mask]`? Actually store `palindromeMasks` and their lengths.
    -   Iterate all pairs of disjoint masks `m1, m2` (`m1 & m2 == 0`).
    -   Product `len(m1) * len(m2)`.
    -   Optimization:
        -   Precompute `isPalindrome(mask)` and `length(mask)`.
        -   Only iterate `m1` that are palindromes.
        -   Iterate `m2` that are palindromes and disjoint.
        -   $N=12 \implies 4096$. Iterate pairs $4096^2$ too slow ($1.6 \times 10^7$).
        -   Wait, $10^7$ is fine in Java (1 sec ~ $10^8$ ops).
        -   But many masks aren't palindromes. List valid palindromic masks.
        -   Usually number of palindromic/valid masks is small.
        -   Let's collect mask and length in a list.
        -   Loop list vs list.

## Implementation Details
-   `checkPalindrome(mask)`.
