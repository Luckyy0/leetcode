# 318. Maximum Product of Word Lengths / Tích Lớn Nhất Của Độ Dài Các Từ

## Problem Description / Mô tả bài toán
Given a string array `words`, return the maximum value of `length(word[i]) * length(word[j])` where the two words do not share common letters. If no such two words exist, return `0`.
Cho một mảng chuỗi `words`, trả về giá trị lớn nhất của `length(word[i]) * length(word[j])` trong đó hai từ không chia sẻ các chữ cái chung. Nếu không tồn tại hai từ như vậy, trả về `0`.

### Example 1:
```text
Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
```

### Example 2:
```text
Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".
```

### Example 3:
```text
Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.
```

## Constraints / Ràng buộc
- `2 <= words.length <= 1000`
- `1 <= words[i].length <= 1000`
- `words[i]` consists only of lowercase English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Bit Manipulation (Bitmask) / Thao Tác Bit
Since words consist of only lowercase English letters (26 chars), we can represent the set of characters in each word using a 32-bit integer (bitmask).
- `a` -> bit 0, `b` -> bit 1, ..., `z` -> bit 25.
- `mask |= 1 << (char - 'a')`.

Two words `words[i]` and `words[j]` share no common letters if `(mask[i] & mask[j]) == 0`.

**Algorithm**:
1.  Compute bitmasks for all words. Store in array `masks`.
2.  Store lengths in array `lens`.
3.  Iterate `i` from 0 to N.
4.  Iterate `j` from i+1 to N.
5.  If `(masks[i] & masks[j]) == 0`, `max = max(max, lens[i] * lens[j])`.

### Optimization
- If multiple words have the same mask, we only care about the one with the maximum length.
- Map `Mask -> MaxLength`.
- Reduces size of loops if many words share same char set.

### Complexity / Độ phức tạp
- **Time**: O(N^2 + L). Precompute takes O(L) total length. Comparison takes O(N^2). N=1000 -> N^2 = 10^6. Fast.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Bitmask + Double Loop

**Algorithm**:
1.  `masks` array. `lens` array.
2.  Precompute.
3.  Loop pairs.

---
