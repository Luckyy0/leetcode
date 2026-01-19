# 87. Scramble String / Chuỗi Xáo Trộn

## Problem Description / Mô tả bài toán
We can scramble a string s to get a string t using the following algorithm:
Chúng ta có thể xáo trộn một chuỗi s để nhận được một chuỗi t bằng thuật toán sau:
1.  If the length of the string is 1, stop.
2.  If the length of the string is > 1, do the following:
    - Split the string into two non-empty substrings at a random index, i.e., if the string is `s`, divide it to `x` and `y` where `s = x + y`.
    - Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, `s` may become `s = x + y` or `s = y + x`.
    - Apply step 1 recursively on each of the two substrings `x` and `y`.

Given two strings `s1` and `s2` of the same length, return `true` if `s2` is a scrambled string of `s1`, otherwise, return `false`.
Cho hai chuỗi `s1` và `s2` có cùng độ dài, trả về `true` nếu `s2` là chuỗi xáo trộn của `s1`, nếu không, trả về `false`.

### Example 1:
```text
Input: s1 = "great", s2 = "rgeat"
Output: true
```

### Example 2:
```text
Input: s1 = "abcde", s2 = "caebd"
Output: false
```

## Constraints / Ràng buộc
- `s1.length == s2.length`
- `1 <= s1.length <= 30`
- `s1` and `s2` consist of lowercase English letters.

---

## Analysis / Phân tích

### Approach: Memoized Recursion (DP) / Đệ Quy Có Ghi Nhớ (DP)
- **Idea**: Try all possible split points. For each split `i` from 1 to n-1:
    - Case 1 (No Swap): `isScramble(s1[0..i], s2[0..i])` AND `isScramble(s1[i..n], s2[i..n])`.
    - Case 2 (Swap): `isScramble(s1[0..i], s2[n-i..n])` AND `isScramble(s1[i..n], s2[0..n-i])`.
- **Pruning**: Check if `s1` and `s2` have same character counts first.
- **Memoization**: Map key `s1 + "#" + s2` -> boolean.
- **Time Complexity**: O(N^4). Substrings are O(N^2), each has O(N) split points and string ops.
- **Space Complexity**: O(N^3) for memoization.

---

## Edge Cases / Các trường hợp biên
1.  **Length 1**: `s1 == s2`?
2.  **Not Anagram**: Quick return false.
