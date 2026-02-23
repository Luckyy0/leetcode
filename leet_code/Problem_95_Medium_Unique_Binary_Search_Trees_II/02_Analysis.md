# Analysis for Unique Binary Search Trees II
# *Phân tích cho bài toán Cây Tìm Kiếm Nhị Phân Duy Nhất II*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Integer `n`. *Số nguyên `n`.*
*   **Output:** List of root nodes of all unique BSTs. *Danh sách các nút gốc của tất cả các cây BST duy nhất.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `n` is small (up to 8). This is because the number of trees grows quickly (Catalan number).
*   Unique Structural BSTs means the shape of the tree and the values assigned must be specific to BST properties.
*   *`n` nhỏ (lên tới 8). Điều này là do số lượng cây tăng lên rất nhanh (số Catalan).*
*   *BST có cấu trúc duy nhất nghĩa là hình dạng của cây và các giá trị được gán phải tuân theo các đặc điểm của BST.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Recursive (Divide and Conquer)
### *Hướng tiếp cận: Đệ quy (Chia để trị)*

*   **Logic:**
    1.  To build all unique BSTs using numbers from `start` to `end`:
    2.  If `start > end`, only a `null` tree can be formed.
    3.  Iterate each number `i` from `start` to `end` as the `root`:
        *   All unique left subtrees consist of numbers from `start` to `i - 1`.
        *   All unique right subtrees consist of numbers from `i + 1` to `end`.
        *   Combine each left subtree with each right subtree under the current root `i`.

*   **Complexity:**
    *   Time: Exponential (related to the $n$-th Catalan number $C_n = \frac{1}{n+1} \binom{2n}{n}$).
    *   Space: Exponential to store all trees.

### Dry Run
### *Chạy thử*
`n = 3`
1. Root = 1: Left = `null`, Right = `generate(2, 3)`.
   - `generate(2, 3)` with root 2: Left = `null`, Right = 3.
   - `generate(2, 3)` with root 3: Left = 2, Right = `null`.
2. Root = 2: Left = `generate(1, 1)` (which is 1), Right = `generate(3, 3)` (which is 3).
3. Root = 3: Left = `generate(1, 2)`, Right = `null`.
---
*Đệ quy chia để trị là cách tiếp cận tự nhiên nhất để liệt kê các cấu trúc phân cấp.*
Recursive divide and conquer is the most natural approach to enumerate hierarchical structures.
