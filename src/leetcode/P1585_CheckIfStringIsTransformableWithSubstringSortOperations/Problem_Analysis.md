# Problem Analysis: Check If String Is Transformable With Substring Sort Operations

## Problem Description
Given two strings `s` and `t`, return `true` if `s` can be transformed into `t` by sorting substrings. You can sort any substring of `s` any number of times.

## Analysis

1.  **Operation Interpretation**:
    -   Sorting a substring allows elements to move relative to each other.
    -   Key insight: We can move a character `d` to the left past a character `large` if `d < large`.
    -   Why? If we have `...large...d...`, we can sort the substring covering them. Since `d < large`, `d` will end up to the left of `large`.
    -   However, we *cannot* move `d` to the left past a character `small` if `d > small`.
    -   Why? Sorting puts smaller elements first. Sorting `...small...d...` (where `small < d`) keeps `small` to the left of `d`. `d` can never jump over `small` to the left.
    -   Conclusion: We can move the required character `d` from `s` to the current target position in `t` ONLY IF there are no smaller characters blocking it (to its left in `s` among the unused characters).

2.  **Algorithm**:
    -   Store positions of each digit `0-9` in `s` in queues (to process them in order).
    -   Iterate through `t`. For each character `c` (converted to int `reqDigit`):
        -   Check if `s` has this digit available (queue[reqDigit] not empty).
        -   Check if any smaller digit `small < reqDigit` appears *before* this instance of `reqDigit` in `s`.
        -   Specifically: Check `queues[small].peek() < queues[reqDigit].peek()`.
        -   If `queues[small].peek() < current_pos`, then `small` is obstructing `reqDigit`. Return `false`.
        -   (Note: We only care about available instances, so peeking gives the leftmost unused occurrence).
        -   If no obstruction, we "use" this character. Poll from `queues[reqDigit]`.

3.  **Complexity**:
    -   Time: $O(N)$ (Iterate `t` once, inner loop 10 times).
    -   Space: $O(N)$ (Queues store indices).

## Implementation Details
-   `ArrayList<Deque<Integer>>` or array of Deques.
