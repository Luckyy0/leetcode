# 855. Exam Room / Phòng Thi

## Problem Description / Mô tả bài toán
There is an exam room with `n` seats. When a student enters, they sit in the seat that maximizes the distance to the closest person. If there are multiple seats, they sit in the one with the lowest number.
Có một phòng thi với `n` chỗ ngồi. Khi một sinh viên vào, họ sẽ ngồi vào vị trí giúp tối đa hóa khoảng cách đến người gần nhất. Nếu có nhiều chỗ ngồi như vậy, họ sẽ chọn chỗ có số thứ tự thấp nhất.

If the room is empty, they sit in seat 0.
Nếu phòng trống, họ ngồi ở ghế 0.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Interval management or TreeSet / Quản lý Khoảng hoặc TreeSet
We need to efficiently find the largest "gap" between seated students.
Chúng ta cần tìm hiệu quả "khoảng cách" lớn nhất giữa các sinh viên đang ngồi.

Algorithm:
1. Maintain a `TreeSet` of occupied seats.
2. `seat()`:
   - Check the gap at the start (before the first person).
   - Check the gap at the end (after the last person).
   - Iterate through consecutive occupied seats `[a, b]` and calculate the midpoint distance `(b - a) / 2`.
   - Pick the best position and add to `TreeSet`.
3. `leave(p)`: Remove `p` from `TreeSet`.

Optimization:
- For large N, we can use a PriorityQueue to store Intervals `(a, b)` prioritized by their potential midpoint distance.

### Complexity / Độ phức tạp
- **Time**: O(N) for `seat()` with `TreeSet` iteration, or O(log N) with `PriorityQueue`.
- **Space**: O(Students).

---

## Analysis / Phân tích

### Approach: Gap Prioritization
Identify the optimal gap among all current seating distributions. By considering the boundary conditions separately from the interior intervals, we correctly implementation the preference for lower-numbered seats when distances are equal.
Xác định khoảng trống tối ưu trong số tất cả các phân bổ chỗ ngồi hiện tại. Bằng cách xem xét các điều kiện biên tách biệt với các khoảng trống bên trong, chúng ta triển khai chính xác ưu tiên cho các ghế có số thấp hơn khi khoảng cách bằng nhau.

---
