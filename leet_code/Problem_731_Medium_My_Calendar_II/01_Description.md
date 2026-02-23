# Result for My Calendar II
# *Kết quả cho bài toán Lịch trình của Tôi II (My Calendar II)*

## Description
## *Mô tả*

You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a **triple booking**.
*Bạn đang triển khai một chương trình để sử dụng làm lịch cá nhân. Chúng ta có thể thêm một sự kiện mới nếu việc thêm sự kiện đó không gây ra **đặt lịch trùng ba (triple booking)**.*

A **triple booking** happens when three events have some non-empty intersection (i.e., some moment is common to all three events).
*Một **đặt lịch trùng ba** xảy ra khi có ba sự kiện có phần giao nhau không rỗng (nghĩa là có một thời điểm nào đó chung cho cả ba sự kiện).*

An event can be represented by a pair of integers `start` and `end` that represents a booking on the half-open interval `[start, end)`.
*Một sự kiện có thể được đại diện bởi một cặp số nguyên `start` và `end` đại diện cho việc đặt chỗ trong khoảng nửa mở `[start, end)`.*

Implement the `MyCalendarTwo` class:
*   `MyCalendarTwo()` Initializes the calendar object.
*   `boolean book(int start, int end)` Returns `true` if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return `false` and do not add the event to the calendar.

---

## Example 1:
## *Ví dụ 1:*

**Input:** ["MyCalendarTwo", "book", "book", "book", "book", "book", "book"]
[[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
**Output:** [null, true, true, true, false, true, true]
**Explanation:**
- MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
- myCalendarTwo.book(10, 20); // return True
- myCalendarTwo.book(50, 60); // return True
- myCalendarTwo.book(10, 40); // return True, It can be double booked.
- myCalendarTwo.book(5, 15);  // return False, It would cause a triple booking.
- myCalendarTwo.book(5, 10);  // return True, It can be placed.
- myCalendarTwo.book(25, 55); // return True, It can be placed.

---

## Constraints:
## *Ràng buộc:*

*   `0 <= start < end <= 10^9`
*   At most `1000` calls will be made to `book`.
