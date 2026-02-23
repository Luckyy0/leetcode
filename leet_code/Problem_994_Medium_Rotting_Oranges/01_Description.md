# Result for Rotting Oranges
# *Kết quả cho bài toán Cam hỏng*

## Description
## *Mô tả*

You are given an `m x n` `grid` where each cell can have one of three values:
*Bạn được cho một lưới `m x n` `grid` trong đó mỗi ô có thể có một trong ba giá trị:*

*   `0` representing an empty cell,
    *   *`0` đại diện cho một ô trống,*
*   `1` representing a fresh orange, or
    *   *`1` đại diện cho một quả cam tươi, hoặc*
*   `2` representing a rotten orange.
    *   *`2` đại diện cho một quả cam hỏng.*

Every minute, any fresh orange that is **4-directionally adjacent** to a rotten orange becomes rotten.
*Mỗi phút, bất kỳ quả cam tươi nào **kề 4 hướng** với một quả cam hỏng sẽ bị hỏng.*

Return *the minimum number of minutes that must elapse until no cell has a fresh orange*. If *this is impossible, return* `-1`.
*Trả về *số phút tối thiểu phải trôi qua cho đến khi không còn ô nào có cam tươi*. Nếu *điều này là không thể, trả về* `-1`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** grid = [[2,1,1],[1,1,0],[0,1,1]]
**Output:** 4

## Example 2:
## *Ví dụ 2:*

**Input:** grid = [[2,1,1],[0,1,1],[1,0,1]]
**Output:** -1
**Explanation:** The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

## Example 3:
## *Ví dụ 3:*

**Input:** grid = [[0,2]]
**Output:** 0
**Explanation:** Since there are already no fresh oranges at minute 0, the answer is just 0.

---

## Constraints:
## *Ràng buộc:*

*   `m == grid.length`
*   `n == grid[i].length`
*   `1 <= m, n <= 10`
*   `grid[i][j]` is `0`, `1`, or `2`.
