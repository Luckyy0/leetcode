# Problem Analysis: Design Bitset

## Problem Description
Class `Bitset(size)`.
-   `fix(idx)`: set bit to 1.
-   `unfix(idx)`: set to 0.
-   `flip()`: all 0->1, 1->0.
-   `all()`, `one()`, `count()`.
-   `toString()`. (Can be O(N)).
-   Others O(1).

## Analysis

1.  **Lazy Flip**:
    -   Maintain `boolean[] bits` (or `int[]` but `size` up to 10^5, `boolean` easy).
    -   `boolean flipped` state.
    -   `cnt` of 1s (logical).
    -   Logic:
        -   `fix(i)`:
            -   If `!flipped`: ensure `bits[i]` is true. If false, set true, `cnt++`.
            -   If `flipped`: ensure `bits[i]` is false (logical 1 means physical 0). If true, set false, `cnt++`.
        -   `unfix(i)`:
            -   Inverse logic.
        -   `flip()`:
            -   `flipped = !flipped`.
            -   `cnt = size - cnt`.
        -   `toString()`:
            -   Build string based on `bits[i] ^ flipped`.

## Implementation Details
-   `StringBuilder`.
-   `size` var.
