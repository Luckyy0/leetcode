# 115. Distinct Subsequences / Số Dãy Con Riêng Biệt

## Problem Description / Mô tả bài toán
Given two strings `s` and `t`, return the number of distinct subsequences of `s` which equals `t`.
Cho hai chuỗi `s` và `t`, trả về số lượng dãy con riêng biệt của `s` bằng `t`.

A string's **subsequence** is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
**Dãy con** của một chuỗi là một chuỗi mới được hình thành từ chuỗi gốc bằng cách xóa một số (có thể không có) ký tự mà không làm xáo trộn vị trí tương đối của các ký tự còn lại.

### Example 1:
```text
Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation: There are 3 ways to generate "rabbit" from "rabbbit":
- rabb_bit (skip 3rd 'b')
- rab_bbit (skip 2nd 'b')  
- ra_bbbit (skip 1st 'b')
```

### Example 2:
```text
Input: s = "babgbag", t = "bag"
Output: 5
```

## Constraints / Ràng buộc
- `1 <= s.length, t.length <= 1000`
- `s` and `t` consist of English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Subsequence vs Substring / Dãy con vs Chuỗi con

| Concept | Definition | Example for "abc" |
|---------|------------|-------------------|
| Substring | Contiguous characters | "ab", "bc", "abc" |
| **Subsequence** | Non-contiguous allowed | "ac", "a", "abc", "" |

### Dynamic Programming Formulation / Xây dựng Quy hoạch Động

**State Definition / Định nghĩa Trạng thái**:
`dp[i][j]` = Number of distinct subsequences of `s[0..i-1]` that equal `t[0..j-1]`.

**Recurrence Relation / Công thức Truy hồi**:
For each position `(i, j)`:

1.  **If `s[i-1] != t[j-1]`**: 
    - Current character of `s` cannot match `t[j-1]`.
    - `dp[i][j] = dp[i-1][j]` (skip `s[i-1]`)

2.  **If `s[i-1] == t[j-1]`**: Two choices:
    - **Use** `s[i-1]` to match `t[j-1]`: `dp[i-1][j-1]`
    - **Skip** `s[i-1]` (maybe match later character): `dp[i-1][j]`
    - `dp[i][j] = dp[i-1][j-1] + dp[i-1][j]`

**Base Cases / Trường hợp Cơ sở**:
- `dp[i][0] = 1` for all `i`: Empty `t` can be formed by any prefix of `s` (by taking no characters).
- `dp[0][j] = 0` for `j > 0`: Non-empty `t` cannot be formed from empty `s`.

### Visual Example / Ví dụ Trực quan
```
s = "rabbbit", t = "rabbit"

      ""  r  a  b  b  i  t
  ""   1  0  0  0  0  0  0
  r    1  1  0  0  0  0  0
  a    1  1  1  0  0  0  0
  b    1  1  1  1  0  0  0
  b    1  1  1  2  1  0  0
  b    1  1  1  3  3  0  0
  i    1  1  1  3  3  3  0
  t    1  1  1  3  3  3  3
```

---

## Analysis / Phân tích

### Approach: 2D Dynamic Programming / Quy hoạch Động 2D

**Algorithm**:
```
for i = 0 to m:
    dp[i][0] = 1
for i = 1 to m:
    for j = 1 to n:
        if s[i-1] == t[j-1]:
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
        else:
            dp[i][j] = dp[i-1][j]
return dp[m][n]
```

### Space Optimization / Tối ưu Không gian
- Since `dp[i][j]` only depends on `dp[i-1][...]`, we can use 1D array.
- Update from right to left to avoid overwriting needed values.

### Complexity / Độ phức tạp
- **Time**: O(m × n)
- **Space**: O(m × n), or O(n) with optimization

---

## Edge Cases / Các trường hợp biên
1.  **`t` is empty**: Always 1 way (take nothing).
2.  **`s` is shorter than `t`**: 0 ways.
3.  **No match possible**: 0.
