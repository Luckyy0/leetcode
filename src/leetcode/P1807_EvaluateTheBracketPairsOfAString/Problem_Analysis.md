# Problem Analysis: Evaluate the Bracket Pairs of a String

## Problem Description
String `s` with pairs `(key)`. `knowledge` list of `[key, value]`.
Replace `(key)` with value. If not found, "?".

## Analysis

1.  **HashMap + Parsing**:
    -   Put knowledge in Map.
    -   Parse `s`. `(` starts key capture. `)` ends it.
    -   Append non-key parts directly.
    -   Look up key.

## Implementation Details
-   `StringBuilder`.
