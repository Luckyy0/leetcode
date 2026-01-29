# 408. Valid Word Abbreviation / Viết Tắt Từ Hợp Lệ

## Problem Description / Mô tả bài toán
A string can be abbreviated by replacing any number of non-adjacent substrings with their lengths. For example, a string such as `"substitution"` can be abbreviated as:
Một chuỗi có thể được viết tắt bằng cách thay thế bất kỳ số lượng chuỗi con không liền kề nào bằng độ dài của chúng. Ví dụ:

- `"s10n"` (`"s"` + subsegment of length 10 + `"n"`)
- `"sub4u4"` (`"sub"` + subsegment of length 4 + `"u"` + subsegment of length 4)
- `"12"` (subsegment of length 12)
- `"su3i1u2on"`
- `"substitution"` (no abbreviation)

The following are **not** valid abbreviations:
- `"s010n"` (contains leading zeros)
- `"s0n"` (contains leading zeros)
- `"s55n"` (the replaced substrings must be non-adjacent, however, 55 represents one substring of length 55, wait, actually 55 is valid, but the rule often states that we can't have two numbers next to each other because they'd be merged anyway).
Actually, the common constraint is that leading zeros are disallowed, and the total length must match.

Given a string `word` and an abbreviation `abbr`, return whether the string matches the given abbreviation.
Cho một chuỗi `word` và một chữ viết tắt `abbr`, hãy trả về xem chuỗi đó có khớp với chữ viết tắt đã cho hay không.

### Example 1:
```text
Input: word = "substitution", abbr = "s10n"
Output: true
```

### Example 2:
```text
Input: word = "substitution", abbr = "s010n"
Output: false
```

## Constraints / Ràng buộc
- `1 <= word.length <= 20`
- `word` consists of only lowercase English letters.
- `1 <= abbr.length <= 10`
- `abbr` consists of lowercase English letters and digits.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Two Pointers / Hai con trỏ
The goal is to verify if `abbr` correctly describes `word`. We use one pointer for each string.

Algorithm:
1. Initialize `i = 0` (for `word`) and `j = 0` (for `abbr`).
2. While `i < word.length()` and `j < abbr.length()`:
   - If `abbr[j]` is a digit:
     - If `abbr[j] == '0'`, return false (leading zero check).
     - Parse the number `num` by reading all consecutive digits.
     - Advance `i` by `num`.
   - Else:
     - If `word.charAt(i) != abbr.charAt(j)`, return false.
     - `i++`, `j++`.
3. Return `i == word.length() && j == abbr.length()`.

### Complexity / Độ phức tạp
- **Time**: O(N + M) where N = word length, M = abbr length.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear Scan with Two Pointers

**Algorithm**:
1.  Iterate and handle number parsing.
2.  Check for leading zero.
3.  Check final pointer positions.

---
