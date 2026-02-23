# Analysis for Same Tree
# *Phân tích cho bài toán Cây Giống Nhau*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Roots of two binary trees `p` and `q`. *Gốc của hai cây nhị phân `p` và `q`.*
*   **Output:** Boolean (are they the same). *Boolean (chúng có giống nhau không).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Nodes count up to 100.
*   Must match structural shape and node values.
*   *Số lượng nút lên tới 100.*
*   *Phải khớp về hình dạng cấu trúc và giá trị của các nút.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Recursive DFS
### *Hướng tiếp cận: DFS Đệ quy*

*   **Logic:**
    1.  If both nodes are null, they are the same (True).
    2.  If only one node is null, or if values are different, they are not the same (False).
    3.  Recursively check left subtrees and right subtrees. Both must be the same.

*   **Algorithm Steps:**
    1.  `isSameTree(p, q)`:
        *   If `p == null && q == null` return `true`.
        *   If `p == null || q == null` return `false`.
        *   If `p.val != q.val` return `false`.
        *   Return `isSameTree(p.left, q.left) && isSameTree(p.right, q.right)`.

*   **Complexity:**
    *   Time: $O(n)$ where $n$ is the number of nodes in the smaller tree.
    *   Space: $O(h)$ where $h$ is the height of the tree (recursion stack).

### Dry Run
### *Chạy thử*
`p = [1, 2], q = [1, null, 2]`
1. Compare roots: `1 == 1`. OK.
2. Compare left branches: `p.left (2)` vs `q.left (null)`. Violation (True vs False).
Result: `false`.
---
*Đệ quy là giải pháp trực quan và ngắn gọn nhất cho bài toán so sánh cấu trúc cây.*
Recursion is the most intuitive and concise solution for the problem of comparing tree structures.
