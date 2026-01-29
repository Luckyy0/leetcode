# Problem Analysis: Number of Pairs of Interchangeable Rectangles

## Problem Description
Array `rectangles` (width, height).
Two rectangles interchangeable if ratio `width/height` is same.
Count pairs `(i, j)` with `i < j`.

## Analysis

1.  **Ratio Map**:
    -   Compute ratio `w/h`. Use double? Precision issues.
    -   Better: Use simplified fraction `w/gcd(w, h), h/gcd(w, h)`.
    -   Or simply `double` if constraints allow (usually precision is fine for 10^5, but fraction safe).
    -   Map `String "num:den"` -> `count`.
    -   Pairs = `count * (count - 1) / 2`.

## Implementation Details
-   `long` count.
-   `gcd`.
