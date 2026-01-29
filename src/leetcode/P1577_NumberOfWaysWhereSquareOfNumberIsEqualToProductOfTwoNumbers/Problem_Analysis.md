# Problem Analysis: Number of Ways Where Square of Number Is Equal to Product of Two Numbers

## Problem Description
Given two arrays `nums1` and `nums2`, return the number of triplets (i, j, k) such that:
-   Type 1: `nums1[i]^2 = nums2[j] * nums2[k]`
-   Type 2: `nums2[i]^2 = nums1[j] * nums1[k]`
Return the total count.

## Analysis

1.  **Constraints**:
    -   `nums1.length`, `nums2.length` <= 1000.
    -   Values <= 10^5. Squares up to 10^10 (requires `long`).

2.  **Approach**:
    -   Since $N=1000$, efficient counting is needed.
    -   The condition is `Target = Product`.
    -   We can compute all possible products of pairs from `nums2` and store them in a frequency map: `Map<Product, Count>`. This takes $O(N_2^2)$.
    -   Then iterate `nums1`, calculate square, look up in map. Takes $O(N_1)$.
    -   Repeat vice-versa for Type 2.
    -   Total Time: $O(N_1^2 + N_2^2)$. This is $10^6$, perfectly fine.

3.  **Data Structures**:
    -   `HashMap<Long, Integer>` to store pair products.

4.  **Complexity**:
    -   Time: $O(N_1^2 + N_2^2)$.
    -   Space: $O(N_1^2 + N_2^2)$ worst case for distinct products.

## Implementation Details
-   Helper function `countPairs(int[] nums1, int[] nums2)`: counts `n1^2 == n2_j * n2_k`.
-   Result = `countPairs(nums1, nums2) + countPairs(nums2, nums1)`.
