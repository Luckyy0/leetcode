# 52. N-Queens II / Bài Toán N Quân Hậu II

## Problem Description / Mô tả bài toán
The **n-queens** puzzle is the problem of placing `n` queens on an `n x n` chessboard such that no two queens attack each other.
Bài toán **n quân hậu** là bài toán đặt `n` quân hậu lên bàn cờ `n x n` sao cho không có hai quân hậu nào tấn công nhau.

Given an integer `n`, return the number of distinct solutions to the **n-queens puzzle**.
Cho một số nguyên `n`, trả về số lượng giải pháp riêng biệt cho **bài toán n quân hậu**.

### Example 1:
```text
Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle.
```

### Example 2:
```text
Input: n = 1
Output: 1
```

## Constraints / Ràng buộc
- `1 <= n <= 9`

---

## Analysis / Phân tích

### Approach: Backtracking / Quay Lui
- **Idea**: Identical to N-Queens I, but instead of storing the board configurations, we just increment a counter.
- **Ý tưởng**: Giống hệt N-Queens I, nhưng thay vì lưu trữ cấu hình bảng, chúng ta chỉ cần tăng một biến đếm.
- **Constraints**:
    - **Column**: No two queens share a column. Track with boolean array `cols[n]`.
    - **Diagonals**: No two queens share a diagonal.
        - **Main Diagonal** (`\ `): `row - col` is constant. Indices: `row - col + n` (range 0 to 2n).
        - **Anti-Diagonal** (`/`): `row + col` is constant. Indices: `row + col` (range 0 to 2n).
- **Algorithm**:
    - `count`: Global or passed variable.
    - `backtrack(row)`:
        - If `row == n`, `count++`.
        - Loop `col` from 0 to n-1:
            - If valid:
                - Mark constraints.
                - `backtrack(row + 1)`.
                - Unmark constraints.
- **Time Complexity**: O(N!).
- **Space Complexity**: O(N).

---

## Edge Cases / Các trường hợp biên
1.  **n = 1**: 1.
2.  **n = 2, 3**: 0.
