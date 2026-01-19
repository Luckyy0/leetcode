# 22. Generate Parentheses / Tạo Dấu Ngoặc

## Problem Description / Mô tả bài toán
Given `n` pair of parentheses, write a function to generate all combinations of well-formed parentheses.
Cho `n` cặp dấu ngoặc, hãy viết một hàm để tạo ra tất cả các tổ hợp dấu ngoặc hợp lệ.

### Example 1:
```text
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
```

### Example 2:
```text
Input: n = 1
Output: ["()"]
```

## Constraints / Ràng buộc
- `1 <= n <= 8`

---

## Analysis / Phân tích

### Approach: Backtracking / Quay Lui
- **Idea**: We build the string character by character.
- **Ý tưởng**: Chúng ta xây dựng chuỗi từng ký tự một.
- **Rules**:
    1.  We can add an opening bracket `(` if `open < n`.
    2.  We can add a closing bracket `)` if `closed < open`.
    3.  Valid sequence ends when length is `2*n` (or `open == n` and `closed == n`).
- **Time Complexity**: O(4^n / sqrt(n)) - Nth Catalan Number.
- **Space Complexity**: O(n) for recursion stack.

---

## Edge Cases / Các trường hợp biên
1.  `n = 1`: `()`
