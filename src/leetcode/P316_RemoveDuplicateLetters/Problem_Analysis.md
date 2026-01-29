# 316. Remove Duplicate Letters / Xóa Các Chữ Cái Trùng Lặp

## Problem Description / Mô tả bài toán
Given a string `s`, remove duplicate letters so that every letter appears once and only once. You must make sure your result is **the smallest in lexicographical order** among all possible results.
Cho một chuỗi `s`, hãy xóa các chữ cái trùng lặp sao cho mỗi chữ cái chỉ xuất hiện một lần. Bạn phải đảm bảo kết quả của mình là **nhỏ nhất theo thứ tự từ điển** trong số tất cả các kết quả có thể.

### Example 1:
```text
Input: s = "bcabc"
Output: "abc"
```

### Example 2:
```text
Input: s = "cbacdcbc"
Output: "acdb"
```

## Constraints / Ràng buộc
- `1 <= s.length <= 10^4`
- `s` consists of lowercase English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Monotonic Stack + Greedy / Ngăn Xếp Đơn Điệu + Tham Lam
We want the smallest lexicographical result.
- We iterate through the string.
- Maintain a stack of characters for the result.
- When adding `char c`:
    - If `c` is already in stack, skip.
    - While `stack.peek() > c` AND `stack.peek()` appears later in the string (we have more copies of it):
        - Pop `stack.peek()`. (Because we can pick it later to get a smaller char `c` earlier).
    - Push `c`.
- To check "appears later", we precompute frequency/last index.

**Algorithm**:
1.  `lastIndex` array [26].
2.  `seen` boolean array [26].
3.  `stack` (or StringBuilder).
4.  Loop `i` from 0 to n-1:
    - `c = s[i]`.
    - If `seen[c]`, continue.
    - While `!stack.isEmpty()` and `stack.peek() > c` and `lastIndex[stack.peek()] > i`:
        - `removed = stack.pop()`.
        - `seen[removed] = false`.
    - `stack.push(c)`.
    - `seen[c] = true`.

### Complexity / Độ phức tạp
- **Time**: O(N). Each char pushed/popped at most once.
- **Space**: O(1) (stack size <= 26).

---

## Analysis / Phân tích

### Approach: Monotonic Stack

**Edge Cases**:
1.  Empty string? Constraint `1 <= len`.
2.  Already distinct: "abc". Stack fills "a", "b", "c". Order preserved.

---
