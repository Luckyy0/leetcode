# 290. Word Pattern / Mẫu Từ

## Problem Description / Mô tả bài toán
Given a `pattern` and a string `s`, find if `s` follows the same pattern.
Cho một `pattern` và một chuỗi `s`, hãy tìm xem `s` có tuân theo cùng một mẫu không.

Here follow means a full match, such that there is a bijection between a letter in `pattern` and a non-empty word in `s`.
Ở đây tuân theo có nghĩa là so khớp hoàn toàn, sao cho có một song ánh giữa một chữ cái trong `pattern` và một từ không rỗng trong `s`.

### Example 1:
```text
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
```

### Example 2:
```text
Input: pattern = "abba", s = "dog cat cat fish"
Output: false
```

### Example 3:
```text
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
```

## Constraints / Ràng buộc
- `1 <= pattern.length <= 300`
- `pattern` contains only lower-case English letters.
- `1 <= s.length <= 3000`
- `s` contains only lowercase English letters and spaces ' '.
- `s` does not contain any leading or trailing spaces.
- All the words in `s` are separated by a single space.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Bijection Mapping / Ánh Xạ Song Ánh
We need two maps (or one map + set) to ensure bijection:
1.  `Map<Char, Word>`: Ensures `a` always maps to `dog`.
2.  `Map<Word, Char>`: Ensures `dog` always maps back to `a`. (Prevents `a -> dog` and `b -> dog`).

**Algorithm**:
1.  Split `s` by space into `words`.
2.  Check length: if `pattern.length` != `words.length`, return `false`.
3.  Init Maps `charToWord`, `wordToChar`.
4.  Loop `i` from 0 to length:
    - `c = pattern[i]`.
    - `w = words[i]`.
    - Check Key `c`:
        - If exists: check if value equals `w`. If not -> False.
    - Check Key `w`:
        - If exists: check if value equals `c`. If not -> False.
    - If neither exists: Put `c->w` and `w->c`.
    - If one exists (implicit logic error if maps not synced? No, handled by above): e.g., `c` new, but `w` exists (mapped to other char). -> False.
5.  Return `True`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is number of words (string splitting + iterating).
- **Space**: O(M) unique words.

---

## Analysis / Phân tích

### Approach: Two HashMaps

**Edge Cases**:
1.  Length mismatch.
2.  Pattern "abba", s "dog dog dog dog". `a->dog`, `b` needs mapping. `dog` maps to `a`. `b` check `dog` -> `a`. But `b`!=`a`. Fail. Correct.

---
