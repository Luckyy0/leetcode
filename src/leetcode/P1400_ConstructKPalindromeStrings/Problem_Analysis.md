# 1400. Construct K Palindrome Strings / Xây dựng K Chuỗi Palindrome

## Problem Description / Mô tả bài toán
String `s`, integer `k`.
Can we use all characters of `s` to construct `k` palindrome strings?

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Palindrome Properties
Oddcount characters constraint.
Each palindrome can have at most one character with odd count (in the middle).
So if we have `odd` characters with odd frequencies, we need AT LEAST `odd` palindromes.
Also, we cannot have more palindromes than length of `s` (each char is a palindrome).
Conditions:
1. `odd <= k`
2. `k <= s.length()`

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Count Odd Frequencies
Count character frequencies. Count how many characters have an odd frequency (`oddCount`).
If `k < oddCount`, it's impossible (we need at least `oddCount` palindromes to house the odd-centered characters).
If `k > s.length()`, impossible (cannot make more palindromes than characters).
Otherwise possible. (We can always merge palindromes or split even-count characters).
Đếm tần suất ký tự. Đếm xem có bao nhiêu ký tự có tần suất lẻ (`oddCount`).
Nếu `k < oddCount`, điều đó là không thể (chúng ta cần ít nhất `oddCount` palindrome để chứa các ký tự có tâm lẻ).
Nếu `k > s.length()`, không thể.
Ngược lại có thể.

---
