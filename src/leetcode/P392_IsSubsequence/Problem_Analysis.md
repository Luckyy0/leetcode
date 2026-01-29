# 392. Is Subsequence / Là Chuỗi Con

## Problem Description / Mô tả bài toán
Given two strings `s` and `t`, return `true` if `s` is a **subsequence** of `t`, or `false` otherwise.
Cho hai chuỗi `s` và `t`, trả về `true` nếu `s` là **chuỗi con** của `t`, ngược lại trả về `false`.

A **subsequence** of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., `"ace"` is a subsequence of `"abcde"` while `"aec"` is not).
Một **chuỗi con** của một chuỗi là một chuỗi mới được tạo thành từ chuỗi ban đầu bằng cách xóa một số (có thể không xóa) các ký tự mà không làm xáo trộn vị trí tương đối của các ký tự còn lại. (ví dụ: `"ace"` là chuỗi con của `"abcde"` trong khi `"aec"` thì không).

### Example 1:
```text
Input: s = "abc", t = "ahbgdc"
Output: true
```

### Example 2:
```text
Input: s = "axc", t = "ahbgdc"
Output: false
```

## Constraints / Ràng buộc
- `0 <= s.length <= 100`
- `0 <= t.length <= 10^4`
- `s` and `t` consist only of lowercase English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Two Pointers / Hai Con Trỏ
To check if `s` is a subsequence of `t`, we can use two pointers: one for `s` (`i`) and one for `t` (`j`).
We iterate through `t`. Whenever `t[j]` matches `s[i]`, we increment `i`. We always increment `j`.
If `i` reaches the end of `s`, then `s` is a subsequence.

### Complexity / Độ phức tạp
- **Time**: O(T) where T is the length of string `t`.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Two Pointers

**Algorithm**:
1.  Initialize `i = 0` (pointer for `s`) and `j = 0` (pointer for `t`).
2.  While `i < s.length()` and `j < t.length()`:
    - If `s.charAt(i) == t.charAt(j)`:
        - `i++`.
    - `j++`.
3.  Return `i == s.length()`.

---
