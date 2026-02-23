# Analysis for Construct Binary Tree from Preorder and Inorder Traversal
# *Phân tích cho bài toán Xây Dựng Cây Nhị Phân Từ Thứ Tự Trước và Thứ Tự Giữa*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Two arrays `preorder` and `inorder`. *Hai mảng `preorder` và `inorder`.*
*   **Output:** The reconstructed binary tree's root. *Nút gốc của cây nhị phân đã được tái cấu trúc.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Values are unique.
*   Preorder: Root -> Left -> Right.
*   Inorder: Left -> Root -> Right.
*   Length up to 3000.
*   *Các giá trị là duy nhất.*
*   *Thứ tự trước: Gốc -> Trái -> Phải.*
*   *Thứ tự giữa: Trái -> Gốc -> Phải.*
*   *Độ dài lên đến 3000.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Recursive Construction with HashMap
### *Hướng tiếp cận: Xây dựng Đệ quy với HashMap*

*   **Logic:**
    1.  The first element of `preorder` is always the `root`.
    2.  Locate this `root` in the `inorder` array. Elements to its left form the left subtree, and elements to its right form the right subtree.
    3.  To speed up locating the root in `inorder`, use a `HashMap` to store value-to-index mappings.
    4.  Recursively apply this logic:
        *   Pass segments of `preorder` and `inorder` to the recursive function.
        *   `leftSubtreeSize = rootIndexInInorder - inorderStart`.
        *   Left subtree: `preorder` range `[preStart + 1, preStart + leftSubtreeSize]`, `inorder` range `[inStart, rootIndexInInorder - 1]`.
        *   Right subtree: `preorder` range `[preStart + leftSubtreeSize + 1, preEnd]`, `inorder` range `[rootIndexInInorder + 1, inEnd]`.

*   **Complexity:**
    *   Time: $O(n)$ where $n$ is total nodes (due to HashMap).
    *   Space: $O(n)$ for HashMap and recursion stack.

### Dry Run
### *Chạy thử*
`preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]`
1. `root = 3`. Index in `inorder` is 1.
2. Left subtree: `inorder = [9]`, `preorder = [9]`.
3. Right subtree: `inorder = [15, 20, 7]`, `preorder = [20, 15, 7]`.
   - Sub-root = 20. Index in `inorder` is 3.
   - Sub-left: `inorder = [15]`, `preorder = [15]`.
   - Sub-right: `inorder = [7]`, `preorder = [7]`.
Result: `[3, 9, 20, null, null, 15, 7]`.
---
*Việc xác định kích thước cây con thông qua chỉ số trong mảng Inorder là mấu chốt để phân tách mảng Preorder.*
Determining the subtree size through the index in the Inorder array is the key to splitting the Preorder array.
