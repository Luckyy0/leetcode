# 424. Longest Repeating Character Replacement / Thay Thế Ký Tự Lặp Lại Dài Nhất

## Problem Description / Mô tả bài toán
You are given a string `s` and an integer `k`. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most `k` times.
Bạn được cho một chuỗi `s` và một số nguyên `k`. Bạn có thể chọn bất kỳ ký tự nào của chuỗi và thay đổi nó thành bất kỳ ký tự tiếng Anh viết hoa nào khác. Bạn có thể thực hiện thao tác này tối đa `k` lần.

Return the length of the longest substring containing the same letter you can get after performing the above operations.
Hãy trả về độ dài của chuỗi con dài nhất chứa cùng một chữ cái mà bạn có thể có được sau khi thực hiện các thao tác trên.

### Example 1:
```text
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
```

### Example 2:
```text
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating character, which is 4.
```

## Constraints / Ràng buộc
- `1 <= s.length <= 10^5`
- `s` consists of only uppercase English letters.
- `0 <= k <= s.length`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Sliding Window / Cửa sổ trượt
We want to find the largest window `[left, right]` such that we can replace at most `k` characters to make all characters in the window identical.

Algorithm:
1. Maintain a window `[left, right]` and a frequency map (array of size 26) of characters in the window.
2. Track `maxFreq`, the count of the most frequent character currently in the window.
3. The number of characters to replace is `(length of window) - maxFreq`.
4. If `(right - left + 1) - maxFreq > k`, the current window is invalid. Move `left` forward and decrement frequencies.
5. Note: `maxFreq` doesn't strictly need to be decreased when `left` moves because we are looking for a window larger than the current maximum.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `s`.
- **Space**: O(1) (array of size 26).

---

## Analysis / Phân tích

### Approach: Sliding Window

**Algorithm**:
1.  Initialize `left = 0`, `maxFreq = 0`.
2.  Iterate `right` from 0 to N-1.
3.  Update frequency and `maxFreq`.
4.  Shrink window if invalid.
5.  Update result.

---
