# 516. Longest Palindromic Subsequence / Dãy Con Đối Xứng Dài Nhất

## Problem Description / Mô tả bài toán
Given a string `s`, find the longest palindromic **subsequence**'s length in `s`.
Cho một chuỗi `s`, hãy tìm độ dài của **dãy con đối xứng** dài nhất trong `s`.

A **subsequence** is a sequence that can be derived from another sequence by deleting zero or more elements without changing the order of the remaining elements.
Một **dãy con** là một dãy có thể được rút ra từ một dãy khác bằng cách xóa đi không hoặc nhiều phần tử mà không làm thay đổi thứ tự của các phần tử còn lại.

### Example 1:
```text
Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
```

### Example 2:
```text
Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
```

## Constraints / Ràng buộc
- `1 <= s.length <= 1000`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch động
Let `dp[i][j]` be the length of the longest palindromic subsequence in the substring `s[i...j]`.

Algorithm:
1. Base case: `dp[i][i] = 1`. (Every single character is a palindrome of length 1).
2. Recursive step:
   - If `s[i] == s[j]`:
     - Both characters can be part of the palindrome.
     - `dp[i][j] = 2 + dp[i+1][j-1]` (if `i+1 <= j-1`), else `dp[i][j] = 2`.
   - If `s[i] != s[j]`:
     - We take the maximum of excluding either `s[i]` or `s[j]`.
     - `dp[i][j] = max(dp[i+1][j], dp[i][j-1])`.
3. To compute this efficiently, we iterate over possible lengths `len` from 2 up to `n`.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: Range-based Dynamic Programming

**Algorithm**:
1.  Initialize DP matrix.
2.  Set diagonals to 1.
3.  Outer loop for substring length.
4.  Inner loop for starting index.
5.  Update based on character equality.

---
