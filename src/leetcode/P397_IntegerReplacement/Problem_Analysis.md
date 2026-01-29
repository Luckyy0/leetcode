# 397. Integer Replacement / Thay Thế Số Nguyên

## Problem Description / Mô tả bài toán
Given a positive integer `n`, you can apply one of the following operations:
Cho một số nguyên dương `n`, bạn có thể áp dụng một trong các phép toán sau:

1.  If `n` is even, replace `n` with `n / 2`.
    Nếu `n` chẵn, thay thế `n` bằng `n / 2`.
2.  If `n` is odd, replace `n` with either `n + 1` or `n - 1`.
    Nếu `n` lẻ, thay thế `n` bằng `n + 1` hoặc `n - 1`.

Return the minimum number of operations needed for `n` to become 1.
Trả về số lượng phép toán tối thiểu cần thiết để `n` trở thành 1.

### Example 1:
```text
Input: n = 8
Output: 3
Explanation: 8 -> 4 -> 2 -> 1
```

### Example 2:
```text
Input: n = 7
Output: 4
Explanation: 7 -> 8 -> 4 -> 2 -> 1 or 7 -> 6 -> 3 -> 2 -> 1
```

## Constraints / Ràng buộc
- `1 <= n <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Greedy Bit Manipulation / Thao tác Bit Tham lam
If `n` is even, we must use `n/2`. Operation count + 1.
If `n` is odd, we want to choose `n+1` or `n-1` to make the next step more "productive" (produce more trailing zeros).
- `n = 3`: `3 -> 2 -> 1` is better than `3 -> 4 -> 2 -> 1`.
- If `n` ends in `...01`: `n - 1` leaves `...00`.
- If `n` ends in `...11`: `n + 1` leaves `...00`. (Except for `n = 3`).

Wait, why `n = 3` is exception?
`3 = 011`. `3 + 1 = 4 (100)`. `3 - 1 = 2 (010)`.
Both lead to 1 in similar steps?
`3 -> 2 -> 1` (2 steps).
`3 -> 4 -> 2 -> 1` (3 steps).
So for `3`, `-1` is better.
For `7 (111)`: `7 -> 8 (1000) -> 4 -> 2 -> 1` (4 steps). `7 -> 6 (110) -> 3 -> 2 -> 1` (4 steps).
Actually `n+1` for `...11` is usually better because it might clear out many trailing 1s.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Greedy (Bit manipulation)

**Algorithm**:
1.  Use `long` to avoid overflow (specifically for `Integer.MAX_VALUE + 1`).
2.  Count steps.
3.  While `n > 1`:
    - Steps++.
    - If `n % 2 == 0`: `n /= 2`.
    - Else if `n == 3` or `(n & 2) == 0`: `n--`.
    - Else: `n++`.
4.  Return steps.

Explanation for `(n & 2) == 0`:
This checks the second bit.
If `n` is `...01`, `n & 2` is 0. Choose `n--`.
If `n` is `...11`, `n & 2` is 2. Choose `n++` (to get more zeros).

---
