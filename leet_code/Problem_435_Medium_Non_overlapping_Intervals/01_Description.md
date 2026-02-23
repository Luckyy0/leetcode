# Result for Non-overlapping Intervals
# *Kết quả cho bài toán Khoảng không Chồng lấn*

## Description
## *Mô tả*

Given an array of intervals `intervals` where `intervals[i] = [starti, endi]`, return *the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping*.
*Cho một mảng các khoảng `intervals` trong đó `intervals[i] = [starti, endi]`, hãy trả về *số lượng khoảng tối thiểu bạn cần xóa để làm cho các khoảng còn lại không bị chồng lấn*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `intervals = [[1,2],[2,3],[3,4],[1,3]]`
**Output:** `1`
**Explanation:** [1,3] can be removed and the rest of the intervals are non-overlapping.

## Example 2:
## *Ví dụ 2:*

**Input:** `intervals = [[1,2],[1,2],[1,2]]`
**Output:** `2`
**Explanation:** You need to remove two [1,2] to make the rest of the intervals non-overlapping.

## Constraints:
## *Ràng buộc:*

*   `1 <= intervals.length <= 10^5`
*   `intervals[i].length == 2`
*   `-5 * 10^4 <= starti < endi <= 5 * 10^4`
