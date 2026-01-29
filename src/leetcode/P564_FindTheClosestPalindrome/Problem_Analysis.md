# 564. Find the Closest Palindrome / Tìm Palindrome Gần Nhất

## Problem Description / Mô tả bài toán
Given a string `n` representing an integer, return the closest integer (not including itself), which is a palindrome. If there is a tie, return the smaller one.
Cho một chuỗi `n` đại diện cho một số nguyên, hãy trả về số nguyên gần nhất (không bao gồm chính nó) là một palindrome. Nếu có sự hòa nhau, hãy trả về số nhỏ hơn.

The closest is defined as the absolute difference minimized between two integers.
Gần nhất được định nghĩa là chênh lệch tuyệt đối nhỏ nhất giữa hai số nguyên.

### Example 1:
```text
Input: n = "123"
Output: "121"
```

### Example 2:
```text
Input: n = "1"
Output: "0"
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Candidate Generation / Tạo Ứng Viên
The closest palindrome is likely derived from the prefix of the number.
Let the number have length `L`.
Candidates:
1. `10^(L-1) - 1` (e.g., 999 for 1000). Boundary case.
2. `10^L + 1` (e.g., 10001 for 9999). Boundary case.
3. Palindromes formed by:
   - Prefix of `n`.
   - Prefix of `n` + 1.
   - Prefix of `n` - 1.

Prefix Logic: Take the first `(L+1)/2` characters, interpret as integer `P`.
Generate palindromes from `P`, `P-1`, `P+1`.
Mirror the first half to form the second half.

Finally, compare all candidates with `n` to find the minimum difference.

### Complexity / Độ phức tạp
- **Time**: O(L) where L is length of string.
- **Space**: O(L).

---

## Analysis / Phân tích

### Approach: Constructive Candidate Search

**Algorithm**:
1.  Handle edge cases (single digit, powers of 10).
2.  Extract prefix (first half).
3.  Generate candidates by incrementing/decrementing prefix and establishing symmetry.
4.  Generate boundary candidates (99...9, 10...01).
5.  Find candidate with minimum absolute difference.

---
