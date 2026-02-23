# Analysis for Meeting Rooms II
# *Phân tích cho bài toán Phòng họp II*

## 1. Problem Essence & Resource Allocation
## *1. Bản chất vấn đề & Phân bổ tài nguyên*

### The Challenge
### *Thách thức*
We need to find the max overlap at any point in time. This is equivalent to finding the peak number of simultaneous meetings.
Often solved with "Line Sweep" or "Min-Heap".
*Cần tìm độ chồng lấn cực đại. Tương đương tìm số cuộc họp đồng thời lớn nhất.*

### Strategy 1: Min-Heap
### *Chiến lược 1: Min-Heap*
1.  Sort intervals by Start Time.
2.  Use a Min-Heap to store **End Times** of active meetings.
3.  Iterate through sorted intervals:
    - If `curr.start >= heap.min` (earliest ending meeting):
        - We can re-use that room. Poll the heap (remove earliest end).
    - Add `curr.end` to heap (new meeting occupies a room, either reused or new).
4.  Heap size is the number of rooms needed.

### Strategy 2: Line Sweep / Two Arrays
### *Chiến lược 2: Quét dòng / Hai mảng*
1.  Separate Start times and End times into two arrays.
2.  Sort both arrays.
3.  Use two pointers.
    - If `start[i] < end[j]`: New meeting checking in. `rooms++`, `i++`. Update max.
    - If `start[i] >= end[j]`: Meeting ended. `rooms--`, `j++`.
    - This tracks distinct events.

---

## 2. Approach: Min-Heap
## *2. Hướng tiếp cận: Min-Heap*

### Logic
### *Logic*
1.  Sort `intervals` by start time.
2.  PriorityQueue `pq` (Min Heap).
3.  Loop `interval` in `intervals`:
    - While `!pq.isEmpty()` && `interval.start >= pq.peek()`:
        - `pq.poll()` (Room freed up).
    - `pq.offer(interval.end)`.
    - Note: Actually we only need to poll ONE room if we want to reuse. Wait.
    - Correct Logic:
        - If `start >= min_end`: Reuse room -> `poll`, then `offer`.
        - Else: New room -> `offer`.
    - Or simply: `if (start >= peek) poll(); offer(end);`
    - Finally, `pq.size()` is the answer? NO. Since we might poll and then offer, size might fluctuate but represents currently occupied rooms. We need MAX size?
    - Actually, with the "poll if reusable" logic, the heap size grows only when we *cannot* reuse. So heap size *at the end* is the minimum rooms required to accommodate all.
    - Why? Because if we reuse, size stays same (poll+offer). If we can't, size increases (offer). We never explicit shrink unless necessary? No, we shrink when room free. But we immediately use it.
    - Let's verify.
    - Input: `[0,30], [5,10], [15,20]`.
    - `[0,30]`: Heap `[30]`.
    - `[5,10]`: `5 < 30`. push 10. Heap `[10, 30]`.
    - `[15,20]`: `15 >= 10`. poll 10. push 20. Heap `[20, 30]`.
    - Final size 2. Correct.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Heap Efficiency:** Managing earliest availability is efficient ($O(1)$ access).
    *Hiệu quả Heap: Quản lý phòng trống sớm nhất rất hiệu quả.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ (Sort + Heap ops).
    *Độ phức tạp thời gian: $O(N \log N)$.*
*   **Space Complexity:** $O(N)$ (Heap).
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[[0,30], [5,10], [15,20]]`
Sorted: same.

1.  i=0 `[0,30]`. Heap `{30}`.
2.  i=1 `[5,10]`. Start 5 < Min 30. No room free. New room. Heap `{10, 30}`.
3.  i=2 `[15,20]`. Start 15 >= Min 10. Room free (the one ending at 10).
    - Remove 10.
    - Occupy with 20.
    - Heap `{20, 30}`.
Final size: 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Heap is elegant. Line sweep (Chronological Ordering) is faster ($O(N \log N)$ but lower constant) and uses less space if just pointers. Heap is easier to write.
*Heap rất thanh lịch. Quét dòng nhanh hơn một chút và dùng ít không gian hơn.*
---
*Đừng mở thêm phòng mới khi phòng cũ đã trả. Tài nguyên tối ưu là sự cân bằng giữa nhu cầu và tái sử dụng.*
Don't open a new room when the old one is vacated. Optimal resource uses the balance between demand and reuse.
