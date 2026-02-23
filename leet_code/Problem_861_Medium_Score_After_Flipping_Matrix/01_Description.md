# Result for Score After Flipping Matrix
# *Kết quả cho bài toán Điểm sau khi Lật Ma trận*

## Description
## *Mô tả*

You are given an `m x n` binary matrix `grid`.
*Bạn được cho một ma trận nhị phân `grid` kích thước `m x n`.*

A **move** consists of choosing any row or column and flipping each value in that row or column (i.e., changing all `0`'s to `1`'s, and all `1`'s to `0`'s).
*Một **bước đi** bao gồm việc chọn bất kỳ hàng hoặc cột nào và lật từng giá trị trong hàng hoặc cột đó (nghĩa là thay đổi tất cả các số `0` thành `1` và tất cả các số `1` thành `0`).*

Every row of the matrix is interpreted as a binary number, and the **score** of the matrix is the sum of these numbers.
*Mỗi hàng của ma trận được diễn giải như một số nhị phân và **điểm** của ma trận là tổng của các số này.*

Return *the highest possible score after making any number of moves (including zero moves)*.
*Trả về *điểm cao nhất có thể có sau khi thực hiện bất kỳ số lượng bước đi nào (bao gồm cả không thực hiện bước đi nào)*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
**Output:** 39
**Explanation:** 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39.

## Example 2:
## *Ví dụ 2:*

**Input:** grid = [[0]]
**Output:** 1

---

## Constraints:
## *Ràng buộc:*

*   `m == grid.length`
*   `n == grid[i].length`
*   `1 <= m, n <= 20`
*   `grid[i][j]` is either `0` or `1`.
