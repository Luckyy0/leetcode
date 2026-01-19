# 57. Insert Interval / Chèn Khoảng

## Problem Description / Mô tả bài toán
You are given an array of non-overlapping intervals `intervals` where `intervals[i] = [start_i, end_i]` represent the start and the end of the `i-th` interval and `intervals` is sorted in ascending order by `start_i`. You are also given an interval `newInterval = [start, end]` that represents the start and end of another interval.
Bạn được cho một mảng các khoảng không chồng chéo `intervals` trong đó `intervals[i] = [start_i, end_i]` đại diện cho điểm bắt đầu và kết thúc của khoảng thứ `i` và `intervals` được sắp xếp theo thứ tự tăng dần bởi `start_i`. Bạn cũng được cho một khoảng `newInterval = [start, end]` đại diện cho điểm bắt đầu và kết thúc của một khoảng khác.

Insert `newInterval` into `intervals` such that `intervals` is still sorted in ascending order by `start_i` and `intervals` still does not have any overlapping intervals (merge overlapping intervals if necessary).
Chèn `newInterval` vào `intervals` sao cho `intervals` vẫn được sắp xếp theo thứ tự tăng dần bởi `start_i` và `intervals` vẫn không có bất kỳ khoảng chồng chéo nào (hợp nhất các khoảng chồng chéo nếu cần thiết).

Return `intervals` after the insertion.
Trả về `intervals` sau khi chèn.

### Example 1:
```text
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
```

### Example 2:
```text
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
```

## Constraints / Ràng buộc
- `0 <= intervals.length <= 10^4`
- `intervals` sorted by start time.
- `newInterval.length == 2`

---

## Analysis / Phân tích

### Approach: Linear Scan / Quét Tuyến Tính
- **Idea**: Since the input is sorted, we can iterate through and handle three phases:
    1.  **Before**: Intervals that end strictly before the new interval starts. Add them directly.
    2.  **Overlap**: Intervals that overlap with the new interval. Merge them into `newInterval` (`min(start)`, `max(end)`).
    3.  **After**: Intervals that start strictly after the new interval ends. Add them directly (after adding the merged `newInterval`).
- **Time Complexity**: O(N).
- **Space Complexity**: O(N) for output.

---

## Edge Cases / Các trường hợp biên
1.  **Empty Intervals**: Return `[newInterval]`.
2.  **No Overlap**: Insert at correct position.
3.  **Full Overlap**: New interval covers all.
