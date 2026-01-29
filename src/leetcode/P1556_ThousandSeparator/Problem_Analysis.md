# Problem Analysis: Thousand Separator

## Problem Description
Given an integer `n`, add a dot (".") as the thousand separator and return it in string format.

Example:
- Input: `n = 987`
- Output: `"987"`
- Input: `n = 1234`
- Output: `"1.234"`
- Input: `n = 123456789`
- Output: `"123.456.789"`

## Analysis

1.  **Approach**:
    -   Convert the integer to a string or process it digit by digit.
    -   Iterate from the end of the string to the beginning.
    -   Insert a dot after every 3 digits, but not at the very beginning.
    -   Alternatively, use `StringBuilder`. Append digits from right to left. Every 3 digits, valid if more digits remain, append a dot. Finally reverse the string.

2.  **Edge Cases**:
    -   `n = 0`: Output "0".
    -   `n < 1000`: No dots.

3.  **Complexity**:
    -   Time: $O(L)$ where $L$ is number of digits.
    -   Space: $O(L)$ for the result.

## Implementation Details
-   Use `StringBuilder`.
-   Loop `n % 10`, `n /= 10`.
-   Count digits added. If `count % 3 == 0` and `n > 0`, add `.`.
