# 1508. Range Sum of Sorted Subarray Sums / Tổng Phạm vi của Tổng Mảng con Đã sắp xếp

## Problem Description / Mô tả bài toán
Array `nums`. All subarray sums.
Sort these new sums.
Return sum from index `left` to `right` (1-based). Modulo 10^9 + 7.
N <= 1000.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Brute Force + Sorting
Total subarrays $N(N+1)/2$. Max $\approx 500,000$.
Generate all sums. Store in list.
Sort list.
Sum range.
Time: $O(N^2 \log(N^2))$. Feasible.

### Complexity / Độ phức tạp
- **Time**: O(N^2 log N).
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: Generate and Sort
Create list.
Loop `i` from 0 to n-1. `sum = 0`.
Loop `j` from `i` to n-1. `sum += nums[j]`. Add to list.
Sort list.
Sum range.
Tạo danh sách.
Lặp `i` từ 0 đến n-1. `sum = 0`.
Lặp `j` từ `i` đến n-1. `sum += nums[j]`. Thêm vào danh sách.
Sắp xếp danh sách.
Tổng phạm vi.

---
