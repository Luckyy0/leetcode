# 647. Palindromic Substrings / Các Chuỗi Con Tương Phản

## Problem Description / Mô tả bài toán
Given a string `s`, return the number of palindromic substrings in it.
Cho một chuỗi `s`, trả về số lượng các chuỗi con tương phản trong đó.

A string is a palindrome when it reads the same backward as forward.
Một chuỗi là một palindrome khi nó đọc ngược giống như đọc xuôi.
A substring is a contiguous sequence of characters within the string.
Một chuỗi con là một chuỗi ký tự liên tiếp trong chuỗi.

### Example 1:
```text
Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Expand from Center / Mở Rộng Từ Tâm
Iterate through each character (and between characters) as a potential center.
Expand outwards while `s[left] == s[right]`.
Total centers: `2*N - 1` (N centers on chars, N-1 centers between chars).
Or just loop `i` from 0 to N-1:
- Expand `(i, i)` (Odd length).
- Expand `(i, i+1)` (Even length).

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Center Expansion

**Algorithm**:
1.  Initialize count.
2.  Iterate through string.
3.  For each index, extend palindromes centered at `i` and `i, i+1`.
4.  Add valid expansions to count.

---
