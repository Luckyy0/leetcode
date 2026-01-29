# 1539. Kth Missing Positive Number / Số Dương Thiếu thứ K

## Problem Description / Mô tả bài toán
Sorted array `arr`. Find k-th missing positive integer.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search or Linear Scan
Missing count at index `i` is `arr[i] - (i + 1)`.
Binary search for `i` such that `missing[i] < k`.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Binary Search
Find largest index `mid` where missing count strictly less than k.
`arr[i] - (i+1) < k`.
If `arr[mid] - mid - 1 < k`, we need to look right (`left = mid + 1`).
Else look left.
Result is `left + k`.

---
