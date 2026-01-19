# 242. Valid Anagram / Đảo Chữ Hợp Lệ

## Problem Description / Mô tả bài toán
Given two strings `s` and `t`, return `true` if `t` is an **anagram** of `s`, and `false` otherwise.
Cho hai chuỗi `s` và `t`, hãy trả về `true` nếu `t` là một **chuỗi đảo chữ** (anagram) của `s`, và `false` nếu không.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Một **Anagram** là một từ hoặc cụm từ được hình thành bằng cách sắp xếp lại các chữ cái của một từ hoặc cụm từ khác, thường sử dụng tất cả các chữ cái gốc chính xác một lần.

### Example 1:
```text
Input: s = "anagram", t = "nagaram"
Output: true
```

### Example 2:
```text
Input: s = "rat", t = "car"
Output: false
```

## Constraints / Ràng buộc
- `1 <= s.length, t.length <= 5 * 10^4`
- `s` and `t` consist of lowercase English letters.

**Follow up**: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Character Counting (Frequency Map) / Đếm Ký Tự
Two valid anagrams must have the **same characters** with the **same frequencies**.
Sorting both strings (`s` and `t`) and comparing them works in `O(N log N)`.
A more efficient way involves counting character occurrences in `O(N)`.

For standard ASCII lower-case, an integer array of size 26 suffices.
- Iterate `s`, increment count for each char.
- Iterate `t`, decrement count for each char.
- If at any point count goes below zero (or check all zero at end), it fails. (Assuming lengths equal first).

**For Unicode (Follow-up)**:
Use a `HashMap<Character, Integer>` instead of a fixed-size array.

---

## Analysis / Phân tích

### Approach: Frequency Array

**Algorithm**:
1.  Check if `s.length() != t.length()`. If so, return `false`.
2.  Initialize `counts` array of size 26.
3.  Loop `i` from 0 to length:
    - `counts[s.charAt(i) - 'a']++`
    - `counts[t.charAt(i) - 'a']--`
4.  Loop check: If any value in `counts` is non-zero, return `false`.
    - Optimization: Can check `counts[t.charAt(i) - 'a'] < 0` inside the loop if we fill `s` first then `t`.

### Complexity / Độ phức tạp
- **Time**: O(N) - Linear scan.
- **Space**: O(1) - Fixed size array (26).

---

## Edge Cases / Các trường hợp biên
1.  **Different lengths**: Immediate failure.
2.  **Empty strings**: (Constraints say >= 1).
3.  **Same strings**: True.
