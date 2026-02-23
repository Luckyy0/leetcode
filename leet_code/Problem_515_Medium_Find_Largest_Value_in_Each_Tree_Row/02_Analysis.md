# Analysis for Find Largest Value in Each Tree Row
# *Phân tích cho bài toán Tìm Giá trị Lớn nhất trong Mỗi Hàng Cây*

## 1. Problem Essence & Level Max
## *1. Bản chất vấn đề & Giá trị Lớn nhất theo Mức*

### The Challenge
### *Thách thức*
Finding the maximum value at each depth level.
- BFS (Level Order) naturally groups nodes by level.
- DFS can also work if we pass `depth` and update a result list.

### Strategy: BFS Level Order
### *Chiến lược: BFS Theo thứ tự Mức*

1.  **Queue:** Process level by level.
2.  **Inner Loop:** Iterate `size` times (current level width).
3.  **Max Tracking:** Maintain `maxVal` for current loop.
4.  **Result:** Add `maxVal` to list after finishing level.

---

## 2. Approach: BFS
## *2. Hướng tiếp cận: BFS*

### Logic
### *Logic*
(See above). Initialize `maxVal` to `Integer.MIN_VALUE`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Iterative:** Avoids recursion stack depth issues (though tree depth is rarely an issue for 10^4).
    *Lặp: Tránh các vấn đề về độ sâu ngăn xếp đệ quy.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(W)$.
    *Độ phức tạp không gian: $O(W)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1,3,2]`
1. Q: `[1]`.
2. Level 1: Pop `1`. Max 1. Add children 3, 2. Res: `[1]`.
3. Level 2: Pop `3`, Pop `2`. Max 3. Res: `[1, 3]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard BFS tracking max per level.
*BFS chuẩn theo dõi max mỗi mức.*
---
*Trong mỗi tầng lớp xã hội (tree row), luôn có những cá nhân nổi bật nhất (largest value). Việc nhìn nhận họ đòi hỏi ta phải quét qua toàn bộ mặt bằng chung (level traversal) chứ không chỉ nhìn vào một cá nhân đơn lẻ. Mỗi tầng cao mới lại mang đến những kỷ lục mới.*
In every social class (Tree Row), there are always the most prominent individuals (Largest Value). Recognizing them requires us to scan the entire common ground (Level Traversal), not just looking at a single individual. Each new high floor brings new records.
