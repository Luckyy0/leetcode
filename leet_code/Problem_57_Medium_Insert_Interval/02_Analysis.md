# Analysis for Insert Interval
# *Phân tích cho bài toán Chèn Khoảng*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Sorted non-overlapping intervals, and one `newInterval`. *Các khoảng đã sắp xếp không chồng lấn, và một `newInterval`.*
*   **Output:** New list of sorted non-overlapping intervals. *Danh sách mới các khoảng đã sắp xếp không chồng lấn.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Complexity should be $O(N)$.
*   We can leverage the fact that input is already sorted.
*   *Độ phức tạp nên là $O(N)$.*
*   *Chúng ta có thể tận dụng việc đầu vào đã được sắp xếp.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Linear Pass
### *Hướng tiếp cận: Duyệt Tuyến tính*

*   **Intuition:** Divide the task into three parts:
    1.  Add all intervals that end before `newInterval` starts.
    2.  Merge all intervals that overlap with `newInterval`.
    3.  Add all intervals that start after the merged `newInterval` ends.
*   *Ý tưởng: Chia nhiệm vụ thành ba phần:*
    1.  *Thêm tất cả các khoảng kết thúc trước khi `newInterval` bắt đầu.*
    2.  *Hợp nhất tất cả các khoảng chồng lấn với `newInterval`.*
    3.  *Thêm tất cả các khoảng bắt đầu sau khi `newInterval` đã hợp nhất kết thúc.*

*   **Algorithm Steps:**
    1.  Initialize result list.
    2.  Iterate `intervals`:
        *   While current interval ends before `newInterval.start`: Add to result.
        *   While current interval overlaps (starts before `newInterval.end`): Update `newInterval` boundaries.
        *   Add merged `newInterval`.
        *   Add remaining intervals.

*   **Complexity:**
    *   Time: $O(N)$.
    *   Space: $O(N)$ for result list.

### Dry Run
### *Chạy thử*
`intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]`
1. `[1,2]` ends before 4 starts. Add `[[1,2]]`.
2. `[3,5]` overlaps (3 <= 8). `newInterval` becomes `[3, 8]`.
3. `[6,7]` overlaps (6 <= 8). `newInterval` stays `[3, 8]`.
4. `[8,10]` overlaps (8 <= 8). `newInterval` becomes `[3, 10]`.
5. Add merged `[3, 10]`. Result: `[[1,2], [3,10]]`.
6. Add remaining: `[12,16]`. Result: `[[1,2], [3,10], [12,16]]`.
---
*Cách tiếp cận này đảm bảo tính đúng đắn và hiệu quả mà không cần sắp xếp lại.*
This approach ensures correctness and efficiency without re-sorting.
