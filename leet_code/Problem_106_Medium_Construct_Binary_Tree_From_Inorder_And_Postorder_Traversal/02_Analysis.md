# Analysis for Construct Binary Tree from Inorder and Postorder Traversal
# *Phân tích cho bài toán Xây Dựng Cây Nhị Phân Từ Thứ Tự Giữa và Thứ Tự Sau*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Two arrays `inorder` and `postorder`. *Hai mảng `inorder` và `postorder`.*
*   **Output:** The reconstructed binary tree's root. *Nút gốc của cây nhị phân đã được tái cấu trúc.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Values are unique.
*   Inorder: Left -> Root -> Right.
*   Postorder: Left -> Right -> Root.
*   Length up to 3000.
*   *Các giá trị là duy nhất.*
*   *Thứ tự giữa: Trái -> Gốc -> Phải.*
*   *Thứ tự sau: Trái -> Phải -> Gốc.*
*   *Độ dài lên đến 3000.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Recursive Construction with HashMap
### *Hướng tiếp cận: Xây dựng Đệ quy với HashMap*

*   **Logic:**
    1.  The last element of `postorder` is always the `root`.
    2.  Locate this `root` in the `inorder` array. Elements to its left form the left subtree, and elements to its right form the right subtree.
    3.  Similar to Problem 105, use a `HashMap` to store value-to-index mappings for the `inorder` array.
    4.  Recursively apply this logic:
        *   Process the **Right** subtree first, then the **Left** subtree, because we are consuming `postorder` from end to start (Root -> Right -> Left).
        *   `preorderIndex` (or in this case, a pointer starting from `postorder.length - 1`) moves backwards.

*   **Complexity:**
    *   Time: $O(n)$ where $n$ is total nodes.
    *   Space: $O(n)$ for HashMap and recursion stack.

### Dry Run
### *Chạy thử*
`inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]`
1. Root = 3 (last element of postorder). Index in `inorder` is 1.
2. Build Right Subtree based on `inorder = [15, 20, 7]`.
   - Next root candidate in postorder: 20. Index in `inorder` is 3.
   - Right of 20: `inorder = [7]`.
   - Left of 20: `inorder = [15]`.
3. Build Left Subtree based on `inorder = [9]`.
   - Next root candidate: 9.
Result: `[3, 9, 20, null, null, 15, 7]`.
---
*Khác với thứ tự trước (Preorder), với thứ tự sau (Postorder), chúng ta cần xây dựng cây con bên Phải trước cây con bên Trái khi duyệt mảng từ cuối lên đầu.*
Unlike Preorder, with Postorder, we need to build the Right subtree before the Left subtree when traversing the array from end to start.
