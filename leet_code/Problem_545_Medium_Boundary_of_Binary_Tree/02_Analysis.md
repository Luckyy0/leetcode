# Analysis for Boundary of Binary Tree
# *Phân tích cho bài toán Biên của Cây Nhị phân*

## 1. Problem Essence & Partitions
## *1. Bản chất vấn đề & Phân vùng*

### The Challenge
### *Thách thức*
Traversing specific parts of the tree (Left Boundary, Leaves, Right Boundary) without duplication.

### Strategy: Separation of Concerns
### *Chiến lược: Phân tách Mối quan tâm*

1.  **Add Root:** Add root value first. If root is leaf, return immediately.
2.  **Add Left Boundary:**
    - Start from `root.left`.
    - Recursively/Iteratively go left (if left exists) or right (if left missing).
    - Stop *before* reaching a leaf.
3.  **Add Leaves:**
    - Traverse entire tree (DFS/Preorder).
    - Add node if it is a leaf.
    - Order is naturally left-to-right.
4.  **Add Right Boundary:**
    - Start from `root.right`.
    - Go right (if right exists) or left.
    - Store in stack/list and add in reverse.
    - Stop *before* reaching a leaf.

---

## 2. Approach: Modular DFS
## *2. Hướng tiếp cận: DFS Mô-đun*

### Logic
### *Logic*
(See above). The key is `isLeaf(node)` check.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Logic Separation:** Handles edge cases (overlapping boundaries) by excluding leaves from boundary traversals.
    *Phân tách Logic: Xử lý các trường hợp biên (biên chồng chéo) bằng cách loại trừ lá khỏi duyệt biên.*
*   **O(N) Time:** Visits boundary nodes and leaves. Maximum visits is roughly proportional to N (leaves traversal visits all).
    *Thời gian O(N): Thăm các nút biên và lá.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ (Result + Stack).
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 2, 3, 4, 5, 6]`
1. Root `1`. Add `1`.
2. Left Boundary of `2`:
   - `2` is not leaf. Add `2`.
   - `4` is leaf. Stop.
   - Result: `[1, 2]`.
3. Leaves:
   - `4`, `5`, `6`. Add `4, 5, 6`.
   - Result: `[1, 2, 4, 5, 6]`.
4. Right Boundary of `3`:
   - `3` is not leaf. Add `3` to temp stack.
   - `6` is leaf. Stop.
   - Pop stack `3` and add.
   - Result: `[1, 2, 4, 5, 6, 3]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Follow the definition carefully: Left Boundary (no leaf) -> Leaves -> Right Boundary (Reverse, no leaf).
*Tuân theo định nghĩa cẩn thận: Biên trái (không lá) -> Lá -> Biên phải (Đảo ngược, không lá).*
---
*Đường biên (Boundary) là nơi định hình khuôn khổ, nhưng những chiếc lá (Leaves) mới là nơi sự sống sinh sôi. Kết nối gốc rễ (Root) với những giới hạn (Boundaries) và những chi tiết nhỏ nhất (Leaves), ta có được bức tranh toàn cảnh về sự tồn tại của cái cây.*
The boundary (Boundary) is where the framework is shaped, but the leaves (Leaves) are where life flourishes. Connecting the roots (Root) with limits (Boundaries) and the smallest details (Leaves), we get a panoramic picture of the tree's existence.
