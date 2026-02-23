# Result for Range Addition II
# *Kết quả cho bài toán Cộng Phạm vi II*

## Description
## *Mô tả*

You are given an `m x n` matrix `M` initialized with all `0`'s and an array of operations `ops`, where `ops[i] = [ai, bi]` means `M[x][y]` should be incremented by one for all `0 <= x < ai` and `0 <= y < bi`.
*Bạn được cho một ma trận `m x n` `M` được khởi tạo với toàn bộ giá trị `0` và một mảng các thao tác `ops`, trong đó `ops[i] = [ai, bi]` nghĩa là `M[x][y]` nên được tăng thêm một cho tất cả `0 <= x < ai` và `0 <= y < bi`.*

Count and return the number of maximum integers in the matrix after performing all the operations.
*Hãy đếm và trả về số lượng các số nguyên lớn nhất trong ma trận sau khi thực hiện tất cả các thao tác.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** m = 3, n = 3, ops = [[2,2],[3,3]]
**Output:** 4
**Explanation:** The maximum integer is 2, and there are four of it in the submatrix M[0...1][0...1].

## Example 2:
## *Ví dụ 2:*

**Input:** m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
**Output:** 4

## Example 3:
## *Ví dụ 3:*

**Input:** m = 3, n = 3, ops = []
**Output:** 9

---

## Constraints:
## *Ràng buộc:*

*   `1 <= m, n <= 4 * 104`
*   `0 <= ops.length <= 104`
*   `ops[i].length == 2`
*   `1 <= ai <= m`
*   `1 <= bi <= n`
