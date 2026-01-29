# 434. Number of Segments in a String / Số Lượng Phân Đoạn Trong Một Chuỗi

## Problem Description / Mô tả bài toán
Given a string `s`, return the number of segments in the string.
Cho một chuỗi `s`, trả về số lượng phân đoạn trong chuỗi.

A **segment** is defined to be a contiguous sequence of non-space characters.
Một **phân đoạn** được định nghĩa là một chuỗi liên tiếp các ký tự không phải khoảng trắng.

### Example 1:
```text
Input: s = "Hello, my name is John"
Output: 5
Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
```

### Example 2:
```text
Input: s = "Hello"
Output: 1
```

## Constraints / Ràng buộc
- `0 <= s.length <= 300`
- `s` consists of English letters, digits, or punctuation marks.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Iterative Character Checking / Kiểm tra ký tự theo vòng lặp
A simple way to count segments is to look for the start of each segment. A character starts a segment if:
1. It is not a space.
2. It is either the first character of the string or the character immediately preceding it is a space.

Algorithm:
1. Initialize `count = 0`.
2. Iterate through the string using index `i`.
3. If `s.charAt(i) != ' '` and (`i == 0` or `s.charAt(i-1) == ' '`):
   - `count++`.
4. Return `count`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `s`.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Boundary Counting

**Algorithm**:
1.  Iterate through each character.
2.  Count transitions from a space to a non-space character.

---
