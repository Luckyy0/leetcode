# 435. Non-overlapping Intervals / Các Khoảng Không Chồng Lấn

## Problem Description / Mô tả bài toán
Given an array of intervals `intervals` where `intervals[i] = [starti, endi]`, return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
Cho một mảng các khoảng `intervals` trong đó `intervals[i] = [starti, endi]`, hãy trả về số lượng khoảng tối thiểu bạn cần xóa để các khoảng còn lại không chồng lấn lên nhau.

### Example 1:
```text
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
```

### Example 2:
```text
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
```

### Example 3:
```text
Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
```

## Constraints / Ràng buộc
- `1 <= intervals.length <= 10^5`
- `intervals[i].length == 2`
- `-5 * 10^4 <= starti < endi <= 5 * 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Greedy Scheduling / Lập lịch Tham lam
This is a classic "Interval Scheduling" problem. To keep the maximum number of non-overlapping intervals, we should always pick the interval that **ends the earliest**. Picking the one that ends earliest leaves the most room for subsequent intervals.

Algorithm:
1. Sort the intervals based on their **end times**.
2. Maintain an `end` variable representing the end time of the last added interval (initialized to the end time of the first interval).
3. Count the number of non-overlapping intervals `count` (initialized to 1).
4. Iterate through the remaining intervals:
   - If the current interval's start time is $\ge$ `end`:
     - It doesn't overlap. Increment `count` and update `end` to the current interval's end time.
5. The number of intervals to remove is `total_intervals - count`.

### Complexity / Độ phức tạp
- **Time**: O(N log N) due to sorting.
- **Space**: O(log N) or O(N) depending on the sorting implementation.

---

## Analysis / Phân tích

### Approach: Greedy End-Time Smoothing

**Algorithm**:
1.  Sort by end time.
2.  Count non-overlapping segments.
3.  Calculate difference.

---
