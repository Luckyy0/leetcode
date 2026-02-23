# Analysis for Convert Sorted Array to Binary Search Tree
# *Phân tích cho bài toán Chuyển Đổi Mảng Đã Sắp Xếp Thành Cây Tìm Kiếm Nhị Phân*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** A strictly increasing sorted internal array `nums`. *Một mảng số nguyên `nums` được sắp xếp tăng dần nghiêm ngặt.*
*   **Output:** The root of a height-balanced Binary Search Tree (BST). *Gốc của một cây tìm kiếm nhị phân (BST) cân bằng về chiều cao.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   **Sorted Order:** The input is already sorted. This is the key property of BST's inorder traversal. *Thứ tự đã sắp xếp: Đầu vào đã được sắp xếp. Đây là đặc điểm chính của phép duyệt theo thứ tự giữa (inorder) của BST.*
*   **Height-Balanced:** To keep the tree balanced, we must pick the middle element as the root of each subtree. *Cân bằng chiều cao: Để giữ cho cây cân bằng, chúng ta phải chọn phần tử ở giữa làm gốc của mỗi cây con.*
*   **Complexity:** $10^4$ nodes means we need an $O(N)$ solution. *Độ phức tạp: $10^4$ nút nghĩa là chúng ta cần một giải pháp $O(N)$.*

---

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Recursive Divide and Conquer (Similar to Binary Search)
### *Hướng tiếp cận: Chia để trị Đệ quy (Tương tự Tìm kiếm nhị phân)*

*   **Logic:**
    1.  The inorder traversal of a BST yields a sorted array.
    2.  To create a **height-balanced** BST, the middle element of the array (or current segment) must be the root.
    3.  All elements to the left of the middle element will form the **left subtree**.
    4.  All elements to the right of the middle element will form the **right subtree**.
    5.  Repeat this process recursively for both halves.

*   **Algorithm Steps:**
    1.  Define a helper function `build(left, right)`.
    2.  **Base Case:** If `left > right`, return `null`.
    3.  Find the middle index: `mid = left + (right - left) / 2`.
    4.  Create a new `TreeNode` with value `nums[mid]`.
    5.  Set `node.left = build(left, mid - 1)`.
    6.  Set `node.right = build(mid + 1, right)`.
    7.  Return the `node`.

*   **Complexity:**
    *   **Time Complexity:** $O(N)$. Each element is processed exactly once to create a node. *Độ phức tạp thời gian: $O(N)$. Mỗi phần tử được xử lý đúng một lần để tạo một nút.*
    *   **Space Complexity:** $O(\log N)$. This is the space used by the recursion stack. Since the tree is balanced, its height is $\log N$. *Độ phức tạp không gian: $O(\log N)$. Đây là không gian được sử dụng bởi ngăn xếp đệ quy. Vì cây cân bằng, chiều cao của nó là $\log N$.*

---

## 3. Dry Run
## *3. Chạy thử*

**Input:** `nums = [-10, -3, 0, 5, 9]`

1.  `build(0, 4)`: `mid = 2`, value `0`. Root = `0`.
    -   `build(0, 1)`: `mid = 0`, value `-10`. `0.left = -10`.
        -   `build(0, -1)`: `null`.
        -   `build(1, 1)`: `mid = 1`, value `-3`. `-10.right = -3`.
    -   `build(3, 4)`: `mid = 3`, value `5`. `0.right = 5`.
        -   `build(3, 2)`: `null`.
        -   `build(4, 4)`: `mid = 4`, value `9`. `5.right = 9`.

**Tree Structure:**
```
      0
     / \
  -10   5
    \    \
    -3    9
```
*(Balanced BST!)*

---

## 4. Key Takeaway
## *4. Điểm mấu chốt*
*   **Middle Element Root:** Picking the median as the root ensures that the number of nodes in the left and right subtrees differs by at most 1, satisfying the height-balance requirement. *Chọn trung vị làm gốc đảm bảo rằng số lượng nút trong các cây con bên trái và bên phải chênh lệch tối đa 1, thỏa mãn yêu cầu cân bằng chiều cao.*
