# 383. Ransom Note / Bức Thư Tống Tiền

## Problem Description / Mô tả bài toán
Given two strings `ransomNote` and `magazine`, return `true` if `ransomNote` can be constructed by using the letters from `magazine` and `false` otherwise.
Cho hai chuỗi `ransomNote` và `magazine`, trả về `true` nếu `ransomNote` có thể được xây dựng bằng cách sử dụng các chữ cái từ `magazine` và `false` nếu ngược lại.

Each letter in `magazine` can only be used once in `ransomNote`.
Mỗi chữ cái trong `magazine` chỉ được sử dụng một lần trong `ransomNote`.

### Example 1:
```text
Input: ransomNote = "a", magazine = "b"
Output: false
```

### Example 2:
```text
Input: ransomNote = "aa", magazine = "ab"
Output: false
```

### Example 3:
```text
Input: ransomNote = "aa", magazine = "aab"
Output: true
```

## Constraints / Ràng buộc
- `1 <= ransomNote.length, magazine.length <= 10^5`
- `ransomNote` and `magazine` consist of lowercase English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Frequency Array (Counting Sort) / Mảng Tần Suất
Since inputs are lowercase English letters, we can use an integer array of size 26.
1.  Count frequencies of characters in `magazine`.
2.  Iterate `ransomNote`. Decrement count.
3.  If count `< 0`, return `false`.
4.  If loop finishes, return `true`.

### Complexity / Độ phức tạp
- **Time**: O(N + M). (M is length of magazine).
- **Space**: O(1) (Size 26).

---

## Analysis / Phân tích

### Approach: Frequency Array

**Algorithm**:
1.  `cnt[26]`.
2.  Loop `c` in `magazine`: `cnt[c-'a']++`.
3.  Loop `c` in `ransomNote`:
    - `cnt[c-'a']--`.
    - If `cnt` < 0 return `false`.
4.  Return `true`.

---
