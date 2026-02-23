# Analysis for Validate Binary Search Tree
# *Phân tích cho bài toán Xác Minh Cây Tìm Kiếm Nhị Phân*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Root of a binary tree. *Gốc của một cây nhị phân.*
*   **Output:** Boolean (is valid BST or not). *Boolean (có phải là BST hợp lệ hay không).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Values can be `Integer.MIN_VALUE` or `Integer.MAX_VALUE`. Need `Long` or `null` pointers for bounds.
*   Number of nodes up to $10^4$.
*   *Các giá trị có thể là `Integer.MIN_VALUE` hoặc `Integer.MAX_VALUE`. Cần sử dụng kiểu `Long` hoặc con trỏ `null` cho các ranh giới.*
*   *Số lượng nút lên tới $10^4$.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Recursive Bounds Check
### *Hướng tiếp cận: Kiểm tra Ranh giới Đệ quy*

*   **Logic:**
    1.  A node is valid if its value is strictly between a `min` and `max` bound.
    2.  For the root, `min = -infinity`, `max = +infinity`.
    3.  When moving to the left child, the `max` bound becomes the current node's value.
    4.  When moving to the right child, the `min` bound becomes the current node's value.
    5.  Base case: An empty node (null) is a valid BST.

*   **Algorithm Steps:**
    1.  Create a helper function `isValid(node, lower, upper)`.
    2.  If `node == null`, return `true`.
    3.  If `node.val <= lower` or `node.val >= upper`, return `false`.
    4.  Recursively check: `isValid(node.left, lower, node.val) && isValid(node.right, node.val, upper)`.

*   **Complexity:**
    *   Time: $O(n)$ where $n$ is the number of nodes.
    *   Space: $O(h)$ where $h$ is the height of the tree (recursion stack).

### Dry Run
### *Chạy thử*
`[2, 1, 3]`
1. Root 2: Bound `(-inf, +inf)`. `true`.
2. Left child 1: Bound `(-inf, 2)`. `true`.
3. Right child 3: Bound `(2, +inf)`. `true`.
Result: `true`.
---
*Sử dụng kiểu dữ liệu Long là cách an toàn nhất để tránh lỗi khi giá trị của nút là giá trị nguyên tối thiểu hoặc tối đa.*
Using the Long data type is the safest way to avoid errors when a node's value is the minimum or maximum integer value.
