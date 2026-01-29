# 732. My Calendar III / Lịch của tôi III

## Problem Description / Mô tả bài toán
Implement a `MyCalendarThree` class to store your events. A new event can always be added. Your task is to return an integer `k` representing the maximum number of simultaneous events (k-booking).
Triển khai lớp `MyCalendarThree` để lưu trữ các sự kiện của bạn. Một sự kiện mới luôn có thể được thêm vào. Nhiệm vụ của bạn là trả về một số nguyên `k` đại diện cho số lượng sự kiện đồng thời tối đa (k-booking).

A k-booking happens when `k` events have some non-empty intersection.
Một k-booking xảy ra khi `k` sự kiện có một số giao điểm không rỗng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sweep-line Algorithm / Thuật toán Quét (Sweep-line)
This problem asks for the maximum overlap across all time.
Bài toán này yêu cầu tìm sự chồng chéo tối đa trên toàn bộ thời gian.

Algorithm:
1. Use a `TreeMap<Integer, Integer>` to store the delta changes at each time point.
2. For an interval `[start, end)`:
   - `map[start]++` (an event starts).
   - `map[end]--` (an event ends).
3. Sum the values in the map in chronological order. The `k` is the maximum prefix sum encountered.

### Complexity / Độ phức tạp
- **Time**: O(N^2) total (since we re-scan the map for each `book` call).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Boundary Point Counting
Store every start and end point in a sorted map. Traverse the map to find the maximum number of overlapping intervals at any point in time.
Lưu trữ mọi điểm bắt đầu và kết thúc trong một bản đồ đã sắp xếp. Duyệt qua bản đồ để tìm số lượng khoảng chồng chèo tối đa tại bất kỳ thời điểm nào.

---
