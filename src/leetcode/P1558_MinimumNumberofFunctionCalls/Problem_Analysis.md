# Problem Analysis: Minimum Numbers of Function Calls to Make Target Array

## Problem Description
You are given an integer array `nums`. You have an integer array `arr` of the same length with all values set to `0`.

In one operation, you can:
1.  Choose any index `i` and set `arr[i] = arr[i] + 1` (Increment).
2.  Set all values in `arr` to `arr[i] * 2` (Double all).

Return the minimum number of operations to modify `arr` to become `nums`.

## Analysis

1.  **Reverse Thinking**:
    -   Instead of building `0` to `nums`, let's reduce `nums` to `0`.
    -   Reverse operations:
        1.  Decrement a specific `nums[i]` (only if `nums[i] > 0`).
        2.  Divide all `nums[i]` by 2 (only if all non-zero `nums[i]` are even).

2.  **Greedy Strategy**:
    -   Division by 2 is very powerful (reduces value exponentially). We want to use it as much as possible.
    -   However, strictly applying "Divide all if all are even" might be complex to synchronize.
    -   Let's look at each number independently in binary representation.
    -   To form a number $X$:
        -   The number of increments (+1) needed is exactly the number of set bits (1s) in binary $X$.
        -   The number of doublings needed is related to the position of the most significant bit.
    -   Since the "Double all" operation applies to the entire array simultaneously, the doublings are shared.
    -   The increments are specific to each number.

3.  **Calculation**:
    -   **Increments**: For each `num` in `nums`, add `Integer.bitCount(num)` to the total operations. These are the operations to set the specific bits.
    -   **Doublings**: The doubling operations are shared. The number of doublings required is the maximum bit length among all numbers (minus 1, since we start at 0, but effectively it's the max power of 2 needed).
    -   More precisely: if `max_val` is the maximum number in `nums`, we need roughly `log2(max_val)` doublings.
    -   Example: `nums = [1, 5]`. 1 is `1`, 5 is `101`.
        -   1 needs 0 doublings (just +1).
        -   5 needs 2 doublings (1 -> 10 -> 100 -> 101 approx).
        -   Since we do them together, we need `max(doublings for 1, doublings for 5)` = 2.
    -   Total Operations = `Sum(bitCounts) + Max(MostSignificantBitPos)`.

4.  **Refinement**:
    -   Wait, strictly speaking, 0 doesn't need any operations.
    -   For a number `x`, let `b` be number of bits.
    -   If `x=0`, 0 ops.
    -   If `x > 0`:
        -   Increments = `bitCount(x)`
        -   Doublings step contribution = `bitLength(x) - 1`.
    -   The total doublings is simply `max(bitLength(x) - 1)` across all `x` (assuming at least one non-zero). If all are 0, then 0.

5.  **Complexity**:
    -   Time: $O(N \cdot \log(\text{max\_val}))$. Since integers are 32-bit, this is effectively $O(N)$.
    -   Space: $O(1)$.

## Implementation Details
-   Iterate through `nums`.
-   Maintain `totalIncrements` and `maxDoubles`.
-   For each `num`:
    -   `totalIncrements += Integer.bitCount(num)`.
    -   Calculate doublings needed for this number.
    -   `maxDoubles = Math.max(maxDoubles, doublingsForNum)`.
-   Result = `totalIncrements + maxDoubles`.
