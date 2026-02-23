# Result for Meeting Rooms II
# *Kết quả cho bài toán Phòng họp II*

## Description
## *Mô tả*

Given an array of meeting time intervals `intervals` where `intervals[i] = [start_i, end_i]`, return *the minimum number of conference rooms required*.
*Cho một mảng các khoảng thời gian họp `intervals`, trong đó `intervals[i] = [start_i, end_i]`, trả về *số lượng phòng họp tối thiểu cần thiết*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `intervals = [[0,30],[5,10],[15,20]]`
**Output:** `2`
**Explanation:**
Room 1: [0,30]
Room 2: [5,10], [15,20]
Minimum 2 rooms.

## Example 2:
## *Ví dụ 2:*

**Input:** `intervals = [[7,10],[2,4]]`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `1 <= intervals.length <= 10^4`
*   `0 <= start_i < end_i <= 10^6`
