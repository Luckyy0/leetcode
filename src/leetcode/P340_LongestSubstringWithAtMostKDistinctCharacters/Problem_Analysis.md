# 340. Longest Substring with At Most K Distinct Characters / Chuỗi Con Dài Nhất Với Tối Đa K Ký Tự Khác Nhau

## Problem Description / Mô tả bài toán
Given a string `s` and an integer `k`, return the length of the longest substring of `s` that contains at most `k` distinct characters.
Cho một chuỗi `s` và một số nguyên `k`, trả về độ dài của chuỗi con dài nhất của `s` chứa tối đa `k` ký tự khác nhau.

### Example 1:
```text
Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.
```

### Example 2:
```text
Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.
```

## Constraints / Ràng buộc
- `1 <= s.length <= 5 * 10^4`
- `0 <= k <= 50`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Sliding Window / Cửa Sổ Trượt
Maintain a window `[left, right]`.
Expand `right`. Add character to map/counter.
Update Distinct Count.
If distinct count > `k`:
    Shrink `left` until distinct count <= `k`.
    Remove character at `left`. If count becomes 0, decrement distinct count.
Update `maxLen = max(maxLen, right - left + 1)`.

### Complexity / Độ phức tạp
- **Time**: O(N). Each char added/removed at most once. Map ops O(1) (alphabet size const).
- **Space**: O(K) or O(1) if fixed charset.

---

## Analysis / Phân tích

### Approach: HashMap + Sliding Window

**Algorithm**:
1.  Map `count`.
2.  `left = 0`, `maxLen = 0`.
3.  Loop `right` from 0 to N-1:
    - Add `s[right]`.
    - While `map.size() > k`:
        - Remove `s[left]`. If val becomes 0, remove key.
        - `left++`.
    - `maxLen = max(maxLen, right - left + 1)`.

**Edge Cases**:
1.  `k=0`: maxLen=0.

---
