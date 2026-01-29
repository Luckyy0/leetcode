# 351. Android Unlock Patterns / Các Mẫu Mở Khóa Android

## Problem Description / Mô tả bài toán
Android devices have a pattern lock screen. There are `9` dots (points) on a `3 x 3` grid:
Thiết bị Android có màn hình khóa dạng mẫu. Có `9` điểm trên lưới `3 x 3`:

```
1 2 3
4 5 6
7 8 9
```

Each pattern must connect at least `m` dots and at most `n` dots.
Mỗi mẫu phải kết nối ít nhất `m` điểm và nhiều nhất `n` điểm.

The rules for a valid pattern are:
1.  All the dots in the pattern must be distinct.
2.  If the line connecting two consecutive dots in the pattern passes through any other dot, the other dot must have **already appeared** in the pattern. No jumps through non-selected dots allowed.
    - Example: Connecting 1 and 3 requires 2 to be visited.
    - Connecting 1 and 9 requires 5 to be visited.
    - Connecting 1 and 6 is fine (knight move / slope not hitting integers exactly on dot).
    - Connecting 2 and 9 is fine.

Given `m` and `n`, return the number of valid patterns.
Cho `m` và `n`, trả về số lượng mẫu hợp lệ.

### Example 1:
```text
Input: m = 1, n = 1
Output: 9
Explanation: 1, 2, 3, 4, 5, 6, 7, 8, 9.
```

### Example 2:
```text
Input: m = 1, n = 2
Output: 65
```

## Constraints / Ràng buộc
- `1 <= m, n <= 9`

---

## Theoretical Foundation / Cơ sở lý thuyết

### DFS + Backtracking / DFS + Quay Lui
We need to count paths of length `m` to `n`.
Total nodes is 9. Small enough for standard DFS.
State: `visited` bitmask or boolean array. `current_node`, `length`.

Constraint Logic (Skipping nodes):
We can precompute a "Skip" table `skip[from][to]` which stores the middle node required to jump from `from` to `to`.
- `skip[1][3] = 2`
- `skip[1][7] = 4`
- `skip[1][9] = 5`
- `skip[2][8] = 5`
- `skip[3][1] = 2` ... and so on for symmetric pairs.
- Adjacent nodes (e.g. 1->2, 1->6) have `skip` value 0.

Transition Check:
Can move `from` -> `to` if:
- `!visited[to]` AND
- (`skip[from][to] == 0` OR `visited[skip[from][to]]`).

Optimization:
- Symmetry: Patterns starting at 1, 3, 7, 9 are symmetric. `count(1) * 4`.
- Patterns starting at 2, 4, 6, 8 are symmetric. `count(2) * 4`.
- Patterns starting at 5. `count(5)`.

### Complexity / Độ phức tạp
- **Time**: Total paths is bounded by 9! (362,880). Feasible.
- **Space**: O(1) recursion depth.

---

## Analysis / Phân tích

### Approach: Backtracking

**Algorithm**:
1.  `skip` array 10x10. Fill required jumps (1-3: 2, 1-7: 4, 1-9: 5, 2-8: 5, 3-7: 5, 3-9: 6, 4-6: 5, 7-9: 8). Symmetric.
2.  `dfs(curr, remaining_depth)`.
3.  Loop 1 to 9. Check validity.
4.  Total = `4*dfs(1) + 4*dfs(2) + dfs(5)`. Note loop depth logic.

---
