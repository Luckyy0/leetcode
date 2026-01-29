# 467. Unique Substrings in Wraparound String / Các Chuỗi Con Duy Nhất Trong Chuỗi Bao Quanh

## Problem Description / Mô tả bài toán
We define the string `base` to be the infinite wraparound string of `"abcdefghijklmnopqrstuvwxyz"`, so `base` looks like this:
Chúng ta định nghĩa chuỗi `base` là một chuỗi bao quanh vô hạn của `"abcdefghijklmnopqrstuvwxyz"`, vì vậy `base` trông như thế này:
- `"...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...."`

Given a string `s`, return the number of unique non-empty substrings of `s` that are present in `base`.
Cho một chuỗi `s`, hãy trả về số lượng các chuỗi con không rỗng duy nhất của `s` mà có mặt trong chuỗi `base`.

### Example 1:
```text
Input: s = "a"
Output: 1
Explanation: Only substring "a" is in base.
```

### Example 2:
```text
Input: s = "cac"
Output: 2
Explanation: Substrings are "a", "c".
```

### Example 3:
```text
Input: s = "zab"
Output: 6
Explanation: There are six substrings ("z", "a", "b", "za", "ab", "zab") of "zab" in base.
```

## Constraints / Ràng buộc
- `1 <= s.length <= 10^5`
- `s` consists of lowercase English letters.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Substring Length Logic / Logic Độ dài Chuỗi con
A substring of `s` is present in `base` if all of its characters are consecutive in the alphabet (with 'a' following 'z').
For a continuous segment of `s` that follows the alphabet order (e.g., "abcd"), the number of substrings ending at "d" that are in `base` is equal to the length of the continuous segment ending at "d".
For "abcd", lengths are 1, 2, 3, 4. Substrings: "d", "cd", "bcd", "abcd".

Algorithm:
1. Maintain an array `max_len[26]` where `max_len[i]` stores the length of the longest continuous substring ending with the character `'a' + i`.
2. Iterate through `s` and track the current `current_max_len` of the continuous segment:
   - If `s[i]` follows `s[i-1]` (e.g., `s[i] == s[i-1] + 1` or `s[i-1] == 'z' && s[i] == 'a'`), increment `current_max_len`.
   - Otherwise, reset `current_max_len = 1`.
   - Update `max_len[s[i] - 'a'] = max(max_len[s[i] - 'a'], current_max_len)`.
3. The total number of unique substrings is the sum of all values in `max_len`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `s`.
- **Space**: O(1) for the array of size 26.

---

## Analysis / Phân tích

### Approach: Character-based Max Length Tracking

**Algorithm**:
1.  Initialize length array for each letter.
2.  Iterate and detect continuous segments.
3.  Update letter-specific max lengths.
4.  Sum the results.

---
