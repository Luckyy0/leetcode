# Problem Analysis: Replace Non-Coprime Numbers in Array

## Problem Description
Array `nums`.
If `nums[i]` and `nums[i+1]` are non-coprime (`gcd > 1`):
-   Replace them with `LCM(nums[i], nums[i+1])`.
-   This merge might cause new adjacencies.
-   Repeat until no non-coprime adjacent numbers.
-   Return final array.

## Analysis

1.  **Stack**:
    -   Use a stack (or list acting as stack) to build result.
    -   Iterate `x` in `nums`.
    -   Push `x` to stack.
    -   While `stack.size() >= 2`:
        -   `top = pop()`.
        -   `prev = peek()`.
        -   If `gcd(top, prev) > 1`:
            -   `pop()` (remove prev).
            -   `merged = lcm(top, prev)`.
            -   `push(merged)`.
            -   Repeat check (merged might react with new prev).
        -   Else:
            -   `push(top)` (put back).
            -   Break loop (no merge, `x` is stable for now).
    -   Wait. Standard Stack logic:
        -   When adding `x`:
            -   While `stack` not empty and `gcd(stack.peek(), x) > 1`:
                -   `prev = stack.pop()`.
                -   `x = lcm(prev, x)`.
            -   `stack.push(x)`.

## Implementation Details
-   GCD function.
-   LCM is `(a*b)/gcd`. Use long for calculation then cast to int? Constraints `nums[i] <= 10^5`. LCM shouldn't overflow?
-   LCM can grow large? But problem says replace with LCM.
-   Example `[6, 4, 3, 2, 7, 6, 2]`.
-   LCM can exceed int? `10^5`. Max LCM of many numbers...
-   Usually test cases fit in `int` or return type is `List<Integer>`, implying fits.
-   Use `long` for LCM intermediate.
