# 10. Regular Expression Matching / Khớp Biểu Thức Chính Quy

## Problem Description / Mô tả bài toán
Given an input string `s` and a pattern `p`, implement regular expression matching with support for `'.'` and `'*'`.
Cho chuỗi đầu vào `s` và mẫu `p`, thực hiện khớp biểu thức chính quy với hỗ trợ cho `'.'` và `'*'`.

- `'.'` Matches any single character.
- `'.'` Khớp với bất kỳ ký tự đơn nào.
- `'*'` Matches zero or more of the preceding element.
- `'*'` Khớp với không hoặc nhiều phần tử đứng trước nó.

The matching should cover the **entire** input string (not partial).
Việc khớp phải bao gồm **toàn bộ** chuỗi đầu vào (không phải một phần).

### Example 1:
```text
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
```

### Example 2:
```text
Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
```

### Example 3:
```text
Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
```

## Constraints / Ràng buộc
- `1 <= s.length <= 20`
- `1 <= p.length <= 20`
- `s` contains only lowercase English letters.
- `p` contains only lowercase English letters, `'.'`, and `'*'`.

---

## Analysis / Phân tích

### Approach 1: Recursion / Đệ quy
- **Idea**: Check character by character.
- **Ý tưởng**: Kiểm tra từng ký tự.
    - If `p` is empty, `s` must be empty.
    - First match: `!s.isEmpty() && (s[0] == p[0] || p[0] == '.')`.
    - If `p` has at least 2 chars and `p[1] == '*'`:
        - Option 1 (Ignore `*`): `isMatch(s, p.substring(2))` (matches zero occurrences).
        - Option 2 (Use `*`): `first_match && isMatch(s.substring(1), p)` (matches one or more, consuming `s[0]`).
    - Else:
        - `first_match && isMatch(s.substring(1), p.substring(1))`.
- **Time Complexity**: Exponential in worst case.
- **Space Complexity**: Recursion stack depth.

### Approach 2: Dynamic Programming (Top-Down Memoization) / Quy hoạch động (Ghi nhớ từ trên xuống)
- **Idea**: Use a memo table `memo[i][j]` to store result of `isMatch(s[i:], p[j:])`.
- **Ý tưởng**: Dùng bảng ghi nhớ `memo[i][j]` để lưu kết quả của `isMatch(s[i:], p[j:])`.
- **Time Complexity**: O(T * P) where T, P are lengths of s and p.
- **Space Complexity**: O(T * P).

### Approach 3: Dynamic Programming (Bottom-Up) / Quy hoạch động (Từ dưới lên)
- **Idea**: `dp[i][j]` is true if `s[0...i-1]` matches `p[0...j-1]`.
- **Ý tưởng**: `dp[i][j]` đúng nếu `s[0...i-1]` khớp với `p[0...j-1]`.
    - `dp[0][0] = true` (empty matches empty).
    - Handle patterns like `a*`, `a*b*`, `.*`: `dp[0][j] = dp[0][j-2]` if `p[j-1] == '*'`.
    - Loop `i` from 1 to n, `j` from 1 to m:
        - If `p[j-1] == s[i-1]` or `p[j-1] == '.'`:
            - `dp[i][j] = dp[i-1][j-1]`.
        - If `p[j-1] == '*'`:
            - Let `prevChar = p[j-2]`.
            - Match zero times: `dp[i][j] = dp[i][j-2]`.
            - Match one/more times: `if (s[i-1] == prevChar || prevChar == '.')`, then `dp[i][j] |= dp[i-1][j]`.
- **Time Complexity**: O(T * P).
- **Space Complexity**: O(T * P).

---

## Edge Cases / Các trường hợp biên
1.  Empty String vs Pattern: "" matches "", "" matches "a*", "a" not match "".
2.  `.*` matches everything.
3.  `c*` matches empty string.
