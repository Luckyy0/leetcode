# Analysis for Sliding Window Median
# *Phân tích cho bài toán Trung vị Cửa sổ Trượt*

## 1. Problem Essence & Dynamic Order
## *1. Bản chất vấn đề & Thứ tự Động*

### The Challenge
### *Thách thức*
Finding the median in a moving window. The median requires sorted order. Re-sorting the window every time is $O(k \log k)$, leading to total $O(N \cdot k \log k)$, which is too slow (TLE) for large $k$. We need a structure that supports efficient insertion, deletion, and median retrieval.

### Strategy: Two Heaps (Dual Priority Queues)
### *Chiến lược: Hai Hàng đợi Ưu tiên*

1.  **Structure:** Use two heaps to maintain the elements of the window.
    - `small`: Max-Heap storing the smaller half of numbers.
    - `large`: Min-Heap storing the larger half of numbers.
2.  **Balancing:** Keep `small` size equal to or 1 greater than `large`.
    - Median is top of `small` (if odd size) or average of tops (if even size).
    - Note: `nums[i]` can be large, use `long` for sum to avoid overflow (though median calculation usually involves division, intermediate sum `x+y` might overflow `int` range if signs are same? Wait, range is full integer range. `(long)a + b` is safer).
3.  **Sliding:**
    - **Add:** Insert new element into appropriate heap, then rebalance.
    - **Remove:** Remove the element leaving the window. Since finding an arbitrary element in a heap is $O(k)$, standard `PriorityQueue` remove is slow ($O(k)$). Total time $O(N \cdot k)$ is still potentially slow ($10^5 \times 10^5$).
    - **Lazy Removal:** Instead of scanning to remove, we can mark elements as "to be removed" in a HashMap (delayed deletion). We only physically pop them from the heap when they come to the top. This keeps amortized complexity $O(\log N)$.

### Alternative: TreeSet (if duplicates handled)
### *Phương án thay thế: TreeSet*

Java `TreeSet` finds/removes in $O(\log k)$. However, it doesn't handle duplicates. We can index elements by pair `(value, index)` to make them unique.
- Maintain two TreeSets? Or one and iterate?
- Two Heaps with Lazy Removal is more standard and avoids iterating the TreeSet (finding median index in one TreeSet is $O(k)$ unless we use an Order Statistic Tree).

---

## 2. Approach: Dual Heaps with Lazy Removal
## *2. Hướng tiếp cận: Hai Hàng đợi Ưu tiên với Xóa lười*

### Logic
### *Logic*
(See above). 
1. `incoming` enters: push to `small`, then pop `small.top` to `large`, then rebalance sizes.
2. `outgoing` leaves: mark in `delayed` Map. Update `balance` variable (-1 if from small, +1 if from large). Rebalance heaps based on logical sizes.
3. Pruning: loop `while heap.top` is in `delayed`: pop and decrement count in Map.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Logarithmic Updates:** All operations are amortized $O(\log k)$.
    *Cập nhật Logarit: Tất cả các thao tác có độ phức tạp trung bình $O(\log k)$.*
*   **Dynamic Median:** Constant time access to potential median candidates (heap tops).
    *Trung vị động: Truy cập thời gian hằng số vào các ứng viên trung vị tiềm năng.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log k)$, assuming lazy removal keeps heap size proportional to $k$.
    *Độ phức tạp thời gian: $O(N \log k)$.*
*   **Space Complexity:** $O(k)$ (can be up to $O(N)$ in worst case if lazy removals pile up, but for sliding window, usually bounded).
    *Độ phức tạp không gian: $O(k)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 3, -1]`, k=3
1. Add `1`: `S=[1], L=[]`.
2. Add `3`: `S=[1], L=[3]`. Bal: `S=[1], L=[3]`.
3. Add `-1`: `S=[-1, 1], L=[3]`. Rebal: `S=[1], L=[3, -1]`? No. Logic: `add` to small, move top to big.
   - Insert -1 to S: `S=[1, -1]`. Move 1 to L: `L=[1, 3]`. `S=[-1]`.
   - Size `L(2) > S(1)`. Move `L.top(1)` to S. `S=[1, -1], L=[3]`. Correct (MaxHeap in S will involve -1? Wait, S is MaxHeap).
   - `S` (MaxHeap): `[-1]`. `L` (MinHeap): `[1, 3]`.
   - Wait, `small` stores smaller half. So `small` elements must be $\le$ `large` elements.
   - `small` should hold smaller values. `small.max` $\le$ `large.min`.
   - Correct initial logic for `[1, 3, -1]`:
     - Add 1: `S=[1]`.
     - Add 3: `S=[1]`, `L=[3]`. (3 > 1).
     - Add -1: `S=[-1, 1]`. Pop 1 $\to$ `L=[1, 3]`. `S=[-1]`. Rebal: `S=[1, -1]`, `L=[3]`.
     - Median: 1.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Dual PriorityQueues with Hash Map for lazy deletion.
*Sử dụng hai Hàng đợi Ưu tiên với HashMap để xóa lười.*
---
*Trung vị (median) là điểm cân bằng giữa hai thái cực (small & large). Trong một dòng chảy không ngừng (sliding window), để giữ được sự thăng bằng đó, ta phải linh hoạt đón nhận cái mới (insertion) và buông bỏ cái cũ (deletion). Đôi khi, sự buông bỏ không diễn ra ngay lập tức (lazy removal), mà ta chỉ đánh dấu nó như một ký ức đã qua, chờ đến thời điểm thích hợp để thực sự giải phóng. Đó là nghệ thuật của sự quản lý trạng thái động.*
The median (median) is the balance point between two extremes (Small & Large). In a constant flow (sliding window), to keep that balance, we must be flexible to receive new (Insertion) and let go of the old (deletion). Sometimes, determining does not happen immediately (Lazy Removal), but we only mark it as a past memory, waiting for the right time to actually liberate. That is the art of dynamic state management.
