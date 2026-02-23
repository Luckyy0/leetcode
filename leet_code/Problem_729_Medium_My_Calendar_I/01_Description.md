# Result for My Calendar I
# *Kết quả cho bài toán Lịch trình của Tôi I (My Calendar I)*

## Description
## *Mô tả*

You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a **double booking**.
*Bạn đang triển khai một chương trình để sử dụng làm lịch cá nhân. Chúng ta có thể thêm một sự kiện mới nếu việc thêm sự kiện đó không gây ra **đặt lịch trùng (double booking)**.*

A **double booking** happens when two events have some non-empty intersection (i.e., some moment is common to both events).
*Một **đặt lịch trùng** xảy ra khi hai sự kiện có một phần giao nhau không rỗng (nghĩa là có một thời điểm nào đó chung cho cả hai sự kiện).*

An event can be represented by a pair of integers `start` and `end` that represents a booking on the half-open interval `[start, end)`.
*Một sự kiện có thể được đại diện bởi một cặp số nguyên `start` và `end` đại diện cho việc đặt chỗ trong khoảng nửa mở `[start, end)`.*

Implement the `MyCalendar` class:
*   `MyCalendar()` Initializes the calendar object.
*   `boolean book(int start, int end)` Returns `true` if the event can be added to the calendar successfully without causing a double booking. Otherwise, return `false` and do not add the event to the calendar.

---

## Example 1:
## *Ví dụ 1:*

**Input:** ["MyCalendar", "book", "book", "book"]
[[], [10, 20], [15, 25], [20, 30]]
**Output:** [null, true, false, true]
**Explanation:**
MyCalendar myCalendar = new MyCalendar();
myCalendar.book(10, 20); // return True
myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
myCalendar.book(20, 30); // return True, The event can be booked, as the first event [10, 20) does not include 20.

---

## Constraints:
## *Ràng buộc:*

*   `0 <= start < end <= 10^9`
*   At most `1000` calls will be made to `book`.
