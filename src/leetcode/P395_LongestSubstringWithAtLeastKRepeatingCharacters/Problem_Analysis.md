# 395. Longest Substring with At Least K Repeating Characters / Chuỗi Con Dài Nhất Có Ít Nhất K Ký Tự Lặp Lại

## Problem Description / Mô tả bài toán
Given a string `s` and an integer `k`, return the length of the longest substring of `s` such that the frequency of each character in this substring is greater than or equal to `k`.
Cho một chuỗi `s` và một số nguyên `k`, hãy trả về độ dài của chuỗi con dài nhất của `s` sao cho tần suất của mỗi ký tự trong chuỗi con này lớn hơn hoặc bằng `k`.

### Example 1:
```text
Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
```

### Example 2:
```text
Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
```

## Constraints / Ràng buộc
- `1 <= s.length <= 10^4`
- `s` consists of only lowercase English letters.
- `1 <= k <= 10^5`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Divide and Conquer / Chia để trị
If a character `c` in `s` appears fewer than `k` times, it cannot be part of any valid substring.
We can split the string by character `c` and recursively find the result in its subsegments.

Algorithm:
1.  Count characters in current segment.
2.  If every character found appears at least `k` times, returns segment length.
3.  Otherwise, find the first character `c` where `count[c] < k`.
4.  Split segment around `c` and return `max` of recursive calls on parts.

### Complexity / Độ phức tạp
- **Time**: Worst case O(N^2) (e.g., string already valid except one char at beginning/end in each step). In average case or with 26 letters, it is effectively O(26 * N).
- **Space**: O(26) recursion depth.

---

## Analysis / Phân tích

### Approach: Divide and Conquer

**Algorithm**:
1.  `helper(s, start, end, k)`:
    - Count char freq in `s[start...end]`.
    - Loop through `count`. If all `cnt >= k`, return `end - start`.
    - Otherwise, find the splitting point.
    - Loop `i` from `start` to `end`:
        - If `count[s.charAt(i)] < k`:
            - return `max(helper(start, i, k), helper(i+1, end, k))`.
2.  Call `helper(0, n, k)`.

---
