# Analysis for Binary Tree Level Order Traversal
# *Phân tích cho bài toán Duyệt Cây Nhị Phân Theo Tầng*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Root of a binary tree. *Gốc của một cây nhị phân.*
*   **Output:** List of lists containing node values at each level. *Danh sách các danh sách chứa giá trị các nút tại mỗi tầng.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Tree may be empty.
*   Nodes count up to 2000.
*   Level by level, left to right.
*   *Cây có thể trống.*
*   *Số lượng nút lên đến 2000.*
*   *Từng tầng một, từ trái sang phải.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Breadth-First Search (BFS) using Queue
### *Hướng tiếp cận: Tìm kiếm theo chiều rộng (BFS) sử dụng Hàng đợi*

*   **Logic:**
    1.  Use a `Queue` to keep track of nodes in the current level.
    2.  Start with `root` in the queue.
    3.  While the queue is not empty:
        *   Determine the number of nodes at the current level (`size = queue.size()`).
        *   Process all nodes in the current level:
            *   Poll node from queue.
            *   Add its value to the current level's list.
            *   Add its children (left then right) to the queue for the next level.
        *   Add current level's list to the final result.

*   **Complexity:**
    *   Time: $O(n)$ where $n$ is total nodes.
    *   Space: $O(w)$ where $w$ is the maximum width of the tree (max nodes in a level).

### Dry Run
### *Chạy thử*
`[3, 9, 20, 15, 7]`
1. Queue: `[3]`. Size = 1.
   - Poll 3. Level = `[3]`. Children 9, 20 added.
   - Result: `[[3]]`.
2. Queue: `[9, 20]`. Size = 2.
   - Poll 9. Level = `[9]`. (No children).
   - Poll 20. Level = `[9, 20]`. Children 15, 7 added.
   - Result: `[[3], [9, 20]]`.
3. Queue: `[15, 7]`. Size = 2.
   - Poll 15. Level = `[15]`.
   - Poll 7. Level = `[15, 7]`.
   - Result: `[[3], [9, 20], [15, 7]]`.
---
*BFS là phương pháp chuẩn để truy cập các nút theo từng tầng.*
BFS is the standard method for visiting nodes level by level.
