# Problem Analysis: Lexicographically Smallest String After Applying Operations

## Problem Description
You are given a string `s` of even length consisting of digits from 0 to 9, and two integers `a` and `b`.
You can apply either of the following two operations any number of times:
1.  **Add a**: Add `a` to all odd indices (0-indexed). Digits wrap around (mod 10).
2.  **Rotate b**: Rotate the string to the right by `b` positions.
Return the lexicographically smallest string.

## Analysis

1.  **Graph Search (BFS)**:
    -   The state space is relatively small.
    -   Length of `s` is $N \le 100$.
    -   Number of rotations is $N$.
    -   Number of additions to odd indices is 10.
    -   If `b` is odd, we can bring odd indices to even positions. Thus we can modify both odd and even indices independently (10 choices for odds * 10 choices for evens = 100 variations).
    -   If `b` is even, we can only modify odd indices (10 variations).
    -   Total states $\le N \times 100$. Max $100 \times 100 = 10000$. Very small.
    -   BFS is sufficient.

2.  **Algorithm**:
    -   Queue of Strings.
    -   Set of visited Strings.
    -   Track `minString`.
    -   While queue not empty:
        -   Start `curr`. Update `minString`.
        -   Op1: Add `a` to odd indices. Push if new.
        -   Op2: Rotate by `b`. Push if new.

3.  **Complexity**:
    -   Time: $O(States \times N)$.
    -   Space: $O(States \times N)$.

## Implementation Details
-   String manipulation helper.
-   Rotation: `s.substring(n-b) + s.substring(0, n-b)`.
