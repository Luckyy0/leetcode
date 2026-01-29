# 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit / Chuỗi con Liên tục Dài nhất có Chênh lệch Tuyệt đối Nhỏ hơn hoặc Bằng Giới hạn

## Problem Description / Mô tả bài toán
Array `nums`, integer `limit`.
Longest subarray such that `abs(x - y) <= limit` for any x, y in the subarray.
Equivalent to `max(subarray) - min(subarray) <= limit`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window with Monotonic Deques
Maintain two Monotonic Deques:
1. `maxDeque`: Decreasing. Front is max of window.
2. `minDeque`: Increasing. Front is min of window.
Expand `right`. Add `nums[right]` to both deques.
Check condition `maxDeque.peek() - minDeque.peek() <= limit`.
If valid, update max length.
If invalid, shrink `left`:
- Remove `nums[left]` from deques (if at front).
- Increment `left`.
(Since we want longest, we can just increment `right` and if invalid increment `left`. Window size never shrinks).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Two Deques Sliding Window
Standard sliding window. Use `maxD` and `minD` to query max and min in O(1).
While `max - min > limit`, remove `nums[left]` and increment `left`.
Note: "Remove nums[left]" means checking if `maxD.peekFirst() == nums[left]` then poll.
Cửa sổ trượt tiêu chuẩn. Sử dụng `maxD` và `minD` để truy vấn max và min trong O(1).
Trong khi `max - min > limit`, xóa `nums[left]` và tăng `left`.

---
