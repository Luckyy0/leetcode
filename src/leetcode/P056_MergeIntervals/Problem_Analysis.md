# 56. Merge Intervals / Hợp Nhất Các Khoảng

## Problem Description / Mô tả bài toán
Given an array of `intervals` where `intervals[i] = [start_i, end_i]`, merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
Cho một mảng các `intervals` trong đó `intervals[i] = [start_i, end_i]`, hãy hợp nhất tất cả các khoảng chồng chéo và trả về một mảng các khoảng không chồng chéo bao gồm tất cả các khoảng trong đầu vào.

### Example 1:
```text
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
```

### Example 2:
```text
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
```

## Constraints / Ràng buộc
- `1 <= intervals.length <= 10^4`
- `intervals[i].length == 2`
- `0 <= start_i <= end_i <= 10^4`

---

## Analysis / Phân tích

### Approach: Sorting / Sắp Xếp
- **Idea**: If we sort the intervals by their start time, then we can merge them in a linear pass.
- **Ý tưởng**: Nếu chúng ta sắp xếp các khoảng theo thời gian bắt đầu, thì chúng ta có thể hợp nhất chúng trong một lần duyệt tuyến tính.
- **Algorithm**:
    1.  Sort `intervals` by `start` ascending.
    2.  Add the first interval to a list `merged`.
    3.  Iterate through the rest of the intervals:
        - Get the last interval in `merged` (let's call it `last`).
        - If `current.start <= last.end`, they overlap. Merge them by updating `last.end = max(last.end, current.end)`.
        - Else, they don't overlap. Add `current` to `merged`.
- **Time Complexity**: O(N log N) due to sorting.
- **Space Complexity**: O(N) (or O(log N) for sorting stack depending on implementation).

---

## Edge Cases / Các trường hợp biên
1.  **Single Interval**: Return as is.
2.  **Fully Contained**: `[1, 5], [2, 3]` -> `[1, 5]`.
3.  **Touching**: `[1, 4], [4, 5]` -> `[1, 5]`.
