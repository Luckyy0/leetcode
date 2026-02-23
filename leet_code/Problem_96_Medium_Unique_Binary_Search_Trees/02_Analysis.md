# Analysis for Unique Binary Search Trees
# *Phân tích cho bài toán Cây Tìm Kiếm Nhị Phân Duy Nhất*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Integer `n`. *Số nguyên `n`.*
*   **Output:** Number of unique BST structures. *Số lượng cấu trúc BST duy nhất.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `n` is between 1 and 19.
*   The number of unique BSTs for a given `n` is the `n`-th Catalan number.
*   *`n` nằm trong khoảng từ 1 đến 19.*
*   *Số lượng BST duy nhất cho một giá trị `n` cho trước là số Catalan thứ `n`.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Dynamic Programming
### *Hướng tiếp cận: Quy Hoạch Động*

*   **Logic:**
    1.  Let `G(n)` be the number of unique BSTs with `n` nodes.
    2.  Let `F(i, n)` be the number of unique BSTs where `i` is the root and total nodes is `n`.
    3.  `G(n) = Σ F(i, n)` for `i` from 1 to `n`.
    4.  When `i` is the root, there are `i-1` nodes in the left subtree and `n-i` nodes in the right subtree.
    5.  Therefore, `F(i, n) = G(i-1) * G(n-i)`.
    6.  Merging these: `G(n) = Σ (G(i-1) * G(n-i))` for `i` from 1 to `n`.

*   **Algorithm Steps:**
    1.  Initialize `dp` array of size `n + 1`.
    2.  Set `dp[0] = 1` and `dp[1] = 1`.
    3.  Iterate `i` from 2 up to `n`:
        *   Iterate `j` from 1 up to `i`:
            *   `dp[i] += dp[j-1] * dp[i-j]`.
    4.  Return `dp[n]`.

*   **Complexity:**
    *   Time: $O(n^2)$.
    *   Space: $O(n)$ for `dp` array.

### Dry Run
### *Chạy thử*
`n = 3`
1. `dp[0]=1, dp[1]=1`.
2. `i=2`:
   - `j=1`: `dp[0]*dp[1] = 1*1 = 1`.
   - `j=2`: `dp[1]*dp[0] = 1*1 = 1`.
   - `dp[2] = 2`.
3. `i=3`:
   - `j=1`: `dp[0]*dp[2] = 1*2 = 2`.
   - `j=2`: `dp[1]*dp[1] = 1*1 = 1`.
   - `j=3`: `dp[2]*dp[0] = 2*1 = 2`.
   - `dp[3] = 2 + 1 + 2 = 5`.
Result: 5.
---
*Công thức này là cách tính số Catalan cơ bản nhất.*
This formula is the most basic way to calculate Catalan numbers.
