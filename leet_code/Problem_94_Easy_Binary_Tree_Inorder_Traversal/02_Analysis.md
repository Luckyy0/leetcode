# Analysis for Binary Tree Inorder Traversal
# *Phân tích cho bài toán Duyệt Cây Nhị Phân Theo Thứ Tự Giữa*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Root of a binary tree. *Gốc của một cây nhị phân.*
*   **Output:** List of values in inorder. *Danh sách các giá trị theo thứ tự giữa.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Node count up to 100.
*   Inorder means: Visit Left subtree, then current node, then Right subtree.
*   *Số lượng nút lên tới 100.*
*   *Thứ tự giữa nghĩa là: Duyệt cây con bên Trái, sau đó đến nút hiện tại, sau đó đến cây con bên Phải.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Iterative with Stack
### *Hướng tiếp cận: Duyệt lặp với Ngăn xếp*

*   **Logic:**
    1.  Use a `Stack<TreeNode>` to simulate recursion.
    2.  Use a `curr` pointer starting at `root`.
    3.  While `curr` is not null or stack is not empty:
        *   Inner loop: while `curr` is not null, push `curr` to stack and move `curr = curr.left`. (Go to the leftmost node).
        *   Pop the top node from stack.
        *   Add its value to result.
        *   Move `curr` to its right child: `curr = stack.pop().right`.

*   **Complexity:**
    *   Time: $O(n)$ where $n$ is number of nodes.
    *   Space: $O(h)$ where $h$ is height of tree (space for stack).

### Dry Run
### *Chạy thử*
Tree: `[1, null, 2, 3]`
1. `curr = 1`. Push 1, `curr = null`.
2. Stack: `[1]`. Pop 1. Result: `[1]`. `curr = 1.right = 2`.
3. `curr = 2`. Push 2. `curr = 2.left = 3`.
4. `curr = 3`. Push 3. `curr = 3.left = null`.
5. Stack: `[2, 3]`. Pop 3. Result: `[1, 3]`. `curr = 3.right = null`.
6. Stack: `[2]`. Pop 2. Result: `[1, 3, 2]`. `curr = 2.right = null`.
7. Stack empty, `curr` null. Done.
---
*Việc sử dụng ngăn xếp giúp chúng ta kiểm soát quá trình duyệt mà không cần đệ quy.*
Using a stack allows us to control the traversal process without recursion.
