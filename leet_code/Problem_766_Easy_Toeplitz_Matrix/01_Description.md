# Result for Toeplitz Matrix
# *Kết quả cho bài toán Ma trận Toeplitz*

## Description
## *Mô tả*

Given an `m x n` matrix, return *`true` if the matrix is Toeplitz. Otherwise, return `false`*.
*Cho một ma trận `m x n`, hãy trả về *`true` nếu ma trận là Toeplitz. Ngược lại, trả về `false`*.*

A matrix is **Toeplitz** if every diagonal from top-left to bottom-right has the same elements.
*Một ma trận được gọi là **Toeplitz** nếu mọi đường chéo từ góc trên bên trái xuống góc dưới bên phải đều có các phần tử giống nhau.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
**Output:** true
**Explanation:**
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.

## Example 2:
## *Ví dụ 2:*

**Input:** matrix = [[1,2],[2,2]]
**Output:** false
**Explanation:**
The diagonal "[1, 2]" has different elements.

---

## Constraints:
## *Ràng buộc:*

*   `m == matrix.length`
*   `n == matrix[i].length`
*   `1 <= m, n <= 20`
*   `0 <= matrix[i][j] <= 99`

**Follow up:**
*   What if the matrix is stored on disk, and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
*   What if the matrix is so large that you can only load up a partial row into the memory at once?
