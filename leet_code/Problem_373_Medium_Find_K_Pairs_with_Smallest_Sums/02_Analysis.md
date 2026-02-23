# Analysis for Find K Pairs with Smallest Sums
# *Phân tích cho bài toán Tìm K cặp có Tổng nhỏ nhất*

## 1. Problem Essence & BFS on Grid
## *1. Bản chất vấn đề & BFS trên Lưới*

### The Challenge
### *Thách thức*
Finding $k$ smallest pairs from a Cartesian product of two sorted arrays. Total pairs can be $10^{10}$, so we cannot generate all.

### Strategy: Min-Heap (Priority Queue)
### *Chiến lược: Min-Heap (Hàng đợi Ưu tiên)*
This is identical to merging $M$ sorted lists, where each list is $(nums1[i] + nums2[0], nums1[i] + nums2[1], \dots)$.
1.  **Initialize:** Add $(nums1[i], nums2[0])$ for all $i$ to a Min-Heap. (Actually, for efficiency, only add up to `min(nums1.length, k)`).
2.  **Iterate $k$ times:**
    - Poll the pair `(nums1[i], nums2[j])` with the smallest sum from the heap.
    - Add it to the result list.
    - **Expand:** The next smallest candidate using `nums1[i]` is `(nums1[i], nums2[j+1])`. Push this to the heap.

---

## 2. Approach: Priority Queue (Merge K Sorted Lists)
## *2. Hướng tiếp cận: Priority Queue (Hợp nhất K Danh sách đã sắp xếp)*

### Logic
### *Logic*
(See above). By starting with one index fixed at 0 and moving it for each row, we ensure we visit pairs in a non-decreasing order of sums without ever generating the full grid.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(K log K) Complexity:** We only process $k$ elements, and each heap operation is logarithmic.
    *Hiệu quả O(K log K): Chúng ta chỉ xử lý k phần tử, và mỗi thao tác heap mất thời gian logarit.*
*   **Memory Efficient:** Maximum heap size is $O(min(N_1, k))$.
    *Tiết kiệm bộ nhớ: Kích thước heap tối đa.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(k \log(\min(n_1, k)))$.
    *Độ phức tạp thời gian: $O(k \log(\min(n_1, k)))$.*
*   **Space Complexity:** $O(\min(n_1, k))$ for the heap.
    *Độ phức tạp không gian: $O(\min(n_1, k))$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums1 = [1,7,11], nums2 = [2,4,6], k = 3`
1. Heap: `[(1,2) index 0,0], [(7,2) index 1,0], [(11,2) index 2,0]`
2. Poll `(1,2)`. Sum 3. Res: `[[1,2]]`. Push `(1,4)` [index 0,1].
3. Heap: `[(1,4) 0,1], [(7,2) 1,0], [(11,2) 2,0]`
4. Poll `(1,4)`. Sum 5. Res: `[[1,2],[1,4]]`. Push `(1,6)` [index 0,2].
5. Heap: `[(1,6) 0,2], [(7,2) 1,0], [(11,2) 2,0]`
6. Poll `(1,6)`. Sum 7. Res: `[[1,2],[1,4],[1,6]]`.
Result: `[[1,2],[1,4],[1,6]]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Min-Heap tracking indices of both arrays.
*Sử dụng Min-Heap theo dõi chỉ số của cả hai mảng.*
---
*Trong một thế giới đầy dẫy những sự kết hợp (pairs), chúng ta không cần phải thử hết tất cả mọi khả năng để tìm thấy điều tốt đẹp nhất (smallest sums). Chỉ cần có một chiến lược đúng đắn (Min-Heap) và tập trung vào những hướng đi tiềm năng nhất, ta sẽ đạt được mục tiêu một cách hiệu quả nhất.*
In a world full of combinations (pairs), we don't need to try all possibilities to find the best (smallest sums). With the right strategy (Min-Heap) and focus on the most potential directions, we reach the goal most efficiently.
