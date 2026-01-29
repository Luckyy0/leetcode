# 548. Split Array with Equal Sum / Chia Mảng Có Tổng Bằng Nhau

## Problem Description / Mô tả bài toán
Given an integer array `nums` of length `n`, return `true` if there is a triplet `(i, j, k)` which satisfies the following conditions:
Cho một mảng số nguyên `nums` có độ dài `n`, trả về `true` nếu có một bộ ba `(i, j, k)` thỏa mãn các điều kiện sau:

1. `0 < i, i + 1 < j, j + 1 < k < n - 1`
2. The sum of subarrays `(0, i - 1)`, `(i + 1, j - 1)`, `(j + 1, k - 1)` and `(k + 1, n - 1)` is equal.
   / Tổng của các mảng con `(0, i - 1)`, `(i + 1, j - 1)`, `(j + 1, k - 1)` và `(k + 1, n - 1)` là bằng nhau.

Basically, splitting the array into 4 parts with equal sums by removing 3 elements.
Cơ bản là chia mảng thành 4 phần có tổng bằng nhau bằng cách loại bỏ 3 phần tử.

### Example 1:
```text
Input: nums = [1,2,1,2,1,2,1]
Output: true
Explanation: i = 1, j = 3, k = 5. 
sum(0,0) = 1
sum(2,2) = 1
sum(4,4) = 1
sum(6,6) = 1
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix Sums and HashSet / Tổng Tiền Tố và HashSet
Checking sums efficiently requires prefix sums.
`sum(x, y) = P[y+1] - P[x]`.

Algorithm:
1. Compute prefix sum array `P`.
2. Iterate `j` (the middle cut) from `3` to `n-4`.
   - The middle cut splits the array into Left `[0...j-1]` and Right `[j+1...n-1]`.
   - **Check Left**: Iterate `i` from `1` to `j-2`.
     - Verify if `sum(0, i-1) == sum(i+1, j-1)`.
     - Store these possible sums in a HashSet for the current `j`.
   - **Check Right**: Iterate `k` from `j+2` to `n-2`.
     - Verify if `sum(j+1, k-1) == sum(k+1, n-1)`.
     - If this sum exists in the HashSet from the left part, Return `true`.
3. Return `false`.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Middle Split Search strategies

**Algorithm**:
1.  Compute prefix sums.
2.  Iterate middle split point `j`.
3.  For each `j`, find valid left splits `i` and store potential part sums.
4.  Find valid right splits `k` and check if sum matches any stored left sum.

---
