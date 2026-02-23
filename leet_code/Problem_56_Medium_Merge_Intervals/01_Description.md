# Result for Merge Intervals
# *Kết quả cho bài toán Hợp Nhất Các Khoảng*

## Description
## *Mô tả*

Given an array of `intervals` where `intervals[i] = [starti, endi]`, merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
*Cho một mảng các `intervals` trong đó `intervals[i] = [starti, endi]`, hãy hợp nhất tất cả các khoảng chồng lấn và trả về một mảng các khoảng không chồng lấn bao phủ tất cả các khoảng trong đầu vào.*

## Example 1:
## *Ví dụ 1:*

**Input:** `intervals = [[1,3],[2,6],[8,10],[15,18]]`
**Output:** `[[1,6],[8,10],[15,18]]`
**Explanation:** Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

## Example 2:
## *Ví dụ 2:*

**Input:** `intervals = [[1,4],[4,5]]`
**Output:** `[[1,5]]`
**Explanation:** Intervals [1,4] and [4,5] are considered overlapping.

## Constraints:
## *Ràng buộc:*

*   `1 <= intervals.length <= 10^4`
*   `intervals[i].length == 2`
*   `0 <= starti <= endi <= 10^4`
