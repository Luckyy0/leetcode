# Analysis for Find Bottom Left Tree Value
# *Phân tích cho bài toán Tìm Giá trị Cây Dưới cùng Bên trái*

## 1. Problem Essence & BFS Traversal Order
## *1. Bản chất vấn đề & Thứ tự Duyệt BFS*

### The Challenge
### *Thách thức*
Finding the first node of the last level.
- Standard BFS (Level Order) visits level by level, left to right.
- If we iterate left to right, the "leftmost" is the *first* node of the last level.
- Alternatively, if we traverse **Right to Left**, the "leftmost" node will be the **last** node visited in the entire traversal.

### Strategy: Right-to-Left BFS
### *Chiến lược: BFS Phải sang Trái*

1.  **Queue:** Add root.
2.  **Loop:** While queue is not empty:
    - Poll `node`.
    - If `node.right` exists, add to queue.
    - If `node.left` exists, add to queue.
    - Update `result = node.val`.
3.  **Result:** When queue is empty, the last processed node is the bottom-left one.

---

## 2. Approach: BFS (Queue)
## *2. Hướng tiếp cận: BFS (Hàng đợi)*

### Logic
### *Logic*
(See above). Simpler than tracking level depth explicitly.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Simplicity:** No need to check "is this the first node of the level?". Just the last node visited.
    *Đơn giản: Không cần kiểm tra "đây có phải là nút đầu tiên của cấp không?". Chỉ cần là nút cuối cùng được ghé thăm.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(W)$ (Width of tree).
    *Độ phức tạp không gian: $O(W)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[2, 1, 3]`
1. Q: `[2]`.
2. Pop `2`. Add `3` (R), then `1` (L). Q: `[3, 1]`. Result: 2.
3. Pop `3`. No children. Result: 3.
4. Pop `1`. No children. Result: 1.
5. Empty. Return 1. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Right-to-Left Level Order Traversal.
*Duyệt theo thứ tự mức từ Phải sang Trái.*
---
*Đôi khi để tìm ra nền tảng cuối cùng (bottom left), ta nên đi ngược lại số đông (right to left). Người cuối cùng ở lại (last node visited) sau khi tất cả những ồn ào đi qua, chính là người nắm giữ vị trí quan trọng nhất ở tầng sâu nhất.*
Sometimes to find the final foundation (Bottom Left), we should go against the crowd (Right To Left). The last person to stay (Last Node Visited) after all the noise passes, is the person holding the most important position at the deepest level.
