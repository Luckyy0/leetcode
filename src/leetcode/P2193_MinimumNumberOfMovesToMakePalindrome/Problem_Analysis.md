# Problem Analysis: Minimum Number of Moves to Make Palindrome

## Problem Description
String `s`. Allowed swap adjacent.
Min swaps to make palindrome.

## Analysis

1.  **Greedy**:
    -   Find matching character for `s[0]` (usually the last occurrence of that char).
    -   Move it to the end (`n-1`).
    -   Cost = distance moved.
    -   If `s[0]` has no other occurrence (it's the unique center char):
        -   Move `s[0]` to the CENTER.
        -   Cost = dist to `n/2`.
    -   Recursively solve for `s[1...n-2]`.
    -   Two pointers `left`, `right`.
    -   Match `s[left]` with a char at index `k` closest to `right`.
    -   Swap `s[k]` step-by-step to `right`.
    -   Increment `left`, decrement `right`.

## Implementation Details
-   Convert to `char[]`.
-   Pointers `l=0`, `r=n-1`.
-   While `l < r`:
    -   Find `k` from `r` downwards s.t. `chars[k] == chars[l]`.
    -   If `k == l` (unique center):
        -   Swap `chars[l]` with `chars[l+1]`. Steps++.
        -   Don't increment `l/r`, re-evaluate.
        -   Or simpler: Just account for cost to move `l` to `n/2`? No, because moving it changes positions of others.
        -   Better: Leave it for now, deduce it MUST be at center steps later?
        -   Actually, standard greedy approach for unique char: count steps to move it to middle, but logical execution is hard.
        -   Standard fix: When `k == l` found, this char belongs to center. Don't process it as pair. Just swap it with neighbor to "bubble it towards center" and continue?
        -   Actually, if we find unique char, we can skip it? No.
        -   Correct Approach for unique char:
            -   Cost is `n/2 - current_pos`.
            -   BUT moving it affects others.
            -   Just swap `chars[l]` with `chars[l+1]` once, increment steps, then reset loop at same `l`. This effectively bubbles it rightwards until it finds a pair or reaches center.

## Implementation Details
-   Outer loop `l < r`. Inner search.
