# 1300. Sum of Mutated Array Closest to Target / Tổng của Mảng Biến đổi Gần nhất với Mục tiêu

## Problem Description / Mô tả bài toán
Array `arr`, integer `target`.
Replace all elements > `value` with `value`.
Find proper `value` such that sum of mutated array is closest to `target`.
If tie, return smallest `value`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search on Answer
The sum of mutated array is monotonically non-decreasing with respect to `value`.
Function `check(v)` computes transformed sum.
Binary search range `[0, max(arr)]`.
Find `v` such that `check(v) <= target` closest and `check(v) >= target` closest.
Actually simpler:
Binary search for `v`.
If `sum < target`: try larger v (`left = mid + 1`).
If `sum > target`: try smaller v (`right = mid - 1`).
Keep track of best `v` (min diff).
Handle tie-breaking (smallest `v`).

### Complexity / Độ phức tạp
- **Time**: O(N log(MaxVal)).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Binary Search for Value
The function $f(v) = \sum_{i} \min(arr[i], v)$ is non-decreasing. We want $f(v) \approx \text{target}$. Since it's monotonic, we can binary search for `v` in the range $[0, \max(arr)]$. Calculate the sum for `mid`. If sums are close, update the best candidate. Specifically, find the point where $f(v)$ crosses `target`. Compare candidates around the target to find minimal absolute difference.
Hàm $f(v) = \sum_{i} \min(arr[i], v)$ không giảm. Chúng ta muốn $f(v) \approx \text{target}$. Vì nó đơn điệu, chúng ta có thể tìm kiếm nhị phân cho `v` trong phạm vi $[0, \max(arr)]$. Tính tổng cho `mid`. Nếu tổng gần, cập nhật ứng viên tốt nhất. Cụ thể, tìm điểm mà $f(v)$ cắt `target`. So sánh các ứng viên xung quanh mục tiêu để tìm chênh lệch tuyệt đối tối thiểu.

---
