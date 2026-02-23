# Result for Meeting Rooms
# *Kết quả cho bài toán Phòng họp*

## Description
## *Mô tả*

Given an array of meeting time intervals where `intervals[i] = [start_i, end_i]`, determine if a person could attend all meetings.
*Cho một mảng các khoảng thời gian họp trong đó `intervals[i] = [start_i, end_i]`, hãy xác định xem một người có thể tham dự tất cả các cuộc họp hay không.*

## Example 1:
## *Ví dụ 1:*

**Input:** `intervals = [[0,30],[5,10],[15,20]]`
**Output:** `false`
**Explanation:** Since [0,30] overlaps with [5,10] and [15,20], a person cannot attend all.

## Example 2:
## *Ví dụ 2:*

**Input:** `intervals = [[7,10],[2,4]]`
**Output:** `true`

## Constraints:
## *Ràng buộc:*

*   `0 <= intervals.length <= 10^4`
*   `intervals[i].length == 2`
*   `0 <= start_i < end_i <= 10^6`
