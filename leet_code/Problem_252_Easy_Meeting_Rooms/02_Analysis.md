# Analysis for Meeting Rooms
# *Phân tích cho bài toán Phòng họp*

## 1. Problem Essence & Sorting
## *1. Bản chất vấn đề & Sắp xếp*

### The Condition
### *Điều kiện*
To attend all meetings, NO two meetings can overlap.
Overlap condition for `[s1, e1]` and `[s2, e2]` (assume `s1 <= s2`):
Overlap if `s2 < e1`.
*Để tham dự tất cả, KHÔNG cuộc họp nào được chồng chéo. Chồng chéo nếu thời gian bắt đầu của cuộc sau nhỏ hơn thời gian kết thúc của cuộc trước.*

### Strategy
### *Chiến lược*
1.  Sort intervals by start time.
2.  Iterate and check if `current.start < previous.end`.
3.  If any overlap, return `false`.

---

## 2. Approach: Sorting
## *2. Hướng tiếp cận: Sắp xếp*

### Logic
### *Logic*
1.  Sort `intervals` based on `start`.
2.  Loop from `i = 1` to `n-1`:
    - Prev = `intervals[i-1]`.
    - Curr = `intervals[i]`.
    - If `curr.start < prev.end`: Return `false`.
3.  Return `true`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Linear Scan after Sort:** Once sorted, we only need to compare adjacent intervals.
    *Quét tuyến tính sau khi sắp xếp: Chỉ cần so sánh các khoảng lân cận.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ due to sorting.
    *Độ phức tạp thời gian: $O(N \log N)$ do sắp xếp.*
*   **Space Complexity:** $O(1)$ or $O(\log N)$ for sorting stack.
    *Độ phức tạp không gian: $O(1)$ hoặc $O(\log N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[[0,30], [5,10], [15,20]]`
Sorted: `[0,30], [5,10], [15,20]`
1.  Compare `[5,10]` with `[0,30]`. `5 < 30`. Overlap! Return `false`.

**Input:** `[[7,10], [2,4]]`
Sorted: `[2,4], [7,10]`
1.  Compare `[7,10]` with `[2,4]`. `7 >= 4`. No overlap.
Return `true`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Sorting is the key. Without sorting, you'd need $O(N^2)$ to compare all pairs.
*Sắp xếp là chìa khóa. Không sắp xếp sẽ tốn $O(N^2)$.*
---
*Thời gian là tài nguyên hữu hạn không thể xếp chồng. Hãy sắp xếp cuộc đời mình ngăn nắp để không bỏ lỡ khoảnh khắc nào.*
Time is a finite resource that cannot be stacked. Sort your life neatly so you don't miss a moment.
