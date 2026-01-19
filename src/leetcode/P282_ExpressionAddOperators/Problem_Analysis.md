# 282. Expression Add Operators / Thêm Toán Tử Vào Biểu Thức

## Problem Description / Mô tả bài toán
Given a string `num` that contains only digits and an integer `target`, return all possibilities to insert the binary operators `+`, `-`, and/or `*` between the digits of `num` so that the resultant expression evaluates to the `target` value.
Cho một chuỗi `num` chỉ chứa các chữ số và một số nguyên `target`, hãy trả về tất cả các khả năng chèn các toán tử nhị phân `+`, `-` và/hoặc `*` giữa các chữ số của `num` sao cho biểu thức kết quả có giá trị bằng `target`.

Note that operands in the returned expressions should not contain leading zeros.
Lưu ý rằng các toán hạng trong các biểu thức trả về không được chứa các số 0 ở đầu.

### Example 1:
```text
Input: num = "123", target = 6
Output: ["1*2*3","1+2+3"]
```

### Example 2:
```text
Input: num = "232", target = 8
Output: ["2*3+2","2+3*2"]
```

### Example 3:
```text
Input: num = "3456237490", target = 9191
Output: []
```

## Constraints / Ràng buộc
- `1 <= num.length <= 10`
- `num` consists of only digits.
- `-2^31 <= target <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Backtracking with Evaluation / Quay Lui với Đánh Giá
We iterate through the string, splitting it into operands.
`123` -> `1` op `23`, `12` op `3`, `123`.
For each split, we recursively try adding `+`, `-`, `*`.
The tricky part is `*` (multiplication precedence).
- If we do `2 + 3 * 4`, when processing `4`, the previous operation was `+3`. We must undo `+3`, then do `3 * 4`, then add back.
- Formula: `current - multiplied + multiplied * operand`.

**Algorithm**:
1.  `dfs(index, prev_operand, current_val, expression)`.
2.  Loop `i` from `index` to `length`.
3.  Parse substring `num[index...i]` to `long val`.
    - Check leading zeros: If `num[index] == '0'` and `i > index`, break loop.
4.  If `index == 0`:
    - `dfs(i + 1, val, val, string(val))` (First number, no operator).
5.  Else:
    - **Add**: `dfs(i + 1, val, current_val + val, expr + "+" + val)`.
    - **Sub**: `dfs(i + 1, -val, current_val - val, expr + "-" + val)`.
    - **Mul**: `dfs(i + 1, prev_operand * val, current_val - prev_operand + (prev_operand * val), expr + "*" + val)`.

### Complexity / Độ phức tạp
- **Time**: O(4^N). At each position 4 choices (no op, +, -, *).
- **Space**: O(N) recursion.

---

## Analysis / Phân tích

### Approach: DFS Backtracking

**Edge Cases**:
1.  **Overflow**: `target` fits in int but intermediate calcs might exceed. Use `long`.
2.  **Leading Zeros**: `105` -> `1*05` is invalid. `1*0+5` is valid. Loop check handles this.

---
