# 393. Reverse Substrings Between Each Pair of Parentheses / Đảo Chuỗi Giữa Mỗi Cặp Dấu Ngoặc

## Problem Description / Mô tả bài toán
Given a string `s` that contains lowercase English letters and parentheses `'('` and `')'`. Your task is to reverse the strings in each pair of matching parentheses, starting from the innermost pair, and return the resulting string without any parentheses.
Cho một chuỗi `s` chứa các ký tự chữ thường và dấu ngoặc `'('` và `')'`. Nhiệm vụ của bạn là đảo ngược các chuỗi trong mỗi cặp ngoặc khớp, bắt đầu từ cặp trong cùng, và trả về chuỗi kết quả không chứa dấu ngoặc.

### Example 1:
```text
Input: s = "(abcd)"
Output: "dcba"
```

### Example 2:
```text
Input: s = "u(love)i"
Output: "uevoli"
```

### Example 3:
```text
Input: s = "(ed(et(oc))el"
Output: "leetcode"
```

## Constraints / Ràng buộc
- `1 <= s.length <= 2000`
- `s` consists of lowercase English letters and parentheses `'('` and `')'`.
- The parentheses are guaranteed to be balanced.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Stack‑Based Reversal / Đảo Ngược Bằng Ngăn Xếp
We can process the string left‑to‑right using a stack of `StringBuilder` objects.
- When encountering `'('`, push a new empty `StringBuilder` onto the stack to start a new inner segment.
- When encountering a letter, append it to the `StringBuilder` on the top of the stack.
- When encountering `')'`, pop the top `StringBuilder`, reverse it, and append the reversed string to the `StringBuilder` now on the top of the stack (its parent segment).
- Initially the stack contains one `StringBuilder` representing the outermost segment.
The final content of the only remaining `StringBuilder` is the answer.

### Complexity / Độ phức tạp
- **Time**: Each character is processed a constant number of times → `O(N)`.
- **Space**: The stack holds at most the depth of nested parentheses, and the total length of all `StringBuilder`s is `O(N)`.

---

## Analysis / Phân tích

### Approach: Stack of StringBuilders

**Algorithm**:
1.  `Deque<StringBuilder> stack = new ArrayDeque<>();`
2.  `stack.push(new StringBuilder()); // outer level`
3.  Iterate over characters `c` in `s`:
    - If `c == '('`: `stack.push(new StringBuilder());`
    - Else if `c == ')'`:
        - `StringBuilder cur = stack.pop();`
        - `cur.reverse();`
        - `stack.peek().append(cur);`
    - Else: `stack.peek().append(c);`
4.  Return `stack.pop().toString();`

---
