# 1541. Minimum Insertions to Balance a Parentheses String / Số lượng Chèn Tối thiểu để Cân bằng Chuỗi Ngoặc

## Problem Description / Mô tả bài toán
String `s` of '(' and ')'.
Balanced if:
- Open '(' has correct corresponding '))' (two closing).
- Order correct.
- Example: "(()))" valid.
Min insertions needed.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy / Stack simulation
One '(' matches '))'.
Treat '))' as a single unit or handle ')' carefully.
Iterate through string.
Track `right_needed` count (expecting '))' for each '(').
If '(':
  If `right_needed` is odd: we expected '))' but got '('. Means previous '(' only got ')'.
    We need to insert one ')' to complete the previous pair. `res++`.
    `right_needed--` (completed).
  `right_needed += 2`.
If ')':
  `right_needed--`.
  If `right_needed < 0`:
    We have extra ')'.
    Need a '('. `res++`.
    `right_needed += 2` (The inserted '(' needs 2 ')', one is current ')', so need 1 more).
After loop:
`res += right_needed`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Tracking Needs
Count `right_needed`.
Iterate char `c`.
Example: "(()))" -> `(`: need 2. `(`: need 2+2=4. `)`: need 3. `)`: need 2. `)`: need 1. End. Res += 1. Total 1.
Insert ')' at end. (()))) -> (()))). Correct.
Example: "())" -> `(`: need 2. `)`: need 1. `)`: need 0. Max 0. Correct.
Example: "))" -> `)`: need -1. Insert '('. need 1. `)`: need 0. Total 1. (())) -> valid. Wait. "))" -> "())" -> "(()))" (inserted ( and )).
My logic: `right_needed < 0` -> res++, `right_needed` becomes 1. (Inserted '(' satisfied one ')', still needs another ')' for the inserted '(').
Correct.
Special case: `(` then `(`. If `right_needed` odd (e.g. 1), it means we had `(` followed by `)`. The next char is `(`. We must fix the previous pair to `())` by inserting `)`.
Correct.

---
