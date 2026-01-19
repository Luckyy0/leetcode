# 253. Meeting Rooms II / Phòng Họp II

## Problem Description / Mô tả bài toán
Given an array of meeting time intervals `intervals` where `intervals[i] = [starti, endi]`, return the minimum number of conference rooms required.
Cho một mảng các khoảng thời gian họp `intervals` trong đó `intervals[i] = [starti, endi]`, hãy trả về số lượng phòng hội nghị tối thiểu cần thiết.

### Example 1:
```text
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
```

### Example 2:
```text
Input: intervals = [[7,10],[2,4]]
Output: 1
```

## Constraints / Ràng buộc
- `1 <= intervals.length <= 10^4`
- `0 <= starti < endi <= 10^6`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Min-Heap (Priority Queue) Approach / Tiếp Cận Hàng Đợi Ưu Tiên
We need to allocate rooms. When a new meeting starts, we check if any existing occupied room has become free.
A room becomes free when the meeting in it **ends**.

**Algorithm**:
1.  Sort intervals by **start time**.
2.  Use a **Min-Heap** to store the **end times** of meetings currently in progress.
3.  Iterate through the sorted meetings:
    - If `heap.min() <= current.start`: It means the room with the earliest end time is free.
        - `poll()` the heap (remove that meeting/room).
        - Add the new meeting's end time to the heap (reuse room).
    - If `heap.min() > current.start`: No room is free.
        - Allocate a new room -> Add new meeting's end time to heap.
    - (Wait, actually logic is simpler: Always add new meeting. But if room free, remove old one first. Heap size is rooms needed).
4.  The size of the heap at the end (or max size encountered?) Not exactly.
    - If we reuse, we remove and add (size stays same).
    - If we don't reuse, we just add (size increases).
    - So simply: `heap.size()` *after processing* isn't strictly the historical max, but the `heap size` grows and shrinks. The logic "remove if free, then add" guarantees heap size equals *current active* rooms.
    - Wait, does heap size represent max rooms or current?
    - We want **minimum number of rooms required**. This is the **Maximum** number of overlapping intervals at any point.
    - The heap size tracks active meetings. The logic `if free remove, then always add` maintains the *historical peak* indirectly?
    - No, if we reuse, size is constant. If we allocate new, size grows. The heap size at the end represents the number of rooms we *ended up with*. Why? Because we never decrease "allocated rooms" theoretically, we just reuse them. Wait.
    - Correct Logic:
      - If `min_end <= start`: `poll` (Room becomes available).
      - `offer(end)` (Occupy room).
      - If we polled, size is same (reuse). If not polled, size +1 (new room).
      - Thus, `heap.size()` at the end is indeed the number of rooms created.

### Alternative: Chronological Ordering
Count `+1` at start times, `-1` at end times. Sort all points. Max cumulative sum is result.

### Complexity / Độ phức tạp
- **Time**: O(N log N) (Sorting) + O(N log N) (Heap ops).
- **Space**: O(N) (Heap).

---

## Analysis / Phân tích

### Approach: Min-Heap

**Algorithm**:
1.  Sort `intervals` by start.
2.  PriorityQueue `pq` (min heap of end times).
3.  `pq.add(intervals[0].end)`.
4.  For `i` from 1 to `N-1`:
    - If `intervals[i].start >= pq.peek()`: `pq.poll()` (Reuse).
    - `pq.add(intervals[i].end)`.
5.  Return `pq.size()`.

---

## Edge Cases / Các trường hợp biên
1.  **Empty**: 0.
2.  **No overlaps**: Size 1 (keeps reusing).
