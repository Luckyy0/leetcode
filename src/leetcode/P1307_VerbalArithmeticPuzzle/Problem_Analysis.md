# 1307. Verbal Arithmetic Puzzle / Câu đố Số học Bằng lời

## Problem Description / Mô tả bài toán
Array of strings `words` and String `result`.
Equation: `sum(word -> number) == result -> number`.
Mapping: Each char maps to digit 0-9. Unique.
No leading zeros (unless single digit 0, but problem says "no leading zeros").
Constraints: Max 10 chars. Words count small.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking with Pruning
Typical cryptarithmetic puzzle.
Variables: unique characters.
Values: 0-9.
Assign digits to chars.
Check equation.
Optimization:
- Assign column by column from right (least significant) to left.
- Check partial sum constraints.
- `sum(column) % 10 == result_col_digit`. Carry over.
- Prune early if impossible.

### Complexity / Độ phức tạp
- **Time**: Exponential (10!).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Recursive Backtracking (Column-wise)
To solve the summation `word1 + word2 + ... = result`, process column by column from right to left (least significant digit to most significant).
For each column index `col` (0 being rightmost):
- Sum the digits assigned to the characters at this column index across all words.
- Handle assignments: if a character is unassigned, try assigning an available digit (0-9).
- Check validity: `(sum + carry) % 10` must match the digit assigned to the character in `result` at this column.
- Update carry: `carry = (sum + carry) / 10`.
- Recurse to the next column.
- Constraints: Leading characters cannot be 0.
This structure prunes the search space significantly compared to trying all permutations first.
Để giải phương trình tổng `word1 + word2 + ... = result`, hãy xử lý từng cột từ phải sang trái (chữ số có nghĩa nhỏ nhất đến lớn nhất).
Đối với mỗi chỉ số cột `col` (0 là ngoài cùng bên phải):
- Cộng các chữ số được gán cho các ký tự tại chỉ số cột này trên tất cả các từ.
- Xử lý các phép gán: nếu một ký tự chưa được gán, hãy thử gán một chữ số khả dụng (0-9).
- Kiểm tra tính hợp lệ: `(sum + carry) % 10` phải khớp với chữ số được gán cho ký tự trong `result` tại cột này.
- Cập nhật số nhớ: `carry = (sum + carry) / 10`.
- Đệ quy sang cột tiếp theo.
- Ràng buộc: Các ký tự đầu tiên không thể là 0.
Cấu trúc này cắt tỉa không gian tìm kiếm đáng kể so với việc thử tất cả các hoán vị trước.

---
