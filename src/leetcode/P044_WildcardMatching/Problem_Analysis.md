# 44. Wildcard Matching / Khớp Ký Tự Đại Diện

## Problem Description / Mô tả bài toán
Given an input string (`s`) and a pattern (`p`), implement wildcard pattern matching with support for `'?'` and `'*'`.
Cho một chuỗi đầu vào (`s`) và một mẫu (`p`), hãy thực hiện khớp mẫu ký tự đại diện với hỗ trợ cho `'?'` và `'*'`.

- `'?'` Matches any single character.
  `'?'` Khớp với bất kỳ ký tự đơn nào.
- `'*'` Matches any sequence of characters (including the empty sequence).
  `'*'` Khớp với bất kỳ chuỗi ký tự nào (bao gồm cả chuỗi rỗng).

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
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
```

### Example 3:
```text
Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
```

## Constraints / Ràng buộc
- `0 <= s.length, p.length <= 2000`
- `s` contains only lowercase English letters.
- `p` contains only lowercase English letters, `'?'` or `'*'`.

---

## Analysis / Phân tích

### Approach 1: Dynamic Programming / Quy Hoạch Động
- **Idea**: Use a 2D boolean table `dp[i][j]` representing if `s[0...i-1]` matches `p[0...j-1]`.
- **Ý tưởng**: Sử dụng bảng boolean 2D `dp[i][j]` đại diện cho việc `s[0...i-1]` có khớp với `p[0...j-1]` hay không.
- **Transitions**:
    - If `p[j-1] == '?'` or `p[j-1] == s[i-1]`: `dp[i][j] = dp[i-1][j-1]`.
    - If `p[j-1] == '*'`:
        - Match empty sequence: `dp[i][j] = dp[i][j-1]`.
        - Match one or more characters: `dp[i][j] = dp[i-1][j]`.
        - Combined: `dp[i][j] = dp[i][j-1] || dp[i-1][j]`.
- **Time Complexity**: O(m * n).
- **Space Complexity**: O(m * n).

### Approach 2: Greedy with Backtracking (Optimal) / Tham Lam với Quay Lui
- **Idea**: We only care about the latest `*` we encountered. If we mismatch, we try to see if the `*` can absorb one more character from `s`.
- **Ý tưởng**: Ta chỉ quan tâm đến dấu `*` gần nhất mà ta gặp. Nếu không khớp, ta thử xem `*` có thể hấp thụ thêm một ký tự từ `s` hay không.
- **Time Complexity**: Average O(m + n), Worst O(m * n).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Empty Pattern**: Only empty string matches.
2.  **Empty String**: Pattern must be all `*` to match.
3.  **Multiple Stars**: `a****b`.
