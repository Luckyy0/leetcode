# Analysis for Find Median from Data Stream
# *Phân tích cho bài toán Tìm Trung vị từ Dòng dữ liệu*

## 1. Problem Essence & Two Heaps
## *1. Bản chất vấn đề & Hai Heap*

### The Challenge
### *Thách thức*
Maintain a running list of numbers such that we can find the median in $O(1)$.
Insertion should be reasonably fast ($O(\log N)$).
Sorting array every time is $O(N \log N)$. Insertion Sort is $O(N)$. We need better.

### Strategy: Two Priority Queues (Min-Max Heaps)
### *Chiến lược: Hai Hàng đợi ưu tiên (Min-Max Heaps)*
Split the list into two halves:
1.  **Lower Half (Max Heap):** Stores the smaller half of numbers. We need the *largest* of these.
2.  **Upper Half (Min Heap):** Stores the larger half of numbers. We need the *smallest* of these.

Invariant:
- $Size(MaxHeap) \approx Size(MinHeap)$.
- Specifically, $0 \le Size(MaxHeap) - Size(MinHeap) \le 1$. (Or vice versa).
- And $\max(MaxHeap) \le \min(MinHeap)$.

Median:
- If sizes equal: $(\max(MaxHeap) + \min(MinHeap)) / 2$.
- If `MaxHeap` bigger: $\max(MaxHeap)$.

### Balancing Logic
### *Logic Cân bằng*
Add `num`:
1.  Add to MaxHeap.
2.  Move largest of MaxHeap to MinHeap (to keep order property).
3.  If `MinHeap.size > MaxHeap.size`: Move smallest of MinHeap back to MaxHeap (to keep size property).

---

## 2. Approach: Two Heaps
## *2. Hướng tiếp cận: Hai Heap*

### Logic
### *Logic*
1.  `maxHeap` (Lower half). `minHeap` (Upper half).
2.  `addNum(num)`:
    - `maxHeap.offer(num)`.
    - `minHeap.offer(maxHeap.poll())`. (Ensure sorted order: everything in Min is >= everything in Max).
    - If `maxHeap.size() < minHeap.size()`:
        - `maxHeap.offer(minHeap.poll())`. (Maintain size balance: Max always takes the extra element if odd total).
3.  `findMedian()`:
    - If `maxHeap.size() > minHeap.size()`: Return `maxHeap.peek()`.
    - Else: Return `(maxHeap.peek() + minHeap.peek()) / 2.0`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Efficiency:** Access to median elements is $O(1)$. Rebalancing is $O(\log N)$.
    *Hiệu quả: Truy cập phần tử trung vị là O(1). Cân bằng lại là O(log N).*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** `addNum` $O(\log N)$, `findMedian` $O(1)$.
    *Độ phức tạp thời gian: O(log N) và O(1).*
*   **Space Complexity:** $O(N)$ elements.
    *Độ phức tạp không gian: O(N).*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 1, 2, 3
1.  Add 1: Max[1] -> Min[]. Rebal -> Max[]. Size bal -> Max[1], Min[].
2.  Add 2: Max[1,2] -> Min[2], Max[1]. Size bal -> Equal. Max[1], Min[2].
    - Median: (1+2)/2 = 1.5.
3.  Add 3: Max[1,3]. Min[2]. Move 3 -> Min[2,3]. Max[1].
    - Rebal sizes: Min has 2, Max has 1. Move 2 back to Max.
    - Max[1,2], Min[3].
    - Median: Max top (2).

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard pattern for running median.
*Mẫu tiêu chuẩn cho trung vị chạy.*
---
*Luôn giữ cân bằng giữa hai thái cực (nhỏ nhất và lớn nhất) để tìm ra điểm cân bằng ở giữa (median). Sự cân bằng là chìa khóa.*
Always maintain balance between two extremes (min and max) to find the equilibrium point (median). Balance is key.
