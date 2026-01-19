# 205. Isomorphic Strings / Chuỗi Đẳng Cấu

## Problem Description / Mô tả bài toán
Given two strings `s` and `t`, determine if they are isomorphic.
Cho hai chuỗi `s` và `t`, xác định xem chúng có đẳng cấu hay không.

Two strings `s` and `t` are isomorphic if the characters in `s` can be replaced to get `t`.
Hai chuỗi `s` và `t` là đẳng cấu nếu các ký tự trong `s` có thể được thay thế để tạo thành `t`.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
Tất cả các lần xuất hiện của một ký tự phải được thay thế bằng một ký tự khác trong khi vẫn giữ nguyên thứ tự của các ký tự. Không được có hai ký tự nào ánh xạ tới cùng một ký tự, nhưng một ký tự có thể ánh xạ tới chính nó.

### Example 1:
```text
Input: s = "egg", t = "add"
Output: true
```

### Example 2:
```text
Input: s = "foo", t = "bar"
Output: false
```

### Example 3:
```text
Input: s = "paper", t = "title"
Output: true
```

## Constraints / Ràng buộc
- `1 <= s.length <= 5 * 10^4`
- `t.length == s.length`
- `s` and `t` consist of any valid ascii character.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Bijective Mapping / Ánh xạ Song ánh
We need to establish a one-to-one mapping (bijection) between characters of `s` and `t`.
Chúng ta cần thiết lập một ánh xạ một-một (song ánh) giữa các ký tự của `s` và `t`.

Conditions:
1.  If `s[i]` maps to `t[i]`, it must always map to `t[i]`.
2.  If `t[i]` is mapped from `s[i]`, it cannot be mapped from any other character `s[j]` where `s[j] != s[i]`.

**Strategy**:
We can use two arrays (or HashMaps) to track the mappings:
- `mapS[charS]` stores the character mapped from S to T.
- `mapT[charT]` stores the character mapped from T to S.

Or simpler: Store the **last seen index** (or relative pattern ID). If `s` marks `e` -> 1, `g` -> 2, `g` -> 3 and `t` marks `a` -> 1, `d` -> 2, `d` -> 3, the patterns match.

---

## Analysis / Phân tích

### Approach: Two Maps Validation

**Algorithm**:
1.  Initialize arrays `mapS` and `mapT` of size 256 (ASCII).
2.  Iterate through the strings.
3.  Check if `mapS[s[i]] != mapT[t[i]]`. In this variation, we store the *last index + 1* seen.
    - If `mapS[s[i]]` stores the last index s[i] was seen, and `mapT[t[i]]` stores the last index t[i] was seen.
    - If they differ, the pattern is broken.
4.  Update the maps with current index `i + 1`.

### Complexity / Độ phức tạp
- **Time**: O(N) - single pass.
- **Space**: O(1) - fixed size arrays (256).

---

## Edge Cases / Các trường hợp biên
1.  **Empty strings**: Not possible per constraints.
2.  **Length 1**: Always true.
3.  **Same mapping twice**: `aa` -> `bb` (True).
4.  **Cross mapping**: `ab` -> `aa` (False).
