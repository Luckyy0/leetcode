# 729. My Calendar I / Lịch của tôi I

## Problem Description / Mô tả bài toán
Implement a `MyCalendar` class to store your events. A new event can be added if adding the event will not cause a **double booking**.
Triển khai lớp `MyCalendar` để lưu trữ các sự kiện của bạn. Một sự kiện mới có thể được thêm vào nếu việc thêm sự kiện đó không gây ra **đặt trùng (double booking)**.

A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events).
Việc đặt trùng xảy ra khi hai sự kiện có một số giao điểm không rỗng.

The event can be represented as a pair of integers `start` and `end` representing a booking on the half-open interval `[start, end)`.
Sự kiện có thể được biểu diễn dưới dạng một cặp số nguyên `start` và `end` đại diện cho một lần đặt chỗ trong khoảng nửa mở `[start, end)`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Balanced Binary Search Tree (TreeMap) / Cây Tìm kiếm Nhị phân Cân bằng (TreeMap)
We can store start times in a `TreeMap`.
Chúng ta có thể lưu trữ thời gian bắt đầu trong một `TreeMap`.

For a new interval `[s, e)`, we need to check:
1. The largest start time `s1` that is `<= s`. Check if its corresponding `e1` is `> s`.
2. The smallest start time `s2` that is `>= s`. Check if `s2` is `< e`.

If both conditions are false, there is no collision.

### Complexity / Độ phức tạp
- **Time**: O(N log N) where N is the number of bookings.
- **Space**: O(N) to store intervals.

---

## Analysis / Phân tích

### Approach: TreeMap floorKey and ceilingKey
Efficiently find the neighboring intervals and check for overlaps.
Tìm kiếm hiệu quả các khoảng lân cận và kiểm tra sự chồng chéo.

---
