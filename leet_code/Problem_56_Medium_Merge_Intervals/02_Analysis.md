# Analysis for Merge Intervals
# *Phân tích cho bài toán Hợp Nhất Các Khoảng*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** 2D array of intervals `[start, end]`. *Mảng 2 chiều các khoảng `[start, end]`.*
*   **Output:** 2D array of merged intervals. *Mảng 2 chiều các khoảng đã hợp nhất.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Length up to $10^4$. Sorting is feasible $O(N \log N)$.
*   Intervals can be out of order.
*   *Độ dài lên tới $10^4$. Sắp xếp là khả thi $O(N \log N)$.*
*   *Các khoảng có thể không theo thứ tự.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Sorting and Merging
### *Hướng tiếp cận: Sắp xếp và Hợp nhất*

*   **Intuition:** Sort the intervals based on their start times. Then, iterate through the sorted intervals. If the current interval overlaps with the last merged interval, merge them by updating the end time. Otherwise, add the current interval to the result.
*   *Ý tưởng: Sắp xếp các khoảng dựa trên thời gian bắt đầu của chúng. Sau đó, duyệt qua các khoảng đã sắp xếp. Nếu khoảng hiện tại chồng lấn với khoảng đã hợp nhất cuối cùng, hãy hợp nhất chúng bằng cách cập nhật thời gian kết thúc. Nếu không, hãy thêm khoảng hiện tại vào kết quả.*

*   **Algorithm Steps:**
    1.  Sort `intervals` by `start` time.
    2.  Use a list to store merged intervals. Add the first intervals[0].
    3.  Iterate `i` from 1 to `n-1`:
        *   `lastMerged = list.last()`.
        *   If `intervals[i].start <= lastMerged.end`:
            *   `lastMerged.end = max(lastMerged.end, intervals[i].end)`.
        *   Else:
            *   Add `intervals[i]` to list.
    4.  Convert list to array.

*   **Complexity:**
    *   Time: $O(N \log N)$ due to sorting.
    *   Space: $O(N)$ for sorting and storing result.

### Dry Run
### *Chạy thử*
`[[1,3],[2,6],[8,10],[15,18]]`
1. Sorted: `[[1,3],[2,6],[8,10],[15,18]]` (already sorted).
2. Start with `[1,3]`.
3. Try `[2,6]`: `2 <= 3`. Merge. New interval: `[1, 6]`.
4. Try `[8,10]`: `8 > 6`. No overlap. New interval: `[8, 10]`.
5. Try `[15,18]`: `15 > 10`. No overlap. New interval: `[15, 18]`.
Merged result: `[[1,6],[8,10],[15,18]]`.
---
*Việc sắp xếp là chìa khóa để giải quyết bài toán này một cách hiệu quả.*
Sorting is the key to solving this problem efficiently.
