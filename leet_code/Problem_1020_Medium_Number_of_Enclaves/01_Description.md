# Result for Number of Enclaves
# *Kết quả cho bài toán Số lượng Vùng đất kín (Enclaves)*

## Description
## *Mô tả*

You are given an `m x n` binary matrix `grid`, where `0` represents a sea cell and `1` represents a land cell.
*Bạn được cung cấp một ma trận nhị phân `grid` có kích thước `m x n`, trong đó `0` đại diện cho ô biển và `1` đại diện cho ô đất liền.*

A **move** consists of walking from one land cell to another adjacent (**4-directionally**) land cell or walking off the boundary of the `grid`.
*Một **bước di chuyển** bao gồm việc đi từ một ô đất sang một ô đất liền kề (**theo 4 hướng**) khác, hoặc đi bộ vượt ra khỏi ranh giới của `grid`.*

Return *the number of land cells in `grid` for which we cannot walk off the boundary of the grid in any number of moves*.
*Trả về số lượng các ô đất trong `grid` mà chúng ta không thể nào đi bộ lọt ra khỏi ranh giới của lưới điểm dù có đi bao nhiêu bước chăng nữa.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
**Output:** 3
**Explanation:** There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
*Giải thích: Nhìn hình phẳng, cụm gồm 3 số 1 nằm co cụm tại trung tâm bị bao quanh tứ phía bởi số 0. Hoàn toàn cách ly (có 3 ô). Chỉ duy nhất 1 số 1 tại viền biên giới thoát được.*

## Example 2:
## *Ví dụ 2:*

**Input:** grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
**Output:** 0
**Explanation:** All 1s are either on the boundary or can reach the boundary.
*Giải thích: Đám đất dính chặt vào mép bản đồ trên cùng, tẩu thoát dễ dàng. Số ô bị giam giữ là 0.*

---

## Constraints:
## *Ràng buộc:*

*   `m == grid.length`
*   `n == grid[i].length`
*   `1 <= m, n <= 500`
*   `grid[i][j]` is either `0` or `1`.
