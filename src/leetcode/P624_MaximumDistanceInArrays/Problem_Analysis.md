# 624. Maximum Distance in Arrays / Khoảng Cách Tối Đa Trong Mảng

## Problem Description / Mô tả bài toán
You are given `m` arrays, where each array is sorted in ascending order.
Bạn được cho `m` mảng, trong đó mỗi mảng được sắp xếp theo thứ tự tăng dần.

You can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers `a` and `b` to be their absolute difference `|a - b|`.
Bạn có thể chọn hai số nguyên từ hai mảng khác nhau (mỗi mảng chọn một) và tính khoảng cách. Chúng tôi định nghĩa khoảng cách giữa hai số nguyên `a` và `b` là giá trị tuyệt đối của hiệu `|a - b|`.

Return the maximum distance.
Trả về khoảng cách tối đa.

### Example 1:
```text
Input: arrays = [[1,2,3],[4,5],[1,2,3]]
Output: 4 (One way is to pick 1 and 5)
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Linear Scan with Extremes / Quét Tuyến Tính với Cực Trị
Sort arrays? No, arrays are already sorted.
The max distance must come from `Min(One Array)` and `Max(Another Array)`.
We need to track `min_val` and `max_val` seen so far.
Iterate arrays. For current array `curr` (min `curr[0]`, max `curr[end]`):
- Update `result = Max(result, |curr[end] - min_so_far|, |max_so_far - curr[0]|)`
- Update `min_so_far = Min(min_so_far, curr[0])`
- Update `max_so_far = Max(max_so_far, curr[end])`

Important: We must pick from **different** arrays. By updating result BEFORE updating global min/max, we ensure we compare current array against PREVIOUS arrays (guaranteed different).

### Complexity / Độ phức tạp
- **Time**: O(M).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Single Pass

**Algorithm**:
1.  Initialize result, min, max using first array.
2.  Iterate from second array.
3.  Calculate potentials (current max - global min, global max - current min).
4.  Update global min/max.

---
