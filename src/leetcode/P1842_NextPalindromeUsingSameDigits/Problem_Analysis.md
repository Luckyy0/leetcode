# Problem Analysis: Next Palindrome Using Same Digits

## Problem Description
Numeric string `num`.
Find next smallest palindrome strictly larger than `num` using same digits.
If none, return empty string.
Palindrome `num` has structure `Half + (Middle) + Reverse(Half)`.
Length `n`.

## Analysis

1.  **Palindrome Structure**:
    -   A palindrome is determined by its first `ceil(n/2)` digits.
    -   Actually, since it uses "same digits", the count of each digit in the palindrome must match `num`.
    -   But `num` is already a palindrome.
    -   So the left half `L` determines the whole palindrome.
    -   If we just permute `L` to get next greater `L'`, and construct palindrome, does it use same digits?
    -   Yes, because palindrome uses 2 of each digit in `L` (except maybe middle). `num` uses same set.
    -   So effectively, we need to find **Next Permutation** of the first `n/2` digits.
    -   Let `half` be `substring(0, n/2)`.
    -   Find next permutation of `half`.
    -   If no next perm (already max), return "".
    -   Else, construct result: `next_half` + (middle digit if odd) + `reverse(next_half)`.
    -   Wait, what if `num` has odd length? e.g. "12321". Half "12". Next perm "21" -> "21312". Correct.
    -   Is it possible to change the middle digit?
    -   If we change middle, we use a digit from the pool. But since we need "Same Digits", the multiset of digits is fixed.
    -   If `n` is odd, middle digit is unique (it has odd count in `num`). All other digits have even count.
    -   We cannot swap middle digit with any digit from `half` IF counts don't align?
    -   Actually, since `num` is a palindrome, counts of all digits except middle are even.
    -   The middle digit MUST remain the middle digit because it's the only one with odd count (or count % 2 == 1, others even + count % 2 == 0).
    -   Wait, if `num` is "121", counts: 1:2, 2:1. Mid must be 2.
    -   So middle digit is fixed.
    -   So we ONLY permute the first `n/2` digits.

2.  **Algorithm**:
    -   Extract `half = num.substring(0, n/2)`.
    -   Get `nextPermutation(half)`.
    -   If fails, return "".
    -   Result `half + mid + reverse(half)`.

## Implementation Details
-   `nextPermutation` implementation. Swap and reverse.
