# 387. First Unique Character in a String / Ký Tự Duy Nhất Đầu Tiên Trong Chuỗi

## Problem Description / Mô tả bài toán
Given a string `s`, find the first non-repeating character in it and return its index. If it does not exist, return `-1`.
Cho một chuỗi `s`, tìm ký tự đầu tiên không lặp lại và trả về chỉ mục của nó. Nếu không tồn tại, trả về `-1`.

### Example 1:
```text
Input: s = "leetcode"
Output: 0
```

### Example 2:
```text
Input: s = "loveleetcode"
Output: 2
```

### Example 3:
```text
Input: s = "aabb"
Output: -1
```

## Constraints / Ràng buộc
- `1 <= s.length <= 10^5`
- `s` consists of only lowercase English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Frequency Array / Mảng Tần Suất
Two-pass:
1.  Count frequency of each character.
2.  Iterate again. Return first index where `count[c] == 1`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) (Size 26).

---

## Analysis / Phân tích

### Approach: Frequency Array

**Algorithm**:
1.  `cnt[26]`.
2.  Loop 1: Count.
3.  Loop 2: Find first `cnt == 1`.

---
