# Analysis for Diameter of Binary Tree
# *Phân tích cho bài toán Đường kính của Cây Nhị phân*

## 1. Problem Essence & Path Through Node
## *1. Bản chất vấn đề & Đường đi qua Nút*

### The Challenge
### *Thách thức*
Finding the longest path between any two nodes.
- For any node `u`, the longest path passing through `u` (where `u` is the highest point on path) is `depth(u.left) + depth(u.right)`.
- The diameter is the maximum of this value over all nodes `u`.

### Strategy: Post-order DFS
### *Chiến lược: DFS Hậu thứ tự*

1.  **Function:** `depth(node)` returns max depth of subtree rooted at `node`.
2.  **Logic:**
    - `L = depth(node.left)`.
    - `R = depth(node.right)`.
    - `diameter = max(diameter, L + R)`.
    - Return `max(L, R) + 1`.
3.  **Global Max:** Keep a global variable (or mutable container) to update max diameter.

---

## 2. Approach: Recursive DFS
## *2. Hướng tiếp cận: DFS Đệ quy*

### Logic
### *Logic*
(See above). Note that depth of leaf is 1 (nodes) or 0 (edges)? Usually depth is max nodes on path. Formula `L+R` works if `depth(null) == 0`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Bottom-Up:** Computes depths naturally.
    *Từ dưới lên: Tính độ sâu một cách tự nhiên.*
*   **O(N) Time:** Single traversal.
    *Thời gian O(N): Một lần duyệt.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(H)$.
    *Độ phức tạp không gian: $O(H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1,2,3,4,5]`
1. `4`: L=0, R=0. Depth=1. MaxD=0.
2. `5`: L=0, R=0. Depth=1. MaxD=0.
3. `2`: L=1, R=1. Path=2. MaxD=2. Depth=2.
4. `3`: L=0, R=0. Depth=1. MaxD=2.
5. `1`: L=2, R=1. Path=3. MaxD=3. Depth=3.
Returns MaxD=3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Recursive DFS calculating depth and updating max diameter.
*DFS đệ quy tính toán độ sâu và cập nhật đường kính tối đa.*
---
*Độ lớn thực sự của một cái cây (Diameter) không chỉ là chiều cao vươn lên trời (Depth), mà là khả năng dang rộng vòng tay (Width) kết nối những cành xa nhất. Đôi khi, điểm kết nối quan trọng nhất không phải là ngọn cây, mà là một nút thắt (Node) khiêm tốn ở giữa thân.*
The true size of a tree (Diameter) is not just the height reaching to the sky (Depth), but the ability to spread the arms (Width) connecting the farthest branches. Sometimes, the most important connection point is not the top of the tree, but a humble node (Node) in the middle of the trunk.
