# 32. Longest Valid Parentheses / Chuỗi Ngoặc Hợp Lệ Dài Nhất

## Problem Description / Mô tả bài toán
Given a string containing just the characters `'('` and `')'`, return the length of the longest valid (well-formed) parentheses substring.
Cho một chuỗi chỉ chứa các ký tự `'('` và `')'`, trả về độ dài của chuỗi con ngoặc hợp lệ (được định dạng đúng) dài nhất.

### Example 1:
```text
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
```

### Example 2:
```text
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
```

### Example 3:
```text
Input: s = ""
Output: 0
```

## Constraints / Ràng buộc
- `0 <= s.length <= 3 * 10^4`
- `s[i]` is `'('`, or `')'`.

---

## Analysis / Phân tích

### Approach 1: Dynamic Programming / Quy Hoạch Động
- **Idea**: Let `dp[i]` be the length of the longest valid substring ending at `i`.
- **Ý tưởng**: Gọi `dp[i]` là độ dài của chuỗi con hợp lệ dài nhất kết thúc tại `i`.
- **Transitions**:
    - If `s[i] == ')'`:
        - Case 1: `s[i-1] == '('` -> `dp[i] = dp[i-2] + 2`.
        - Case 2: `s[i-1] == ')'` and `s[i - dp[i-1] - 1] == '('` -> `dp[i] = dp[i-1] + dp[i - dp[i-1] - 2] + 2`.
- **Time Complexity**: O(n).
- **Space Complexity**: O(n).

### Approach 2: Stack / Ngăn Xếp
- **Idea**: Use a stack to store indices. Push `-1` initially to simplify calculation.
- **Ý tưởng**: Sử dụng ngăn xếp để lưu các chỉ số. Đẩy `-1` vào ban đầu để đơn giản hóa việc tính toán.
    - If `(`, push index.
    - If `)`, pop.
        - If stack empty, push current index (new base).
        - Else, `maxLen = max(maxLen, i - stack.peek())`.
- **Time Complexity**: O(n).
- **Space Complexity**: O(n).

### Approach 3: Two Pointers / Hai Con Trỏ
- **Idea**: Scan twice.
- **Ý tưởng**: Quét hai lần.
    1.  Left to Right: Count `left` and `right`. If `left == right`, `maxLen = max(maxLen, 2 * right)`. If `right > left`, reset counters.
    2.  Right to Left: Similar logic, reset if `left > right`.
- **Time Complexity**: O(n).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Empty String**: 0.
2.  **No Valid Pairs**: `(((` or `)))` -> 0.
3.  **Full String Valid**: `()()` -> 4.
