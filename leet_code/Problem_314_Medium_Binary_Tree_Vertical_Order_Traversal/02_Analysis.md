# Analysis for Binary Tree Vertical Order Traversal
# *Phân tích cho bài toán Duyệt Cây Nhị phân theo Thứ tự Dọc*

## 1. Problem Essence & BFS
## *1. Bản chất vấn đề & BFS*

### The Challenge
### *Thách thức*
Nodes have `(r, c)` coordinates.
We want to group by `c`, sorted by `c`, then by `r`.
If same `(r, c)`, order left-to-right (implied by traversal order).
DFS explores deep first, so it might visit deeper nodes (higher r) in column `C` before shallower nodes (lower r) in same column `C`. This violates "top to bottom" requirement.
DFS requires unstable sorting or keeping track of depth and sorting by depth.
BFS explores layer by layer (increasing `r`).
So BFS naturally satisfies "top to bottom" for each column.

### Strategy: BFS with Column Tracking
### *Chiến lược: BFS với Theo dõi Cột*
Queue stores `(Node, col)`.
Map `col -> List<Node.val>`.
Range `[minCol, maxCol]` to iterate map easily without sorting keys.

---

## 2. Approach: BFS
## *2. Hướng tiếp cận: BFS*

### Logic
### *Logic*
1.  Result list, Map `columnTable`, Queue `q` of Pairs `(node, col)`. `minCol = 0`, `maxCol = 0`.
2.  Add `(root, 0)`.
3.  While `q` not empty:
    - Pop `(node, col)`.
    - Add `node.val` to `columnTable[col]`.
    - Update `minCol`, `maxCol`.
    - If `left`: Add `(left, col - 1)`.
    - If `right`: Add `(right, col + 1)`.
4.  Iterate `i` from `minCol` to `maxCol`:
    - Add `columnTable[i]` to result.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Order Preservation:** BFS guarantees visiting nodes in increasing order of depth (row).
    *Bảo toàn thứ tự: BFS đảm bảo thăm các nút theo thứ tự độ sâu (hàng) tăng dần.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 3 -> L:9, R:20 -> L:15, R:7
Queue: `[(3, 0)]`
Pop 3. Map: `{0: [3]}`.
Push (9, -1), (20, 1).
Pop 9. Map: `{-1: [9], 0: [3]}`.
Pop 20. Map: `{-1: [9], 0: [3], 1: [20]}`. Push (15, 0), (7, 2).
Pop 15. Map: `0: [3, 15]`.
Pop 7. Map: `2: [7]`.
Order keys -1 to 2: `[9], [3, 15], [20], [7]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

BFS is superior to DFS here due to row-order requirement.
*BFS vượt trội hơn DFS ở đây do yêu cầu thứ tự hàng.*
---
*Đôi khi đi ngang (BFS) lại giúp ta nhìn thấy chiều dọc (vertical) rõ ràng hơn là đi sâu (DFS).*
Sometimes going sideways (BFS) helps us see the vertical dimension more clearly than going deep (DFS).
