# Result for Insert Interval
# *Kết quả cho bài toán Chèn Khoảng*

## Description
## *Mô tả*

You are given an array of non-overlapping intervals `intervals` where `intervals[i] = [starti, endi]` representing the start and the end of the `ith` interval and `intervals` is sorted in ascending order by `starti`. You are also given an interval `newInterval = [start, end]` that represents the start and end of another interval.
*Bạn được cho một mảng các khoảng không chồng lấn `intervals` trong đó `intervals[i] = [starti, endi]` đại diện cho điểm đầu và điểm cuối của khoảng thứ `i` và `intervals` được sắp xếp theo thứ tự tăng dần theo `starti`. Bạn cũng được cho một khoảng `newInterval = [start, end]` đại diện cho điểm đầu và điểm cuối của một khoảng khác.*

Insert `newInterval` into `intervals` such that `intervals` is still sorted in ascending order by `starti` and `intervals` still does not have any overlapping intervals (merge overlapping intervals if necessary).
*Chèn `newInterval` vào `intervals` sao cho `intervals` vẫn được sắp xếp theo thứ tự tăng dần theo `starti` và `intervals` vẫn không có bất kỳ khoảng chồng lấn nào (hợp nhất các khoảng chồng lấn nếu cần thiết).*

Return `intervals` after the insertion.
*Trả về `intervals` sau khi chèn.*

## Example 1:
## *Ví dụ 1:*

**Input:** `intervals = [[1,3],[6,9]]`, `newInterval = [2,5]`
**Output:** `[[1,5],[6,9]]`

## Example 2:
## *Ví dụ 2:*

**Input:** `intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]`, `newInterval = [4,8]`
**Output:** `[[1,2],[3,10],[12,16]]`
**Explanation:** Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

## Constraints:
## *Ràng buộc:*

*   `0 <= intervals.length <= 10^4`
*   `intervals[i].length == 2`
*   `0 <= starti <= endi <= 10^5`
*   `intervals` is sorted by `starti` in ascending order.
*   `newInterval.length == 2`
*   `0 <= start <= end <= 10^5`
