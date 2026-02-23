# Result for Making A Large Island
# *Kết quả cho bài toán Tạo một Hòn đảo Lớn*

## Description
## *Mô tả*

You are given an `n x n` binary matrix `grid`. You are allowed to change **at most one** `0` to be `1`.
*Cho một ma trận nhị phân `grid` kích thước `n x n`. Bạn được phép thay đổi **tối đa một** số `0` thành số `1`.*

Return *the size of the largest island in `grid` after applying this operation*.
*Trả về *kích thước của hòn đảo lớn nhất trong `grid` sau khi thực hiện thao tác này*.*

An **island** is a 4-directionally connected group of `1`s.
*Một **hòn đảo** là một nhóm các số `1` được kết nối theo 4 hướng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** grid = [[1,0],[0,1]]
**Output:** 3
**Explanation:** Change one 0 to 1 and connect two 1s, then we get an island with area = 3.

## Example 2:
## *Ví dụ 2:*

**Input:** grid = [[1,1],[1,0]]
**Output:** 4
**Explanation:** Change the 0 to 1 and make the island bigger, only one island with area = 4.

## Example 3:
## *Ví dụ 3:*

**Input:** grid = [[1,1],[1,1]]
**Output:** 4
**Explanation:** Can't change any 0 to 1, only one island with area = 4.

---

## Constraints:
## *Ràng buộc:*

*   `n == grid.length`
*   `n == grid[i].length`
*   `1 <= n <= 500`
*   `grid[i][j]` is either `0` or `1`.
