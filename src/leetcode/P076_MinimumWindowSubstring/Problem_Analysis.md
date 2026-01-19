# 76. Minimum Window Substring / Chuỗi Con Cửa Sổ Nhỏ Nhất

## Problem Description / Mô tả bài toán
Given two strings `s` and `t` of lengths `m` and `n` respectively, return the **minimum window substring** of `s` such that every character in `t` (including duplicates) is included in the window. If there is no such substring, return the empty string `""`.
Cho hai chuỗi `s` và `t` có độ dài lần lượt là `m` và `n`, trả về **chuỗi con cửa sổ nhỏ nhất** của `s` sao cho mọi ký tự trong `t` (bao gồm cả các ký tự trùng lặp) đều được bao gồm trong cửa sổ. Nếu không có chuỗi con nào như vậy, trả về chuỗi rỗng `""`.

The testcases will be generated such that the answer is unique.
Các trường hợp kiểm tra sẽ được tạo sao cho câu trả lời là duy nhất.

### Example 1:
```text
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
```

### Example 2:
```text
Input: s = "a", t = "a"
Output: "a"
```

### Example 3:
```text
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
```

## Constraints / Ràng buộc
- `m == s.length`
- `n == t.length`
- `1 <= m, n <= 10^5`
- `s` and `t` consist of uppercase and lowercase English letters.

---

## Analysis / Phân tích

### Approach: Sliding Window / Cửa Sổ Trượt
- **Idea**: Use two pointers `left` and `right`. Expand `right` until valid window. Shrink `left` to minimize.
- **Ý tưởng**: Sử dụng hai con trỏ `left` và `right`. Mở rộng `right` cho đến khi cửa sổ hợp lệ. Thu hẹp `left` để tối thiểu hóa.
- **Structures**:
    - `map` or `array[128]`: To store frequency of chars in `t`.
    - `count`: Number of chars from `t` still needed in current window.
- **Algorithm**:
    1.  Count chars in `t`.
    2.  Init `left = 0, right = 0`.
    3.  Iterate `right < s.length()`:
        - If `s[right]` is in `t`, decrement its count.
        - If count becomes non-negative (meaning it was a needed char), decrement `neededTotal`.
        - While `neededTotal == 0` (valid window):
            - Update `minLen` and `minStart` if current is smaller.
            - `s[left]` moving out. If it acts as a needed char, increment `neededTotal`.
            - `left++`.
- **Time Complexity**: O(m + n).
- **Space Complexity**: O(1) (fixed char set size).

---

## Edge Cases / Các trường hợp biên
1.  **s < t**: Impossible -> "".
2.  **No Solution**: Return "".
3.  **Single Char**: "a", "a" -> "a".
