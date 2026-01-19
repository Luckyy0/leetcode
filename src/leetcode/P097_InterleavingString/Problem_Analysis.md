# 97. Interleaving String / Chuỗi Xen Kẽ

## Problem Description / Mô tả bài toán
Given strings `s1`, `s2`, and `s3`, find whether `s3` is formed by an **interleaving** of `s1` and `s2`.
Cho các chuỗi `s1`, `s2` và `s3`, hãy tìm xem `s3` có được hình thành bởi **sự xen kẽ** của `s1` và `s2` hay không.

An **interleaving** of two strings `s` and `t` is a configuration where `s` and `t` are divided into `n` and `m` substrings respectively, such that:
Một **sự xen kẽ** của hai chuỗi `s` và `t` là một cấu hình trong đó `s` và `t` được chia thành `n` và `m` chuỗi con tương ứng, sao cho:
- `s = s1 + s2 + ... + sn`
- `t = t1 + t2 + ... + tm`
- `|n - m| <= 1`
- The **interleaving** is `s1 + t1 + s2 + t2 + s3 + t3 + ...` or `t1 + s1 + t2 + s2 + t3 + s3 + ...`

**Note:** `a + b` is the concatenation of strings `a` and `b`.

### Example 1:
```text
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Explanation: One way to obtain s3 is:
Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
Since s3 can be obtained by interleaving s1 and s2, we return true.
```

### Example 2:
```text
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
```

### Example 3:
```text
Input: s1 = "", s2 = "", s3 = ""
Output: true
```

## Constraints / Ràng buộc
- `0 <= s1.length, s2.length <= 100`
- `0 <= s3.length <= 200`
- `s1`, `s2`, and `s3` consist of lowercase English letters.

---

## Analysis / Phân tích

### Approach: Dynamic Programming / Quy Hoạch Động
- **Idea**: Let `dp[i][j]` be `true` if `s3[0..i+j-1]` can be formed by interleaving `s1[0..i-1]` and `s2[0..j-1]`.
- **Ý tưởng**: Gọi `dp[i][j]` là `true` nếu `s3[0..i+j-1]` có thể được hình thành bằng cách xen kẽ `s1[0..i-1]` và `s2[0..j-1]`.
- **Transition**:
    - `dp[i][j] = true` if:
        - `dp[i-1][j] && s1[i-1] == s3[i+j-1]` (take char from s1), OR
        - `dp[i][j-1] && s2[j-1] == s3[i+j-1]` (take char from s2).
- **Base Cases**:
    - `dp[0][0] = true` (empty strings).
    - `dp[i][0]` = `s1[0..i-1] == s3[0..i-1]`.
    - `dp[0][j]` = `s2[0..j-1] == s3[0..j-1]`.
- **Pruning**: If `len(s1) + len(s2) != len(s3)`, return false.
- **Time Complexity**: O(m * n).
- **Space Complexity**: O(m * n) (can be optimized to O(n)).

---

## Edge Cases / Các trường hợp biên
1.  **Empty Strings**: All empty -> true.
2.  **Length Mismatch**: `len(s1) + len(s2) != len(s3)` -> false.
