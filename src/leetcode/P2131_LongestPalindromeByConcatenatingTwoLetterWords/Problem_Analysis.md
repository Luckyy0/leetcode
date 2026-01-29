# Problem Analysis: Longest Palindrome by Concatenating Two Letter Words

## Problem Description
Array `words` of 2-letter strings.
Select some, concatenate to form palindrome. Max length.

## Analysis

1.  **HashMap Matching**:
    -   Count frequencies.
    -   Two types:
        1.  `ab` (where a != b): Needs `ba` to pair. Take `min(count[ab], count[ba]) * 2`.
            -   This forms `ab...ba`. Length `min * 4`.
            -   Process pair once (ignore `ba` when seeing `ab`).
        2.  `aa` (same chars): Can pair with itself `aa...aa`.
            -   Pairs `count[aa] / 2`. `len += pairs * 4`.
            -   Leftover `aa`: Can use ONE in the middle. `middle = true`.
    -   Final Length: `pairedLength + (middle ? 2 : 0)`.

## Implementation Details
-   `Map<String, Integer> freq`.
-   Iterate keys.
-   Handle duplicates carefully (iterate unique set).
