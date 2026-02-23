# Result for Shortest Path to Get All Keys
# *Kết quả cho bài toán Đường đi Ngắn nhất để Lấy Tất cả các Chìa khóa*

## Description
## *Mô tả*

You are given an `m x n` grid `grid` where:
*Bạn được cho một lưới `grid` kích thước `m x n`, trong đó:*

- `'.'` is an empty cell.
- `'#'` is a wall.
- `'@'` is the starting point.
- Lowercase letters represent keys.
- Uppercase letters represent locks.

You start at the starting point and one move consists of walking one space in one of the four cardinal directions. You cannot walk outside the grid, or into a wall.
*Bạn bắt đầu tại điểm xuất phát và một bước đi bao gồm việc đi bộ một ô theo một trong bốn hướng chính. Bạn không thể ra ngoài lưới, hoặc đi vào tường.*

If you walk over a key, you can pick up the key. You cannot walk over a lock unless you have its corresponding key.
*Nếu bạn đi qua một chìa khóa, bạn có thể nhặt được nó. Bạn không thể đi qua ổ khóa trừ khi bạn có chìa khóa tương ứng.*

For some `1 <= k <= 6`, there is exactly one lowercase and one uppercase letter of the first `k` letters of the English alphabet in the grid. This means that if `k = 3`, the grid contains `'a'`, `'b'`, `'c'`, `'A'`, `'B'`, and `'C'`.
*Đối với một giá trị `k` nào đó ($1 \le k \le 6$), có đúng một chữ cái viết thường và một chữ cái viết hoa trong số `k` chữ cái đầu tiên của bảng chữ cái tiếng Anh trong lưới. Điều này có nghĩa là nếu `k = 3`, lưới sẽ chứa 'a', 'b', 'c', 'A', 'B', và 'C'.*

Return *the lowest number of moves to acquire all keys*. If it is impossible, return `-1`.
*Trả về *số bước di chuyển thấp nhất để thu thập tất cả các chìa khóa*. Nếu không thể, hãy trả về `-1`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** grid = ["@.a..","###.#","b.A.B"]
**Output:** 8
**Explanation:** The shortest path is (0,0) -> (0,1) -> (0,2) --[a]--> (0,1) -> (0,0) -> (1,0) -> (2,0) --[b]--> (2,1) -> (2,2).
Note that we couldn't go to (2,2) directly because we didn't have key 'a' to unlock 'A'.

## Example 2:
## *Ví dụ 2:*

**Input:** grid = ["@..aA","..B#.","....b"]
**Output:** 6

## Example 3:
## *Ví dụ 3:*

**Input:** grid = ["@Aa"]
**Output:** -1

---

## Constraints:
## *Ràng buộc:*

*   `m == grid.length`
*   `n == grid[i].length`
*   `1 <= m, n <= 30`
*   `grid[i][j]` is either a letter, `'.'`, `'#'`, or `'@'`.
*   The number of keys in the grid is in the range `[1, 6]`.
*   Each key in the grid is unique.
*   Each key in the grid has a matching lock.
