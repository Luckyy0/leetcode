# Problem Analysis: Max Number of K-Sum Pairs

## Problem Description
You given an integer array `nums` and integer `k`.
In one operation, picking two numbers adding up to `k` and remove them.
Max number of operations.

## Analysis

1.  **Count Frequencies**:
    -   Map `val -> count`.
    
2.  **Iterate and Pair**:
    -   Iterate keys in Map.
    -   For `num`, find `comp = k - num`.
    -   If `comp == num`: `pairs += count / 2`.
    -   If `comp != num` and `comp` exists:
        -   We need to handle pair `(num, comp)` only once.
        -   Can iterate keys, process if `num < comp`.
        -   `pairs += min(count[num], count[comp])`.
    -   Or iterate all keys, but divide non-equal pair counts by 2? No, `min(a, b)` can't be summed simply.
    -   Correct approach: Iterate keys. If map contains `comp`:
        -   `take = min(map.get(num), map.get(comp))`.
        -   If `num == comp`, `take = count / 2`.
        -   If processed `(num, comp)` (e.g. `num > comp`), skip. (Assuming we iterate distinct keys).
        -   Wait, easier:
            -   Iterate `nums` array. If map has `target` with count > 0, decrement `target` count, ops++. Else increment `num` count.
            -   This is one-pass greedy.

3.  **One Pass Algorithm**:
    -   `Map<Integer, Integer> map`. `ops = 0`.
    -   Loop `x` in `nums`:
        -   `target = k - x`.
        -   If `map.getOrDefault(target, 0) > 0`:
            -   `ops++`.
            -   `map.put(target, count - 1)`.
        -   Else:
            -   `map.put(x, count + 1)`.
    -   This works perfectly.

4.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(N)$.

## Implementation Details
-   `HashMap`.
