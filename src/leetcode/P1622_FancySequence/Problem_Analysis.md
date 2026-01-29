# Problem Analysis: Fancy Sequence

## Problem Description
Implement the `Fancy` class:
-   `Fancy()` Initializes.
-   `void append(int val)` Appends an integer `val` to the end of the sequence.
-   `void addAll(int inc)` Increments all existing values in the sequence by `inc`.
-   `void multAll(int m)` Multiplies all existing values in the sequence by `m`.
-   `int getIndex(int idx)` Gets the current value at index `idx` (0-indexed) modulo $10^9 + 7$. If index >= length, return -1.

## Analysis

1.  **Lazy Propagation Strategy**:
    -   We cannot update all elements on every `addAll` or `multAll`.
    -   Maintain global multipliers `mul` and `add` representing the transformation applied to the *entire* sequence relative to their "stored state".
    -   Value at index `i` is derived from: `Result = (StoredVal[i] * mul + add) % MOD`.
    -   When `append(val)` is called, we need to reverse the current global transform to store the "raw" value `StoredVal`.
        -   We want `(StoredVal * mul + add) % MOD == val`.
        -   `StoredVal * mul = (val - add) % MOD`.
        -   `StoredVal = ((val - add) * modInverse(mul)) % MOD`.
    -   When `addAll(inc)`: `add = (add + inc) % MOD`.
    -   When `multAll(m)`: `mul = (mul * m) % MOD`, `add = (add * m) % MOD`.

2.  **Implementation**:
    -   `ArrayList` for stored values.
    -   Modular Inverse using Fermat's Little Theorem (power(a, MOD-2)).
    -   `long` arithmetic to prevent overflow before modulo.

3.  **Complexity**:
    -   All operations $O(1)$ (amortized) or $O(\log MOD)$ for modular inverse.
    -   GetIndex: $O(1)$.
    -   Append: $O(\log MOD)$.

## Implementation Details
-   `MOD = 1000000007`.
