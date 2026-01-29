# 616. Add Bold Tag in String / Thêm Thẻ Đậm Vào Chuỗi

## Problem Description / Mô tả bài toán
You are given a string `s` and an array of strings `words`. You should add a closed pair of bold tag `<b>` and `</b>` to wrap the substrings in `s` that exist in `words`. If two such substrings overlap, you should wrap them together with only one pair of closed bold-tag. If two substrings wrapped by bold tags are consecutive, you should combine them.
Bạn được cho một chuỗi `s` và một mảng chuỗi `words`. Bạn nên thêm một cặp thẻ đậm đóng `<b>` và `</b>` để bao bọc các chuỗi con trong `s` tồn tại trong `words`. Nếu hai chuỗi con như vậy chồng lấp, bạn nên bao bọc chúng cùng nhau chỉ bằng một cặp thẻ đậm đóng. Nếu hai chuỗi con được bao bọc bởi thẻ đậm liên tiếp, bạn nên kết hợp chúng.

Return the string `s` after adding the bold tags.
Trả về chuỗi `s` sau khi thêm thẻ đậm.

### Example 1:
```text
Input: s = "abcxyz123", words = ["abc","123"]
Output: "<b>abc</b>xyz<b>123</b>"
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Merge Intervals / Hợp Nhất Các Khoảng
1. Identify all matching intervals. For each word in `words`, find all occurrences in `s`.
   Store as intervals `[start, end]`.
   Note: `s.indexOf(word, fromIndex)` or KMP/Trie for efficiency.
   Given constraints usually allow N*M*K string search.
2. Merge overlapping intervals.
   Sort intervals by start time. Merge if `current.start <= prev.end`.
   Also merge consecutive: `current.start == prev.end` (e.g. `[0,3]` and `[3,5]` -> `[0,5]`? Wait. `abc` index 0-3 (exclusive end) -> `abc` is 0,1,2. Next `d` is 3.
   If "consecutive", `[0,3]` and `[3,6]` -> `<b>abc</b><b>def</b>` -> `<b>abcdef</b>`.
   Essentially union the coverage mask.
3. Construct result string.
   Iterate `s`. If index is inside a merged interval, wrap. Or insert tags at start/end of intervals.

Boolean Array Mask:
`boolean[] bold = new boolean[n]`.
For each word and match: mark `bold[i] = true` for `i` in range.
Scan `bold` array to build result. `if bold[i] && !bold[i-1] -> append <b>`. `if !bold[i] && bold[i-1] -> append </b>`.

### Complexity / Độ phức tạp
- **Time**: O(N * Sum(Len(words))).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Boolean Masking

**Algorithm**:
1.  Create boolean mask for string `s`.
2.  For each keyword, search in `s` and mark corresponding indices true.
3.  Traverse `s` and mask to construct result with tags.

---
