# 731. My Calendar II / Lịch của tôi II

## Problem Description / Mô tả bài toán
Implement a `MyCalendarTwo` class to store your events. A new event can be added if adding the event will not cause a **triple booking**.
Triển khai lớp `MyCalendarTwo` để lưu trữ các sự kiện của bạn. Một sự kiện mới có thể được thêm vào nếu việc thêm sự kiện đó không gây ra **đặt trùng ba (triple booking)**.

A triple booking happens when three events have some non-empty intersection (i.e., some moment is common to all three events).
Việc đặt trùng ba xảy ra khi ba sự kiện có một số giao điểm không rỗng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Overlap Tracking / Theo dõi Sự chồng chéo
We can maintain two lists:
1. `calendar`: All individual events booked so far.
2. `overlaps`: All intervals where exactly two events already overlap.

When adding a new event `[s, e)`:
1. Check if `[s, e)` overlaps with any interval in `overlaps`. If yes, it would become a triple booking.
2. If not, check overlaps with `calendar` and add those newly created overlapping segments to `overlaps`.
3. Add `[s, e)` to `calendar`.

### Complexity / Độ phức tạp
- **Time**: O(N^2) where N is the number of bookings.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Two-List Overlap Check
Manually check for intersections. For each new interval, if it hits an already doubled interval, return false. Otherwise, record the new intersections it creates with existing single intervals.
Kiểm tra thủ công các giao điểm. Đối với mỗi khoảng mới, nếu nó chạm vào một khoảng đã bị trùng đôi, hãy trả về false. Ngược lại, hãy ghi lại các giao điểm mới mà nó tạo ra với các khoảng đơn hiện có.

---
