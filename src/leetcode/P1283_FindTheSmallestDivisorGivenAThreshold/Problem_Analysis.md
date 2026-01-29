# 1283. Find the Smallest Divisor Given a Threshold / Tìm Số chia Nhỏ nhất Với một Ngưỡng

## Problem Description / Mô tả bài toán
Array `nums` and integer `threshold`.
Find smallest positive integer `divisor` such that sum of division results is `<= threshold`.
Division result is `ceil(nums[i] / divisor)`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search on Answer
Divisor ranges from 1 to `max(nums)`.
`check(divisor)` function which computes sum.
If sum <= threshold, try smaller divisor (potential answer).
If sum > threshold, need larger divisor.
Division: `ceil(a/b)` is `(a + b - 1) / b` (integer arithmetic).

### Complexity / Độ phức tạp
- **Time**: O(N log(MaxVal)).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Binary Search on Divisor
The sum of division results is monotonically decreasing with respect to the divisor. This allows binary search. The search range is `[1, max(nums)]`. For a chosen `mid`, calculate the sum of `ceil(num / mid)` for all `num`. If `sum <= threshold`, `mid` is a possible answer, so try smaller values (`right = mid`). Otherwise, `mid` is too small, so try larger values (`left = mid + 1`).
Tổng kết quả phép chia giảm đơn điệu đối với số chia. Điều này cho phép tìm kiếm nhị phân. Phạm vi tìm kiếm là `[1, max(nums)]`. Đối với `mid` đã chọn, hãy tính tổng của `ceil(num / mid)` cho tất cả `num`. Nếu `sum <= threshold`, `mid` là một câu trả lời khả thi, vì vậy hãy thử các giá trị nhỏ hơn (`right = mid`). Ngược lại, `mid` quá nhỏ, vì vậy hãy thử các giá trị lớn hơn (`left = mid + 1`).

---
