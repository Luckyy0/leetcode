# Result for Data Stream as Disjoint Intervals
# *Kết quả cho bài toán Luồng Dữ liệu dưới dạng các Khoảng Rời rạc*

## Description
## *Mô tả*

Given a data stream input of non-negative integers `a1, a2, ..., an`, summarize the numbers seen so far as a list of disjoint intervals.
*Cho một luồng dữ liệu đầu vào gồm các số nguyên không âm `a1, a2, ..., an`, hãy tóm tắt các số đã thấy cho đến nay dưới dạng danh sách các khoảng rời rạc.*

Implement the `SummaryRanges` class:
*Thực hiện lớp `SummaryRanges`:*

*   `SummaryRanges()` Initializes the object with an empty stream.
    *`SummaryRanges()` Khởi tạo đối tượng với một luồng trống.*
*   `void addNum(int value)` Adds the integer `value` to the stream.
    *`void addNum(int value)` Thêm số nguyên `value` vào luồng.*
*   `int[][] getIntervals()` Returns a summary of the integers in the stream currently as a list of disjoint intervals `[start_i, end_i]`. The list of intervals should be sorted by `start_i`.
    *`int[][] getIntervals()` Trả về bản tóm tắt các số nguyên trong luồng hiện tại dưới dạng danh sách các khoảng rời rạc `[start_i, end_i]`. Danh sách các khoảng phải được sắp xếp theo `start_i`.*

## Example 1:
## *Ví dụ 1:*

**Input:**
`["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]`
`[[], [1], [], [3], [], [7], [], [2], [], [6], []]`
**Output:**
`[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]`

**Explanation:**
```java
SummaryRanges summaryRanges = new SummaryRanges();
summaryRanges.addNum(1);      // arr = [1]
summaryRanges.getIntervals(); // return [[1, 1]]
summaryRanges.addNum(3);      // arr = [1, 3]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
summaryRanges.addNum(7);      // arr = [1, 3, 7]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
```

## Constraints:
## *Ràng buộc:*

*   `0 <= value <= 10^4`
*   At most `3 * 10^4` calls will be made to `addNum` and `getIntervals`.
*   At most `10^2` calls will be made to `getIntervals`.

**Follow up:** What if there are lots of merges and the number of disjoint intervals is small compared to the size of the data stream?
**Câu hỏi mở rộng:** Điều gì xảy ra nếu có nhiều phép hợp nhất và số lượng các khoảng rời rạc nhỏ so với kích thước của luồng dữ liệu?
