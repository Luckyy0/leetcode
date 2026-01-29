# 521. Longest Uncommon Subsequence I / Dãy Con Không Chung Dài Nhất I

## Problem Description / Mô tả bài toán
Given two strings `a` and `b`, return the length of the **longest uncommon subsequence** between them. If no such subsequence exists, return `-1`.
Cho hai chuỗi `a` và `b`, hãy trả về độ dài của **dãy con không chung dài nhất** giữa chúng. Nếu không tồn tại dãy con như vậy, trả về `-1`.

An **uncommon subsequence** is a subsequence of one string that is not a subsequence of the other string.
Một **dãy con không chung** là một dãy con của một chuỗi mà không phải là dãy con của chuỗi kia.

### Example 1:
```text
Input: a = "aba", b = "cdc"
Output: 3
Explanation: "aba" is uncommon to "cdc", and "cdc" is uncommon to "aba".
```

### Example 2:
```text
Input: a = "aaa", b = "bbb"
Output: 3
```

### Example 3:
```text
Input: a = "aaa", b = "aaa"
Output: -1
```

## Constraints / Ràng buộc
- `1 <= a.length, b.length <= 100`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Logical Analysis / Phân tích logic
This is a brain teaser! If `a` and `b` are different, then the entire string `a` (or `b`) is an uncommon subsequence.
If `a` equals `b`, then any subsequence of `a` is also a subsequence of `b`, so no uncommon subsequence exists.

Algorithm:
- If `a.equals(b)`, return `-1`.
- Otherwise, return `Math.max(a.length(), b.length())`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---
