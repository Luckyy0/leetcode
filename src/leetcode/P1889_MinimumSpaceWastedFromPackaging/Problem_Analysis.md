# Problem Analysis: Minimum Space Wasted From Packaging

## Problem Description
`packages` (sizes), `boxes` (list of arrays, each array is box sizes from one supplier).
Pack all packages.
Each package `p` goes into box `b` with `b >= p`.
Wasted space `b - p`.
Minimize total wasted space. Return mod $10^9+7$. If impossible (supplier max box < package max), ignore supplier. If all impossible, -1.

## Analysis

1.  **Sorting + Binary Search**:
    -   Sort `packages`.
    -   For each supplier:
        -   Sort `supplier_boxes`.
        -   If `supplier_boxes.last < packages.last`, cannot use this supplier.
        -   Otherwise, efficiently calculate wasted space.
        -   Total Wasted = `(Total Box Volume Used) - (Sum of Packages)`.
        -   `Sum of Packages` is constant. We just need to minimize `Total Box Volume Used`.
    -   Calculation for one supplier:
        -   Iterate sorted boxes `b` in supplier list.
        -   Find how many packages fit in `b` (and haven't been packed yet).
        -   Let previously packed count be `prev_idx`.
        -   Find index `idx` in `packages` such that `packages[idx] <= b`. (Binary Search `upper_bound`).
        -   Packages from `prev_idx` to `idx - 1` are packed in box `b`.
        -   Count `count = idx - prev_idx`.
        -   Volume added `count * b`.
        -   Update `prev_idx = idx`.
        -   If `prev_idx == packages.length`, done with this supplier.
    -   Optimization:
        -   Binary searching `packages` is fast.
        -   Complexity: `Sort(Packages)` + Sum( `Sort(Boxes_j)` + `len(Boxes_j) * log(P)` ).
        -   Total box types $\le 10^5$.
    
2.  **Implementation**:
    -   `binarySearch` helper.
    -   `long` arithmetic.
    -   Modulo only at return. Intermediate must be computed fully or with care.
    -   Since we want MIN wasted space, we should compare the full value.
    -   Wait, problem asks "Return the minimum total wasted space modulo 10^9 + 7".
    -   If wasted space exceeds `long`, we might have issue.
    -   Constraints: `packages[i] <= 10^5`. `n <= 10^5`. Max waste `10^5 * 10^5 = 10^{10}`. Fits in `long`.

## Implementation Details
-   `Arrays.sort`.
-   Loop suppliers.
