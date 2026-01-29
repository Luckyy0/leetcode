# 933. Number of Recent Calls / Số lượng Cuộc gọi Gần nhất

## Problem Description / Mô tả bài toán
Write a class `RecentCounter` that counts the number of recent requests within a certain time window `[t - 3000, t]`.
Viết một lớp `RecentCounter` dùng để đếm số lượng các yêu cầu gần nhất trong một cửa sổ thời gian nhất định `[t - 3000, t]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window with Queue / Cửa sổ trượt với Hàng đợi
The requests are strictly increasing in time.
Các yêu cầu tăng nghiêm ngặt theo thời gian.

Algorithm:
1. Maintain a `Queue` of timestamps.
2. For each `ping(t)`:
   - Add `t` to the queue.
   - While `queue.peek() < t - 3000`, remove the front element.
   - Return `queue.size()`.

### Complexity / Độ phức tạp
- **Time**: O(1) amortized.
- **Space**: O(MaxCallsIn3000ms).

---

## Analysis / Phân tích

### Approach: Temporal Pruning
Use a queue to represent the active time window. As new pings arrive, discard stale timestamps that fall outside the 3000ms threshold to maintain only relevant entries.
Sử dụng hàng đợi để biểu thị cửa sổ thời gian hoạt động. Khi có các lần ping mới, hãy loại bỏ các dấu thời gian cũ nằm ngoài ngưỡng 3000ms để chỉ duy trì các mục nhập có liên quan.

---
