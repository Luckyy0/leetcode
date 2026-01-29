# Problem Analysis: Kth Smallest Product of Two Sorted Arrays

## Problem Description
Sorted arrays `nums1`, `nums2`.
Find `k`-th smallest product `nums1[i] * nums2[j]`.
Arrays can contain negatives.

## Analysis

1.  **Binary Search on Value**:
    -   Range of products `[-10^{10}, 10^{10}]`.
    -   Binary Search `mid`.
    -   Check `countLessEqual(mid)`.
    -   If `count >= k` -> `ans = mid`, `high = mid - 1`.
    -   Else `low = mid + 1`.

2.  **CountLessEqual(val)**:
    -   For each `x` in `nums1`:
        -   Count `y` in `nums2` such that `x * y <= val`.
        -   If `x > 0`: `y <= val / x`. `nums2` is sorted. Only need count of elements $\le$ threshold. Binary search in `nums2` or Two Pointers?
        -   If `x < 0`: `y >= val / x`. (Inequality flips). Count elements $\ge$ threshold.
        -   If `x == 0`:
            -   If `0 <= val`: all `y` match (prod 0).
            -   If `0 > val`: no `y` match.
    -   Since checking single `val` involves iterating `nums1`, complexity $O(N_1 \log N_2)$ or $O(N_1 + N_2)$ with two pointers if careful? Wait.
    -   Two pointers not trivial because `nums2` iteration direction depends on `x`.
    -   But `nums1` is sorted.
    -   Usually just loop `nums1` and binary search `nums2`: $O(N_1 \log N_2)$.
    -   Total complexity: $O(N_1 \log N_2 \cdot \log(\text{Range}))$.
    -   With $N_1 = 5 \times 10^4$, $N_2 = 5 \times 10^4$. Product is $2.5 \times 10^9$.
    -   $N_1 \log N_2 \approx 8 \times 10^5$. Range Log $\approx 64$.
    -   $5 \times 10^7$ ops. Feasible.

## Implementation Details
-   `long` bounds.
-   Handle neg splitting or just iterating. Iterating simpler to implement, slightly slower but acceptable.
