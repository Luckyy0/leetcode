# 51. N-Queens / Bài Toán N Quân Hậu

## Problem Description / Mô tả bài toán
The **n-queens** puzzle is the problem of placing `n` queens on an `n x n` chessboard such that no two queens attack each other.
Bài toán **n quân hậu** là bài toán đặt `n` quân hậu lên bàn cờ `n x n` sao cho không có hai quân hậu nào tấn công nhau.

Given an integer `n`, return all distinct solutions to the **n-queens puzzle**. You may return the answer in **any order**.
Cho một số nguyên `n`, trả về tất cả các giải pháp riêng biệt cho **bài toán n quân hậu**. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.

Each solution contains a distinct board configuration of the n-queens' placement, where `'Q'` and `'.'` both indicate a queen and an empty space, respectively.
Mỗi giải pháp chứa một cấu hình bảng riêng biệt của việc đặt n quân hậu, trong đó `'Q'` và `'.'` lần lượt biểu thị một quân hậu và một khoảng trống.

### Example 1:
```text
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
```

### Example 2:
```text
Input: n = 1
Output: [["Q"]]
```

## Constraints / Ràng buộc
- `1 <= n <= 9`

---

## Analysis / Phân tích

### Approach: Backtracking / Quay Lui
- **Idea**: We place queens row as row, from 0 to n-1.
- **Ý tưởng**: Chúng ta đặt các quân hậu theo hàng, từ 0 đến n-1.
- **Constraints**:
    - **Column**: No two queens share a column. Track with boolean array `cols[n]`.
    - **Diagonals**: No two queens share a diagonal.
        - **Main Diagonal** (`\ `): `row - col` is constant. Indices: `row - col + n` (range 0 to 2n).
        - **Anti-Diagonal** (`/`): `row + col` is constant. Indices: `row + col` (range 0 to 2n).
- **Algorithm**:
    - `backtrack(row)`:
        - If `row == n`, construct board and add to result.
        - Loop `col` from 0 to n-1:
            - If valid (not in `cols`, `diag1`, `diag2`):
                - Place queen. Mark constraints.
                - `backtrack(row + 1)`.
                - Remove queen. Unmark constraints (Backtrack).
- **Time Complexity**: O(N!).
- **Space Complexity**: O(N).

---

## Edge Cases / Các trường hợp biên
1.  **n = 1**: `[["Q"]]`.
2.  **n = 2, 3**: No solution -> `[]`.
