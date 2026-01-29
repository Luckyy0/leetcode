# 630. Course Schedule III / Lịch Trình Khóa Học III

## Problem Description / Mô tả bài toán
There are `n` different online courses numbered from `1` to `n`. You are given an array `courses` where `courses[i] = [duration_i, lastDay_i]` indicate that the `i-th` course should be taken **continuously** for `duration_i` days and must be finished before or on `lastDay_i`.
Có `n` khóa học trực tuyến khác nhau được đánh số từ `1` đến `n`. Bạn được cho một mảng `courses` trong đó `courses[i] = [duration_i, lastDay_i]` chỉ ra rằng khóa học thứ `i` nên được thực hiện **liên tục** trong `duration_i` ngày và phải hoàn thành trước hoặc vào `lastDay_i`.

You will start on the `1st` day and you cannot take two or more courses simultaneously. Return the maximum number of courses that you can take.
Bạn sẽ bắt đầu vào ngày `thứ 1` và bạn không thể tham gia hai hoặc nhiều khóa học cùng một lúc. Trả về số lượng khóa học tối đa mà bạn có thể tham gia.

### Example 1:
```text
Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
Output: 3
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy + Priority Queue / Tham Lam + Hàng Đợi Ưu Tiên
Sort courses by `lastDay`. This is because we want to finish courses that have an earlier deadline first?
Or at least consider them in order of urgency.
Iterate through sorted courses. Maintain current `time`.
If we can take a course (`time + duration <= lastDay`), take it. Push `duration` to PQ (Max Heap).
If we cannot take it, check if this course takes *less time* than the longest course we've already taken (top of Max Heap).
If `duration < PQ.peek()`, we swap! We remove the longest course and replace it with this shorter one.
Why? Because by swapping, we reduce the total `time` consumed, but keep the count of courses the same. This gives us more "room" for future courses. Since we sorted by `lastDay`, the current `lastDay` is >= all previous `lastDay`s, so the swap is valid (validity of previous courses is preserved because total time decreases).

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Greedy with Heap

**Algorithm**:
1.  Sort courses by deadline ASC.
2.  Use Max Heap to track durations of taken courses.
3.  Iterate courses:
    - Add to time.
    - Push duration to heap.
    - If time exceeds deadline, remove max duration from heap and subtract from time.
4.  Heap size is result.

---
