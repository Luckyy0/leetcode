# 20. Valid Parentheses / Dấu Ngoặc Hợp Lệ

## Problem Description / Mô tả bài toán
Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.
Cho một chuỗi `s` chỉ chứa các ký tự `'('`, `')'`, `'{'`, `'}'`, `'['` và `']'`, xác định xem chuỗi đầu vào có hợp lệ hay không.

An input string is valid if:
Một chuỗi đầu vào hợp lệ nếu:
1.  Open brackets must be closed by the same type of brackets.
    Các dấu ngoặc mở phải được đóng bởi cùng một loại dấu ngoặc.
2.  Open brackets must be closed in the correct order.
    Các dấu ngoặc mở phải được đóng theo đúng thứ tự.
3. Every close bracket has a corresponding open bracket of the same type.
    Mỗi dấu ngoặc đóng đều có một dấu ngoặc mở tương ứng cùng loại.

### Example 1:
```text
Input: s = "()"
Output: true
```

### Example 2:
```text
Input: s = "()[]{}"
Output: true
```

### Example 3:
```text
Input: s = "(]"
Output: false
```

## Constraints / Ràng buộc
- `1 <= s.length <= 10^4`
- `s` consists of parentheses only `()[]{}`.

---

## Analysis / Phân tích

### Approach: Stack / Ngăn Xếp
- **Idea**: Use a stack to keep track of opening brackets.
- **Ý tưởng**: Sử dụng ngăn xếp để theo dõi các dấu ngoặc mở.
    - When we encounter an opening bracket (`(`, `{`, `[`), push it onto the stack.
    - When we encounter a closing bracket (`)`, `}`, `]`), check if the stack is empty. If so, return false.
    - Otherwise, pop from the stack and check if it matches the corresponding opening bracket.
    - Finally, return `true` if empty, `false` otherwise.
- **Time Complexity**: O(n). Traverse the string once.
- **Space Complexity**: O(n). Stack size can be up to n.

---

## Edge Cases / Các trường hợp biên
1.  **Empty String**: (Constraint says len >= 1).
2.  **Single Bracket**: `(` -> `false`.
3.  **Mismatched**: `(]` -> `false`.
4.  **Order Mismatch**: `([)]` -> `false`.
