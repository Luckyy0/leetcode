# 484. Find Permutation / Tìm Hoán Vị

## Problem Description / Mô tả bài toán
A permutation `perm` of `n` integers of all the integers in the range `[1, n]` can be represented as a string `s` of length `n - 1` where:
Một hoán vị `perm` gồm `n` số nguyên trong phạm vi `[1, n]` có thể được biểu diễn dưới dạng một chuỗi `s` độ dài `n - 1` trong đó:
- `s[i] == 'I'` if `perm[i] < perm[i + 1]`, and
- `s[i] == 'D'` if `perm[i] > perm[i + 1]`.

Given a string `s`, reconstruct the lexicographically smallest permutation `perm` of `[1, n]` that produces `s`.
Cho một chuỗi `s`, hãy khôi phục hoán vị `perm` nhỏ nhất theo thứ tự từ điển của `[1, n]` mà tạo ra chuỗi `s`.

### Example 1:
```text
Input: s = "I"
Output: [1,2]
Explanation: [1,2] is the only permutation of [1,2] that has the pattern "I".
```

### Example 2:
```text
Input: s = "DI"
Output: [2,1,3]
Explanation: Both [2,1,3] and [3,1,2] have the pattern "DI", but [2,1,3] is lexicographically smaller.
```

## Constraints / Ràng buộc
- `1 <= s.length <= 10^5`
- `s` consists of only `'I'` and `'D'`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Reverse-Segment Strategy / Chiến lược Đảo ngược Phân đoạn
To get the lexicographically smallest permutation, we should try to keep the elements in ascending order as much as possible.
A simple way to achieve this is:
1. Start with the sorted array `[1, 2, ..., n]`.
2. For every continuous segment of `'D'` characters in the string `s`, reverse the corresponding segment in the array.

Example: `s = "DID"`
1. Initial: `[1, 2, 3, 4]`
2. Segment 1: `'D'` at `s[0]`. Corresponds to indices `0, 1` in `perm`. Reverse `perm[0...1]` -> `[2, 1, 3, 4]`.
3. Segment 2: `'I'` at `s[1]`. Do nothing.
4. Segment 3: `'D'` at `s[2]`. Corresponds to indices `2, 3` in `perm`. Reverse `perm[2...3]` -> `[2, 1, 4, 3]`.

Result: `[2, 1, 4, 3]`

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `s`. We traverse the string and reverse segments (each element is reversed at most once).
- **Space**: O(N) to store the result.

---

## Analysis / Phân tích

### Approach: Sorted Array with Segment Reversal

**Algorithm**:
1.  Initialize array `[1...n]`.
2.  Scan string for 'D' blocks.
3.  Reverse the indices corresponding to 'D' blocks.

---
