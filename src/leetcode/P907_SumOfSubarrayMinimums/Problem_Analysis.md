# 907. Sum of Subarray Minimums / Tổng các Giá trị Nhỏ nhất của Mảng con

## Problem Description / Mô tả bài toán
Given an array of integers `arr`, find the sum of `min(b)`, where `b` ranges over every (contiguous) subarray of `arr`.
Cho một mảng các số nguyên `arr`, hãy tìm tổng của `min(b)`, trong đó `b` trải dài trên mọi mảng con (liên tiếp) của `arr`.

Since the answer may be large, return it **modulo 10^9 + 7**.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Monotonic Stack / Contribution Method / Ngăn xếp Đơn điệu / Phương pháp Đóng góp
Instead of finding all subarrays, we calculate for each element `arr[i]` how many subarrays have `arr[i]` as the minimum.
Thay vì tìm tất cả các mảng con, chúng ta tính toán cho mỗi phần tử `arr[i]` xem có bao nhiêu mảng con coi `arr[i]` là giá trị nhỏ nhất.

Let `L[i]` be the distance to the nearest smaller element to the left of `i`.
Let `R[i]` be the distance to the nearest smaller element to the right of `i`.
A subarray `arr[j...k]` has `arr[i]` as minimum if `i - L[i] < j <= i` and `i <= k < i + R[i]`.
Number of such subarrays = `L[i] * R[i]`.

Algorithm:
1. Use a monotonic stack to find `L[i]` (index of Previous Smaller Element).
2. Use a monotonic stack to find `R[i]` (index of Next Smaller Element).
3. Sum `arr[i] * L[i] * R[i]`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Individual Contribution logic
Treat each element as a potential "bottleneck" minimum. By identifying the maximal range over which an element remains the smallest, we can calculate its total contribution to the global sum via combinatorics.
Coi mỗi phần tử như một giá trị nhỏ nhất "nút thắt cổ chai" tiềm năng. Bằng cách xác định phạm vi tối đa mà một phần tử vẫn là nhỏ nhất, chúng ta có thể tính toán tổng đóng góp của nó vào tổng toàn cục thông qua tổ hợp.

---
