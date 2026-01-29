# 459. Repeated Substring Pattern / Mẫu Chuỗi Lặp Lại

## Problem Description / Mô tả bài toán
Given a string `s`, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
Cho một chuỗi `s`, hãy kiểm tra xem nó có thể được tạo thành bằng cách lấy một chuỗi con của nó và nối nhiều bản sao của chuỗi con đó lại với nhau hay không.

### Example 1:
```text
Input: s = "abab"
Output: true
Explanation: It is the substring "ab" repeated twice.
```

### Example 2:
```text
Input: s = "aba"
Output: false
```

### Example 3:
```text
Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" repeated four times or the substring "abcabc" repeated twice.
```

## Constraints / Ràng buộc
- `1 <= s.length <= 10^4`
- `s` consists of lowercase English letters.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### String Manipulation Hack / "Mẹo" thao tác chuỗi
A very clever trick to solve this is:
If `s` is composed of a repeated substring `P`, then `s = P + P + ... + P`.
If we double the string `s` to get `SS = s + s`, and then remove the first and last characters, the original string `s` will still appear in the middle of `SS` if and only if `s` is a repeated pattern.

Algorithm:
1. Construct `doubledString = s + s`.
2. Get the substring: `doubledString.substring(1, doubledString.length() - 1)`.
3. Check if this substring contains the original `s`.

Mathematical proof:
If `s` has period `L/k`, where `L` is length and `k > 1` is integer.
Then `s` is a prefix of `s+s` starting at index 0, and also a prefix starting at index `L/k`.
By removing first and last char, we look for matches at indices `[1, L-1]`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `s` (for string concatenation and searching).
- **Space**: O(N) to store the doubled string.

---

## Analysis / Phân tích

### Approach: String Concatenation Trick

**Algorithm**:
1.  Verify `(s + s).substring(1, 2 * s.length() - 1).contains(s)`.

---
