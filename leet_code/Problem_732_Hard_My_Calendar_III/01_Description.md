# Result for My Calendar III
# *Kết quả cho bài toán Lịch trình của Tôi III (My Calendar III)*

## Description
## *Mô tả*

A `k-booking` happens when `k` events have some non-empty intersection (i.e., there is some time that is common to all `k` events).
*Một `k-booking` xảy ra khi có `k` sự kiện có phần giao nhau không rỗng (nghĩa là có một thời điểm nào đó chung cho cả `k` sự kiện).*

You are given some events `[start, end)`, after each given event, return an integer `k` representing the maximum `k-booking` existing in the calendar.
*Bạn được cho một số sự kiện `[start, end)`. Sau mỗi sự kiện, hãy trả về một số nguyên `k` đại diện cho giá trị `k-booking` lớn nhất hiện có trong lịch.*

Implement the `MyCalendarThree` class:
*   `MyCalendarThree()` Initializes the object.
*   `int book(int start, int end)` Returns an integer `k` representing the largest integer such that there exists a `k-booking` in the calendar.

---

## Example 1:
## *Ví dụ 1:*

**Input:** ["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
[[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
**Output:** [null, 1, 1, 2, 3, 3, 3]
**Explanation:**
- MyCalendarThree myCalendarThree = new MyCalendarThree();
- myCalendarThree.book(10, 20); // return 1
- myCalendarThree.book(50, 60); // return 1
- myCalendarThree.book(10, 40); // return 2
- myCalendarThree.book(5, 15);  // return 3
- myCalendarThree.book(5, 10);  // return 3
- myCalendarThree.book(25, 55); // return 3

---

## Constraints:
## *Ràng buộc:*

*   `0 <= start < end <= 10^9`
*   At most `400` calls will be made to `book`.
