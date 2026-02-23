# Analysis for Binary Tree Zigzag Level Order Traversal
# *Phân tích cho bài toán Duyệt Cây Nhị Phân Theo Hình Zigzag*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Root of a binary tree. *Gốc của một cây nhị phân.*
*   **Output:** List of lists containing node values in zigzag order. *Danh sách các danh sách chứa giá trị các nút theo thứ tự zigzag.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Similar to level order traversal, but the direction of adding values to the list alternates.
*   Nodes count up to 2000.
*   *Tương tự như duyệt theo tầng, nhưng hướng thêm giá trị vào danh sách được luân phiên.*
*   *Số lượng nút lên đến 2000.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Breadth-First Search (BFS) with Direction Flag
### *Hướng tiếp cận: Tìm kiếm theo chiều rộng (BFS) với Cờ Hướng*

*   **Logic:**
    1.  Use a `Queue` for standard level order traversal.
    2.  Maintain a boolean flag `leftToRight` to track the current direction.
    3.  For each level:
        *   Determine `size = queue.size()`.
        *   Use a `LinkedList` or `Deque` as a temporary list for the current level.
        *   If `leftToRight` is true, add values to the end.
        *   If `leftToRight` is false, add values to the beginning.
        *   Toggle the `leftToRight` flag after processing each level.

*   **Complexity:**
    *   Time: $O(n)$ where $n$ is total nodes.
    *   Space: $O(w)$ where $w$ is the maximum width of the tree.

### Dry Run
### *Chạy thử*
`[3, 9, 20, 15, 7]`
1. Level 0: Queue `[3]`. `leftToRight = true`.
   - Poll 3. Add to end: `[3]`.
   - Result: `[[3]]`. `leftToRight = false`.
2. Level 1: Queue `[9, 20]`. `leftToRight = false`.
   - Poll 9. Add to beginning: `[9]`.
   - Poll 20. Add to beginning: `[20, 9]`.
   - Result: `[[3], [20, 9]]`. `leftToRight = true`.
3. Level 2: Queue `[15, 7]`. `leftToRight = true`.
   - Poll 15. Add to end: `[15]`.
   - Poll 7. Add to end: `[15, 7]`.
   - Result: `[[3], [20, 9], [15, 7]]`.
---
*Zigzag là một biến thể nhỏ của BFS, chỉ cần thay đổi cách chèn vào danh sách kết quả của mỗi tầng.*
Zigzag is a small variation of BFS, only requiring a change in how values are inserted into each level's result list.
