# Problem Analysis: Plates Between Candles

## Problem Description
String `s` ('*', '|').
Queries `[left, right]`.
Find substring `s[left...right]`.
Count plates ('*') that are between two candles ('|').
Plates outside outermost candles in the substring don't count.

## Analysis

1.  **Prefix Sums and Nearest Neighbors**:
    -   `prefixPlates[i]`: count of '*' in `s[0...i]`.
    -   Plates in `s[L...R]` is `prefix[R] - prefix[L-1]`. But we only count those between candles.
    -   Within `[L, R]`, find the *leftmost* candle at index `candle_left` (where `candle_left >= L`) and *rightmost* candle at index `candle_right` (where `candle_right <= R`).
    -   If `candle_left < candle_right`:
        -   Count is `count('*' between candle_left and candle_right)`.
        -   `prefixPlates[candle_right] - prefixPlates[candle_left]`.
    -   If `no valid candles` or `candle_left >= candle_right`: Count 0.
    
2.  **Preprocessing**:
    -   `nextCandle[i]`: index of first candle $\ge i$.
    -   `prevCandle[i]`: index of first candle $\le i$.
    -   `prefixPlates[i]`. `s[i] == '*' ? 1 : 0`.
    
3.  **Query**:
    -   L, R.
    -   `c_L = nextCandle[L]`.
    -   `c_R = prevCandle[R]`.
    -   If `c_L != -1` and `c_R != -1` and `c_L < c_R`:
        -   Ans = `prefixPlates[c_R] - prefixPlates[c_L]`.

## Implementation Details
-   Precompute arrays.
