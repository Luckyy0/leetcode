# Analysis for Largest BST Subtree
# *Phân tích cho bài toán Cây con BST Lớn nhất*

## 1. Problem Essence & Bottom-Up Verification
## *1. Bản chất vấn đề & Xác minh Từ dưới lên*

### The Naive 
### *Cách ngây thơ*
For each node, check if `isBST(node)`. If yes, count size.
`isBST` takes $O(N)$. Total $O(N^2)$. Too slow.

### Strategy: Bottom-Up Post-Order
### *Chiến lược: Post-Order Từ dưới lên*
We want to verify BST property at a node based on its children.
A node is a BST root if:
1.  Left child is a BST root.
2.  Right child is a BST root.
3.  `Left.Max < Node.Val < Right.Min`.
We need to pass up `{isBST, size, min, max}`.

### Logic Flow
### *Luồng Logic*
`Data postOrder(node)`:
- Base case (null): `isBST=true, size=0, min=Infinity, max=-Infinity`.
- `left = postOrder(node.left)`.
- `right = postOrder(node.right)`.
- If `left.isBST` AND `right.isBST` AND `left.max < node.val < right.min`:
    - `isBST = true`
    - `size = left.size + 1 + right.size`
    - `min = (node.left == null) ? node.val : left.min`
    - `max = (node.right == null) ? node.val : right.max`
    - Update global `maxSize`.
    - Return `Data`.
- Else:
    - Return `isBST=false, size=0`.

---

## 2. Approach: Post-Order DFS
## *2. Hướng tiếp cận: DFS Post-Order*

### Logic
### *Logic*
(See above). The `Data` class encapsulates return values.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Time:** We visit every node once and do constant work (comparisons).
    *Thời gian O(N): Chúng ta thăm mỗi nút một lần và thực hiện công việc hằng số (so sánh).*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(H)$ recursion stack.
    *Độ phức tạp không gian: $O(H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Tree:** 10 -> L:5, R:15. 5 -> L:1, R:8. 15 -> R:7.
Leaves:
1: BST, size 1, min 1, max 1.
8: BST, size 1, min 8, max 8.
5: Left(1) max 1 < 5. Right(8) min 8 > 5. Valid.
   BST, size 3, min 1, max 8. Update Global=3.
7: BST, size 1, min 7, max 7.
15: Left null (Valid). Right(7) min 7.
   Is 15 < 7? No. Invalid.
   Return NotBST.
10: Right(15) NotBST.
   Return NotBST.
Result 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Bottom-up DFS is the most efficient way ($O(N)$).
*DFS từ dưới lên là cách hiệu quả nhất ($O(N)$).*
---
*Đôi khi để biết mình có đứng vững (valid BST) hay không, ta cần dựa vào sự ổn định của nền tảng bên dưới (children). Nếu bên dưới vững chắc, ta mới có thể vươn lên và mở rộng (largest subtree).*
Sometimes to know if we are standing firm (valid BST), we need to rely on the stability of the foundation below (children). Only if the bottom is solid can we rise and expand (largest subtree).
