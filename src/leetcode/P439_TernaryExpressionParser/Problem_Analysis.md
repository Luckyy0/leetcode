# 439. Ternary Expression Parser / Trình Phân Tích Biểu Thức Tam Phân

## Problem Description / Mô tả bài toán
Given a string `expression` representing a nested ternary expression, calculate the result of the expression.
Cho một chuỗi `expression` đại diện cho một biểu thức tam phân lồng nhau, hãy tính toán kết quả của biểu thức đó.

The conditional expressions group from right to left (as usual in most languages), and the result of each conditional will be a single digit.
Các biểu thức điều kiện được nhóm từ phải sang trái (như thông thường trong hầu hết các ngôn ngữ), và kết quả của mỗi điều kiện sẽ là một chữ số duy nhất.

### Example 1:
```text
Input: expression = "T?2:3"
Output: "2"
```

### Example 2:
```text
Input: expression = "F?1:T?4:5"
Output: "4"
Explanation: The expression "T?4:5" is evaluated first. It results in "4". Then "F?1:4" is evaluated, which results in "4".
```

### Example 3:
```text
Input: expression = "T?T?F:5:3"
Output: "F"
```

## Constraints / Ràng buộc
- `5 <= expression.length <= 10^4`
- `expression` consists of digits, `'T'`, `'F'`, `'?'`, and `':'`.
- `expression` is guaranteed to be a valid ternary expression.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Stack Evaluation / Đánh giá dùng Ngăn xếp
Since nested ternary expressions group from right to left, we can process the string from **right to left** using a stack.

Algorithm:
1. Traverse the expression from the **end** to the **beginning**.
2. If the current character is a value (`T`, `F`, or a digit) and the character before it is not `?`:
   - Push it onto the stack.
3. If the current character is `?`:
   - Note the character before it (at index `i-1`). This is the boolean condition `C`.
   - Pop two values from the stack: the expression for `true` (`v1`) and the expression for `false` (`v2`).
   - If `C` is `T`, push `v1` back onto the stack.
   - If `C` is `F`, push `v2` back onto the stack.
   - Skip the character `C`.
4. Skip the character `:` whenever encountered during traversal.
5. The final element in the stack is the result.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of the expression.
- **Space**: O(N) for the stack.

---

## Analysis / Phân tích

### Approach: Right-to-Left Stack Processing

**Algorithm**:
1.  Iterate backwards.
2.  Push operands.
3.  On `?`, pop two alternatives and choose based on condition.

---
