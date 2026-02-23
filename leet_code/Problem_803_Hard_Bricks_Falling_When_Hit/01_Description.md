# Result for Bricks Falling When Hit
# *Kết quả cho bài toán Gạch rơi khi bị va chạm*

## Description
## *Mô tả*

You are given an `m x n` binary `grid`, where each `1` represents a brick and `0` represents an empty space. A brick is **stable** if:
*   It is directly connected to the top of the grid.
*   At least one of its four adjacent neighbors is stable.

You are also given an array `hits`, where `hits[i] = [r_i, c_i]` is the location of the `i`-th erasure. You should erase the brick at the location `[r_i, c_i]` (if it exists) and determine the number of bricks that **fall** as a result of the erasure.
*Cho một lưới nhị phân `grid`, trong đó `1` là gạch và `0` là trống. Một viên gạch là **ổn định** nếu nó nối trực tiếp với đỉnh lưới hoặc có lân cận ổn định. Mảng `hits` là vị trí các lần đập gạch.*

Return *an array `result`, where `result[i]` is the number of bricks that fall after the `i`-th erasure*.
*Trả về số gạch bị rơi sau mỗi lần đập.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** grid = [[1,0,0,0],[1,1,1,0]], hits = [[1,0]]
**Output:** [2]
**Explanation:** 
- Initially: [[1,0,0,0], [1,1,1,0]]
- Hit (1,0): The brick at (1,0) is removed. 
- The bricks at (1,1) and (1,2) are no longer stable and fall. Result: 2.

## Example 2:
## *Ví dụ 2:*

**Input:** grid = [[1,0,0,0],[1,1,0,0]], hits = [[1,1],[1,0]]
**Output:** [0,0]

---

## Constraints:
## *Ràng buộc:*

*   `m == grid.length`, `n == grid[i].length`
*   `1 <= m, n <= 200`
*   `1 <= hits.length <= 4 * 10^4`
*   `hits[i].length == 2`
*   `0 <= r_i < m`, `0 <= c_i < n`
*   All `hits[i]` are unique.
