# Result for Swim in Rising Water
# *Kết quả cho bài toán Bơi trong Nước Dâng*

## Description
## *Mô tả*

You are given an `n x n` integer matrix `grid` where each value `grid[i][j]` represents the elevation at that point `(i, j)`.
*Bạn được cho một ma trận số nguyên `n x n` `grid` trong đó mỗi giá trị `grid[i][j]` đại diện cho độ cao tại điểm đó `(i, j)`.*

The rain starts to fall. At time `t`, the depth of the water everywhere is `t`. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most `t`. You can swim infinite distances in zero time.
*Mưa bắt đầu rơi. Tại thời điểm `t`, độ sâu của nước ở mọi nơi là `t`. Bạn có thể bơi từ một ô sang một ô liền kề theo 4 hướng khi và chỉ khi độ cao của cả hai ô đều tối đa là `t`. Bạn có thể bơi khoảng cách vô tận trong thời gian không đáng kể.*

You must start at the square `(0, 0)` and reach the square `(n - 1, n - 1)`.
*Bạn phải bắt đầu tại ô `(0, 0)` và đến ô `(n - 1, n - 1)`.*

Return *the least time `t` such that you can reach the square `(n - 1, n - 1)`*.
*Trả về *thời gian `t` nhỏ nhất sao cho bạn có thể đến được ô `(n - 1, n - 1)`*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** grid = [[0,2],[1,3]]
**Output:** 3
**Explanation:**
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.

## Example 2:
## *Ví dụ 2:*

**Input:** grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
**Output:** 16
**Explanation:** The final route is 0 -> 24 -> 12 -> 11 -> 10 -> 9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> 0
Wait, example explanation seems to imply path values.
Actually: 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 16 -> 15 -> 14 -> 13 -> 12 -> 24 -> 23 -> 22 -> 21 -> 5...
No, the path is finding min-max on path.
(0,0) is 0. (0,1) is 1...
The "bottleneck" is the maximum value encountered on the path.
If we go 0-1-2-3-4-5-16-15... max is 16.
So at t=16, all these cells are reachable.

---

## Constraints:
## *Ràng buộc:*

*   `n == grid.length`
*   `n == grid[i].length`
*   `1 <= n <= 50`
*   `0 <= grid[i][j] < n^2`
*   Each value `grid[i][j]` is **unique**.
