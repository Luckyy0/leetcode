# Analysis for Maximum Depth of Binary Tree
# *Phân tích cho bài toán Chiều Sâu Tối Đa của Cây Nhị Phân*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Root of a binary tree. *Gốc của một cây nhị phân.*
*   **Output:** Integer (max depth). *Số nguyên (chiều sâu tối đa).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Tree may be empty (depth 0).
*   Number of nodes up to $10^4$.
*   *Cây có thể trống (chiều sâu 0).*
*   *Số lượng nút lên tới $10^4$.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Recursive DFS (Top Down or Bottom Up)
### *Hướng tiếp cận: DFS Đệ quy (Từ dưới lên hoặc Từ trên xuống)*

*   **Logic (Bottom Up):**
    1.  The maximum depth of a tree is `1 + maximum(depth of left subtree, depth of right subtree)`.
    2.  Base case: If node is null, return 0.

*   **Complexity:**
    *   Time: $O(n)$ to visit each node once.
    *   Space: $O(h)$ for recursion stack.

### Dry Run
### *Chạy thử*
`[3, 9, 20, 15, 7]`
1. `depth(3)` = `1 + max(depth(9), depth(20))`.
2. `depth(9)` = `1 + max(0, 0) = 1`.
3. `depth(20)` = `1 + max(depth(15), depth(7))`.
4. `depth(15)` = 1, `depth(7)` = 1.
5. `depth(20)` = `1 + 1 = 2`.
6. `depth(3)` = `1 + 2 = 3`.
Result: 3.
---
*Đệ quy là giải pháp tự nhiên và ngắn gọn nhất cho bài toán này.*
Recursion is the most natural and concise solution for this problem.
