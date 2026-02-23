# Analysis for Recover Binary Search Tree
# *Phân tích cho bài toán Khôi Phục Cây Tìm Kiếm Nhị Phân*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Root of a BST with two swapped nodes. *Gốc của một BST có hai nút bị tráo đổi.*
*   **Output:** The same tree structure with values swapped back. *Cấu trúc cây tương tự với các giá trị được tráo đổi lại.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Exactly two nodes are swapped.
*   The tree must remain structure-identical.
*   Number of nodes up to 1000.
*   *Chính xác hai nút bị tráo đổi.*
*   *Cây phải giữ nguyên cấu trúc.*
*   *Số lượng nút lên tới 1000.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Inorder Traversal
### *Hướng tiếp cận: Duyệt Theo Thứ Tự Giữa*

*   **Logic:**
    1.  A standard BST's inorder traversal produces a sorted list of values.
    2.  If two values are swapped, there will be violations in the sorted order.
    3.  A violation occurs when `prev.val > current.val`.
    4.  If nodes `A` and `B` are swapped (with `A` appearing before `B` in normal order):
        *   First violation: `prev` is `A`, `current` is the element after it. We mark `first = prev`.
        *   Second violation: `prev` is the element before `B`, `current` is `B`. We mark `second = current`.
    5.  Note: If the swapped nodes are adjacent, there's only one violation; `first` is `prev` and `second` is `current`.

*   **Algorithm Steps:**
    1.  Perform a recursive inorder traversal.
    2.  Maintain a `prev` pointer.
    3.  During traversal:
        *   If `prev != null` and `prev.val > node.val`:
            *   If `first == null`, `first = prev`.
            *   `second = node`.
        *   Update `prev = node`.
    4.  After traversal, swap the values of `first` and `second`.

*   **Complexity:**
    *   Time: $O(n)$ to traverse all nodes.
    *   Space: $O(h)$ for recursion stack.

### Dry Run
### *Chạy thử*
`root = [3, 1, 4, null, null, 2]`
Inorder path: `1 -> 3 -> 2 -> 4`.
1. `prev = 1`, current = 3. `1 < 3` (OK).
2. `prev = 3`, current = 2. `3 > 2` (Violation!). `first = 3`, `second = 2`.
3. `prev = 2`, current = 4. `2 < 4` (OK).
Final: Swap values of 3 and 2.
Tree becomes: `[2, 1, 4, null, null, 3]`.
---
*Việc nhận diện hai nút bị tráo đổi dựa trên thứ tự duyệt giữa là cách tiếp cận hiệu quả nhất.*
Identifying the two swapped nodes based on the inorder traversal is the most effective approach.
