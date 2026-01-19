# 252. Meeting Rooms / Phòng Họp

## Problem Description / Mô tả bài toán
Given an array of meeting time intervals where `intervals[i] = [starti, endi]`, determine if a person can attend all meetings.
Cho một mảng các khoảng thời gian họp `intervals[i] = [starti, endi]`, xác định xem một người có thể tham dự tất cả các cuộc họp hay không.

### Example 1:
```text
Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
```

### Example 2:
```text
Input: intervals = [[7,10],[2,4]]
Output: true
```

## Constraints / Ràng buộc
- `0 <= intervals.length <= 10^4`
- `intervals[i].length == 2`
- `0 <= starti < endi <= 10^6`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Sorting + Linear Scan / Sắp xếp + Quét Tuyến Tính
To attend all meetings, no two meetings can overlap.
Two intervals `[s1, e1]` and `[s2, e2]` overlap if `s1 < e2` and `s2 < e1`.
If we sort the intervals by **start time**, we just need to check if the `start` of the next meeting is **before** the `end` of the current meeting.

Condition for overlap between sorted `meeting[i]` and `meeting[i+1]`:
`meeting[i].end > meeting[i+1].start`

**Algorithm**:
1.  Sort intervals by start time.
2.  Iterate from `0` to `n-2`.
3.  If `intervals[i][1] > intervals[i+1][0]`: Return `false` (overlap detected).
4.  Return `true`.

### Complexity / Độ phức tạp
- **Time**: O(N log N) - Sorting dominates.
- **Space**: O(1) or O(log N) for sort stack.

---

## Analysis / Phân tích

### Approach: Sort and Check

**Edge Cases**:
1.  **Empty/Single interval**: True.
2.  **Touching intervals**: `[1, 2], [2, 3]` -> No overlap (person can attend 1-2 then 2-3 instantly). Condition is strict `>`.

---

