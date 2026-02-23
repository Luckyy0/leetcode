# Analysis for Symmetric Tree
# *Phân tích cho bài toán Cây Đối Xứng*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Root of a binary tree. *Gốc của một cây nhị phân.*
*   **Output:** Boolean (is symmetric). *Boolean (có đối xứng không).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Symmetry is checked between left and right subtrees.
*   Mirror image means:
    *   Left child of Left subtree matches Right child of Right subtree.
    *   Right child of Left subtree matches Left child of Right subtree.
*   *Tính đối xứng được kiểm tra giữa cây con bên trái và bên phải.*
*   *Hình ảnh gương nghĩa là:*
    *   *Con bên trái của cây con Trái khớp với con bên phải của cây con Phải.*
    *   *Con bên phải của cây con Trái khớp với con bên trái của cây con Phải.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Recursive DFS
### *Hướng tiếp cận: DFS Đệ quy*

*   **Logic:**
    1.  A tree is symmetric if its left and right subtrees are mirror images of each other.
    2.  Define `isMirror(node1, node2)`:
        *   If both are null, return true.
        *   If one is null or values differ, return false.
        *   Return `isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left)`.

*   **Complexity:**
    *   Time: $O(n)$ where $n$ is total nodes.
    *   Space: $O(h)$ for recursion stack.

### Dry Run
### *Chạy thử*
`[1, 2, 2, 3, 4, 4, 3]`
1. Compare `left(2)` and `right(2)`. OK.
2. `isMirror(left.left(3), right.right(3))` AND `isMirror(left.right(4), right.left(4))`.
3. `3 == 3` and `4 == 4`. OK.
Result: `true`.
---
*Bài toán này mở rộng logic so sánh hai cây thành so sánh hai nhánh của cùng một cây theo kiểu gương.*
This problem extends the logic of comparing two trees to comparing two branches of the same tree in a mirror fashion.
