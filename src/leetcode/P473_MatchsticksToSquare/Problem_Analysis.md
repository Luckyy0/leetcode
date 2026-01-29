# 473. Matchsticks to Square / Xếp Que Diêm Thành Hình Vuông

## Problem Description / Mô tả bài toán
You are given an integer array `matchsticks` where `matchsticks[i]` is the length of the `i-th` matchstick. You want to use **all** the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used **exactly once**.
Bạn được cho một mảng số nguyên `matchsticks` trong đó `matchsticks[i]` là độ dài của que diêm thứ `i`. Bạn muốn sử dụng **tất cả** các que diêm để tạo thành một hình vuông. Bạn không được bẻ gãy bất kỳ que nào, nhưng có thể nối chúng lại và mỗi que diêm phải được sử dụng **đúng một lần**.

Return `true` if you can make this square and `false` otherwise.
Trả về `true` nếu bạn có thể tạo thành hình vuông này, ngược lại trả về `false`.

### Example 1:
```text
Input: matchsticks = [1,1,2,2,2]
Output: true
Explanation: You can form a square with side length 2, one side is [1,1], other three sides are [2], [2], [2].
```

### Example 2:
```text
Input: matchsticks = [3,3,3,3,4]
Output: false
Explanation: You cannot find a way to form a square with all the matchsticks.
```

## Constraints / Ràng buộc
- `1 <= matchsticks.length <= 15`
- `1 <= matchsticks[i] <= 10^8`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking (DFS) / Quay lui (DFS)
This is a variation of the "Partition Problem" (specifically, partitioning into 4 equal subsets). Since the number of matchsticks is small (up to 15), we can use DFS.

Algorithm:
1. Corner cases:
   - If sum of all sticks is not divisible by 4, return `false`.
   - If there is any stick longer than `sum / 4`, return `false`.
2. Sort the matchsticks in **descending order**. (Sorting descending helps with pruning: larger sticks fail faster).
3. Use a recursive function `dfs(index, sides[])`:
   - `index` is the current matchstick we are trying to place.
   - `sides[]` is an array of size 4 storing the current length of each side of the square.
   - For the current matchstick `matchsticks[index]`:
     - Try adding it to each of the 4 sides.
     - If the side's current length + `matchsticks[index]` <= `target`:
       - Add it, recurse to `dfs(index + 1)`.
       - **Backtrack**.
     - **Optimization**: If this side's length before adding was 0, and it still couldn't form a square, don't try the other empty sides (as they are identical).
4. Return true if `index == matchsticks.length`.

### Complexity / Độ phức tạp
- **Time**: O(4^N) where N is number of sticks. (Pruning makes it much faster).
- **Space**: O(N) for recursion.

---

## Analysis / Phân tích

### Approach: Recursive 4-Way Partitioning

**Algorithm**:
1.  Check sum divisibility.
2.  DFS with side-length tracking.
3.  Heavy pruning: descending sort and skipping redundant empty sides.

---
