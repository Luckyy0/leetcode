# 345. Reverse Vowels of a String / Đảo Ngược Nguyên Âm Trong Chuỗi

## Problem Description / Mô tả bài toán
Given a string `s`, reverse only all the vowels in the string and return it.
Cho một chuỗi `s`, đảo ngược chỉ các nguyên âm trong chuỗi và trả lại nó.

The vowels are `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`, and they can appear in both lower and upper cases, more than once.
Các nguyên âm bao gồm 'a', 'e', 'i', 'o', 'u' cả hường và hoa.

### Example 1:
```text
Input: s = "hello"
Output: "holle"
```

### Example 2:
```text
Input: s = "leetcode"
Output: "leotcede"
```

## Constraints / Ràng buộc
- `1 <= s.length <= 3 * 10^5`
- `s` consist of printable ASCII characters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Two Pointers / Hai Con Trỏ
Two pointers `left` and `right`.
Move `left` forward until it hits a vowel.
Move `right` backward until it hits a vowel.
If `left < right`: Swap.
Continue until `left >= right`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) (Since String is immutable in Java, need char array).

---

## Analysis / Phân tích

### Approach: Two Pointers

**Algorithm**:
1.  Function `isVowel(char)`. Note case sensitivity (upper/lower).
2.  Convert `s` to `char[]`.
3.  Loop swap.

---
