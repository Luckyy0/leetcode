# 557. Reverse Words in a String III / Đảo Ngược Các Từ Trong Chuỗi III

## Problem Description / Mô tả bài toán
Given a string `s`, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
Cho một chuỗi `s`, hãy đảo ngược thứ tự các ký tự trong mỗi từ trong một câu trong khi vẫn giữ nguyên khoảng trắng và thứ tự từ ban đầu.

### Example 1:
```text
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Split and Reverse / Tách và Đảo ngược
Algorithm:
1. Split the string by space into an array of words.
2. For each word, reverse its characters.
3. Join the words back with spaces.
   - OR iterate through the char array, find start and end of each word, and reverse in-place (better space).

In-place Algorithm:
1. Traverse string.
2. Keep `start` pointer.
3. When space or end is found (`end`), reverse substring `[start, end-1]`.
4. Update `start = end + 1`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) (Strings are immutable in Java, need char array or StringBuilder).

---

## Analysis / Phân tích

### Approach: Token Reversal

**Algorithm**:
1.  Locate word boundaries (spaces).
2.  Identify start and end indices of each word.
3.  Reverse characters within those bounds in-place.
4.  Construct result.

---
