# 423. Reconstruct Original Digits from English / Tái Cấu Trúc Các Chữ Số Từ Tiếng Anh

## Problem Description / Mô tả bài toán
Given a string `s` containing an out-of-order English representation of digits `0-9`, return the digits in ascending order.
Cho một chuỗi `s` chứa các chữ số từ `0-9` được viết bằng tiếng Anh và bị xáo trộn thứ tự, hãy trả về các chữ số đó theo thứ tự tăng dần.

The characters are guaranteed to be valid and can be decomposed into original digits.
Các ký tự được đảm bảo là hợp lệ và có thể được phân tách thành các chữ số ban đầu.

The English words for digits are:
- `"zero"`, `"one"`, `"two"`, `"three"`, `"four"`, `"five"`, `"six"`, `"seven"`, `"eight"`, `"nine"`

### Example 1:
```text
Input: s = "owoztneoer"
Output: "012"
```

### Example 2:
```text
Input: s = "fviefuro"
Output: "45"
```

## Constraints / Ràng buộc
- `1 <= s.length <= 10^5`
- `s` consists of lowercase English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Unique Character Frequency Analysis / Phân tích tần suất ký tự duy nhất
Each word in the set {"zero", ..., "nine"} contains characters that are unique to certain digits at different stages of elimination.

1. **Unique at first pass**:
   - `'z'` is unique to `"zero"` (0).
   - `'w'` is unique to `"two"` (2).
   - `'u'` is unique to `"four"` (4).
   - `'x'` is unique to `"six"` (6).
   - `'g'` is unique to `"eight"` (8).
2. **Derived counts**:
   - `'h'` appears in 3 and 8. So `count[3] = freq['h'] - count[8]`.
   - `'f'` appears in 4 and 5. So `count[5] = freq['f'] - count[4]`.
   - `'s'` appears in 6 and 7. So `count[7] = freq['s'] - count[6]`.
   - `'o'` appears in 0, 1, 2, 4. So `count[1] = freq['o'] - count[0] - count[2] - count[4]`.
   - `'i'` appears in 5, 6, 8, 9. So `count[9] = freq['i'] - count[5] - count[6] - count[8]`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `s`.
- **Space**: O(1) as there are only 26 letters and 10 digits to track.

---

## Analysis / Phân tích

### Approach: Frequency Deduction

**Algorithm**:
1.  Count all characters in `s`.
2.  Calculate counts of digits 0-9 using the rules.
3.  Build the result string.

---
