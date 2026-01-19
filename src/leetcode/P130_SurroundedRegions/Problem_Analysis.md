# 130. Surrounded Regions / Các Vùng Bị Bao Vây

## Problem Description / Mô tả bài toán
Given an `m x n` matrix `board` containing `'X'` and `'O'`, capture all regions that are **4-directionally surrounded** by `'X'`.
Cho một ma trận `m x n` `board` chứa các ký tự `'X'` và `'O'`, hãy bao vây tất cả các vùng bị **bao quanh 4 hướng** bởi `'X'`.

A region is **captured** by flipping all `'O'`s into `'X'`s in that surrounded region.
Một vùng được coi là **bị bắt** bằng cách chuyển tất cả các chữ `'O'` thành `'X'` trong vùng bị bao quanh đó.

### Example 1:
```text
Input: board = [
  ["X","X","X","X"],
  ["X","O","O","X"],
  ["X","X","O","X"],
  ["X","O","X","X"]
]
Output: [
  ["X","X","X","X"],
  ["X","X","X","X"],
  ["X","X","X","X"],
  ["X","O","X","X"]
]
Explanation: Surrounded regions should not be on the border, which means any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is connected to an 'O' on the border will not be flipped to 'X'. Any other 'O' (and all 'O's connected to them) that are not connected to an 'O' on the border must be flipped to 'X'.
```

### Example 2:
```text
Input: board = [["X"]]
Output: [["X"]]
```

## Constraints / Ràng buộc
- `m == board.length`
- `n == board[i].length`
- `1 <= m, n <= 200`
- `board[i][j]` is `'X'` or `'O'`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Connectivity and Boundaries / Tính kết nối và Biên
The key trick to this problem is understanding which `'O'`s should **NOT** be flipped:
Điểm mấu chốt của bài toán này là hiểu được những chữ `'O'` nào **KHÔNG** nên bị lật:
- Any `'O'` situated on the board's boundary is safe.
- Any `'O'` connected (4-directionally) to a safe `'O'` is also safe.
- All other `'O'`s are surrounded and must be flipped to `'X'`.

### Boundary DFS/BFS Strategy / Chiến lược Duyệt Biên
Instead of checking every `'O'` to see if it's surrounded, we start from the **boundaries**:
Thay vì kiểm tra từng chữ `'O'` xem nó có bị bao quanh hay không, chúng ta bắt đầu từ các **biên**:
1.  Identify all `'O'`s on the four edges.
2.  Use DFS or BFS to mark all `'O'`s connected to the boundary `'O'`s with a special temporary marker (e.g., `'#'`).
3.  Traverse the entire board:
    - If an element is `'O'`, flip it to `'X'` (because it wasn't connected to a boundary).
    - If an element is `'#'`, flip it back to `'O'` (it's safe).

---

## Analysis / Phân tích

### Approach: Boundary Fill DFS / DFS Điền Biên

**Complexity / Độ phức tạp**:
- **Time**: O(M × N) - each cell visited a constant number of times.
- **Space**: O(M × N) in the worst case for recursion stack (e.g., all `'O'`).

---

## Edge Cases / Các trường hợp biên
1.  **Board size < 3x3**: No internal nodes can be surrounded.
2.  **No 'O' on board**: Nothing to flip.
3.  **All 'O' on board**: Nothing to flip (all connected to edges).
4.  **All 'X' on board**: Nothing to flip.
