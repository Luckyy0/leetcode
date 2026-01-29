# Problem Analysis: Build the Equation

## Problem Description
Table `Terms` (power, factor).
Build equation string like "3X^2 + 1X + 5".
Format:
-   `factor X^power`.
-   If power 0, just factor.
-   If power 1, `X` (or `1X`?). Problem says `factorX`. Example `+1X`.
-   Wait. Examples: `+3X^2`, `-4X^1`. Ah, specific format?
-   Usually LHS = RHS.
-   "LHS = sum of terms".
-   "You should format... factorX^power".
-   "Append + or - based on factor sign".
-   "Sort by power DESC".
-   Output: `equation`. e.g. `+3X^2-5X^1+7`.

## Analysis

1.  **Format and Concat**:
    -   Sort by power desc.
    -   Iterate.
    -   Sign: `+` if > 0, `-` if < 0. (For first term too? Example Output: `+3X^2...`. Yes).
    -   Format: `factor` `X^` `power`.
    -   Power 0: `factor` (no X^0).
    -   Power 1: `factorX^1`. (Example 1: `-4X^1`).
    -   Add to result string.
    -   `GROUP_CONCAT` in SQL?
    -   Order by power DESC.
    -   Concat.

## Implementation Details
-   `CONCAT` function.
-   `CASE` for formatting.
