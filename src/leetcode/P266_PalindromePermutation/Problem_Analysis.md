# 266. Palindrome Permutation / Hoán Vị Đối Xứng

## Problem Description / Mô tả bài toán
Given a string `s`, return `true` if a permutation of the string could form a palindrome and `false` otherwise.
Cho một chuỗi `s`, trả về `true` nếu một hoán vị của chuỗi có thể tạo thành một chuỗi đối xứng (palindrome) và `false` nếu không.

### Example 1:
```text
Input: s = "code"
Output: false
```

### Example 2:
```text
Input: s = "aab"
Output: true
```

### Example 3:
```text
Input: s = "carerac"
Output: true
```

## Constraints / Ràng buộc
- `1 <= s.length <= 5000`
- `s` consists of only lowercase English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Character Frequency Check / Kiểm Tra Tần Suất Ký Tự
For a string to be a palindrome (or permutable into one):
- All characters must appear an **even** number of times.
- EXCEPT at most **one** character which can appear an **odd** number of times (the middle character).

**Algorithm**:
1.  Use a `HashSet` or an integer array (size 26) to track frequencies.
2.  Actually, we only need to track "oddness".
3.  Iterate through the string:
    - If char is in Set, remove it (pair found -> even count).
    - If char is not in Set, add it (odd count).
4.  At the end, if `Set.size() <= 1`, return `true`. Else `false`.

### Complexity / Độ phức tạp
- **Time**: O(N) - Single pass.
- **Space**: O(1) - Max 26 characters (or O(min(N, charset size))).

---

## Analysis / Phân tích

### Approach: Set / Boolean Array

**Edge Cases**:
1.  **Empty**: True.
2.  **Single char**: True.
3.  **Even length**: Set size must be 0? No, if even length, max 1 odd means 0 odds (since sum of counts = even length). Correct.

---
