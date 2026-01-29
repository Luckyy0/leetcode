# 567. Permutation in String / Hoán Vị Trong Chuỗi

## Problem Description / Mô tả bài toán
Given two strings `s1` and `s2`, return `true` if `s2` contains a permutation of `s1`, or `false` otherwise.
Cho hai chuỗi `s1` và `s2`, trả về `true` nếu `s2` chứa một hoán vị của `s1`, hoặc `false` nếu ngược lại.

In other words, return `true` if one of `s1`'s permutations is the substring of `s2`.
Nói cách khác, trả về `true` nếu một trong các hoán vị của `s1` là chuỗi con của `s2`.

### Example 1:
```text
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window + Frequency Array / Cửa Số Trượt + Mảng Tần Suất
We need to find a window of length `len(s1)` in `s2` that has the same character counts as `s1`.

Algorithm:
1. If `len(s1) > len(s2)`, return `false`.
2. Count chars of `s1` in `count1`.
3. Count chars of the first `len(s1)` chars of `s2` in `count2`.
4. Compare `count1` and `count2`. If equal, return `true`.
5. Slide the window from `len(s1)` to `len(s2)`:
   - Add new char to `count2`.
   - Remove old char (leaving window) from `count2`.
   - Compare `count1` vs `count2` (or check difference efficiently).
6. Return `false` if loop finishes.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is length of s2.
- **Space**: O(1) (26 characters).

---

## Analysis / Phân tích

### Approach: Fixed Frequency Window

**Algorithm**:
1.  Compute frequency map of `s1`.
2.  Initialize sliding window on `s2`.
3.  Slide window, updating counts.
4.  Check for map equality at each step.

---
