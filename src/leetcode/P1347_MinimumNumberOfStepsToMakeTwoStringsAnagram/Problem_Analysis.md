# 1347. Minimum Number of Steps to Make Two Strings Anagram / Số Bước Tối thiểu để Biến Hai Chuỗi thành Đảo chữ

## Problem Description / Mô tả bài toán
Two strings `s` and `t` of same length.
Change char in `t` is 1 step.
Make `t` an anagram of `s`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Frequency Count
Steps needed = Sum of differences for characters where count in `t` < count in `s`.
Or `(Sum |countS[c] - countT[c]|) / 2`.
Intuition: we only need to change characters that are "excess" in `t` to match "deficit" characters. The number of excess equals number of deficit.
Just sum positive differences `countS[c] - countT[c]` (where result > 0).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) (26 chars).

---

## Analysis / Phân tích

### Approach: Counting Differences
Count frequencies of each character in `s` and `t`. Iterate through 'a' to 'z'. If `countS[char] > countT[char]`, it means `t` is missing `countS[char] - countT[char]` occurrences of this character. We must change some other existing characters in `t` to these missing ones. The total steps equal the sum of these positive differences.
Đếm tần suất của mỗi ký tự trong `s` và `t`. Lặp qua 'a' đến 'z'. Nếu `countS[char] > countT[char]`, điều đó có nghĩa là `t` đang thiếu `countS[char] - countT[char]` lần xuất hiện của ký tự này. Chúng ta phải thay đổi một số ký tự khác hiện có trong `t` thành những ký tự bị thiếu này. Tổng số bước bằng tổng của các chênh lệch dương này.

---
