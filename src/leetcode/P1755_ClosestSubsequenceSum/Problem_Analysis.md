# Problem Analysis: Closest Subsequence Sum

## Problem Description
Array `nums`. `goal`.
Find subsequence sum closest to `goal`. Return `min(|sum - goal|)`.
$N \le 40$. $nums[i]$ large.

## Analysis

1.  **Meet-in-the-middle**:
    -   $N=40$ too big for $2^{40}$.
    -   Split array into two halves ($20, 20$).
    -   Generate all subsequence sums for Left half ($2^{20} \approx 10^6$). Store in sorted array/list `LeftSums`.
    -   Generate all subsequence sums for Right half `RightSums`. Sort `RightSums`.
    -   For each sum `s` in `LeftSums`, we want `s + r \approx goal`.
    -   Need `r \approx goal - s`.
    -   Binary search (or TreeSet ceiling/floor) in `RightSums` for `goal - s`.
    -   Update min absolute difference.

2.  **Complexity**:
    -   Time: $O(2^{N/2} \cdot \log(2^{N/2})) = O(2^{N/2} \cdot N)$.
    -   $N=40 \implies 20 \cdot 10^6 \approx 2 \cdot 10^7$. OK.
    -   Space: $O(2^{N/2})$.

## Implementation Details
-   Recursive generation function.
-   Sort and search.
-   Remove duplicates for speed?
